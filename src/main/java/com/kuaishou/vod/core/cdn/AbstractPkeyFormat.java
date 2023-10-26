package com.kuaishou.vod.core.cdn;
import java.io.ByteArrayOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import java.util.zip.CRC32;

import javax.validation.constraints.NotNull;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

import com.google.common.primitives.Bytes;


public abstract class AbstractPkeyFormat {

    private static final int AES_KEY_SIZE = 32;
    private static final int AES_IV_SIZE = 16;
    private static final byte IPV4_FLAG = 0x00;
    private static final byte IPV6_FLAG = 0x01;
    private static final int DEFAULT_TTL = 6 * 60 * 60;
    public static final byte[] DEFAULT_IP = new byte[16];
    public static final byte[] BYTES_12 = new byte[12];


    public AbstractPkeyFormat() {
    }

    public String format(PkeyRequest request) throws Exception {
        Objects.requireNonNull(request, "pkey request must not be null");
        byte[] pkeyData = pkeyData(request);
        byte[] encBytes = encryptAES256(request.getCryptoKey(), pkeyData);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(Bytes.concat(version(), encBytes));
    }

    byte[] encryptAES256(PkeyRequest.CryptoKey cryptoKey, byte[] plainText) {
        byte[] aesKey = hexStringToBytes(cryptoKey.getAesKey());
        byte[] aesIv = hexStringToBytes(cryptoKey.getAesIv());
        if (aesKey.length != AES_KEY_SIZE) {
            throw new IllegalArgumentException("aes key size is invalid");
        }
        if (aesIv.length != AES_IV_SIZE) {
            throw new IllegalArgumentException("aes iv size is invalid");
        }
        try {
            ParametersWithIV paramWithIV = new ParametersWithIV(
                    new KeyParameter(aesKey, 0, aesKey.length), aesIv, 0, aesIv.length);
            return aesCBC256Encrypt(plainText, 0, plainText.length, paramWithIV);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected int ttl(int ttl) {
        return ttl > 0 ? ttl : DEFAULT_TTL;
    }

    void writeIpAddress(ByteArrayOutputStream outputStream, InetAddress ipAddress) throws Exception {
        if (ipAddress == null) {
            outputStream.write(IPV4_FLAG);
            outputStream.write(DEFAULT_IP);
        } else {
            if (ipAddress instanceof Inet4Address) {
                outputStream.write(IPV4_FLAG);
                outputStream.write(ipAddress.getAddress());
                outputStream.write(BYTES_12);
            } else {
                outputStream.write(IPV6_FLAG);
                outputStream.write(ipAddress.getAddress());
            }
        }
    }

    long currentTimeSecond() {
        return System.currentTimeMillis() / 1000L;
    }

    int pathCrc32(URI uri) {
        // 从URL的path开始（即域名之后的第一个'/'开始），到path中出现的第一个'.'为止（不包含'.'）
        String path = uri.getPath();
        byte[] bytes;
        if (path.contains(".")) {
            String urlWithoutSuffix = path.substring(0, path.indexOf("."));
            bytes = urlWithoutSuffix.getBytes();
        } else {
            bytes = path.getBytes();
        }
        return crc32(bytes, 0, bytes.length);
    }

    int crc32(byte[] value, int offset, int length) {
        CRC32 crc32 = new CRC32();
        crc32.update(value, offset, length);
        return (int) crc32.getValue();
    }

    byte[] aesCBC256Encrypt(@NotNull byte[] plainText, int plainTextOff, int plainTextLen, ParametersWithIV aesParam) {
        Objects.requireNonNull(plainText, "plainText must not be null");
        Objects.requireNonNull(aesParam, "aesParam must not be null");
        try {
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
                    new CBCBlockCipher(new AESEngine()), new ZeroBytePadding());
            cipher.reset();
            cipher.init(true, aesParam);
            byte[] buffer = new byte[cipher.getOutputSize(plainText.length)];
            int len = cipher.processBytes(plainText, plainTextOff, plainTextLen, buffer, 0);
            len += cipher.doFinal(buffer, len);

            //TODO(opt): do we really need copyOfRange?
            if (buffer.length != len) {
                buffer = Arrays.copyOfRange(buffer, 0, len);
            }
            return buffer;
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    byte[] hexStringToBytes(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input string is empty");
        } else if ((input.length() & 1) == 1) {
            throw new IllegalArgumentException("input string length is odd.");
        } else {
            byte[] bytes = input.getBytes(StandardCharsets.US_ASCII);
            int len = bytes.length / 2;
            byte[] result = new byte[len];
            for (int i = 0; i < len; i++) {
                int high = asciiToByte(bytes[i * 2]);
                int low = asciiToByte(bytes[i * 2 + 1]);

                result[i] = (byte) ((high << 4) + low);
            }
            return result;
        }
    }

    byte asciiToByte(byte charLiteral) {
        if (charLiteral >= '0' && charLiteral <= '9') {
            return (byte) (charLiteral - '0');
        } else if (charLiteral >= 'A' && charLiteral <= 'F') {
            return (byte) (0x0a + charLiteral - 'A');
        } else if (charLiteral >= 'a' && charLiteral <= 'f') {
            return (byte) (0x0a + charLiteral - 'a');
        } else {
            throw new IllegalArgumentException("not an hexadecimal char.");
        }
    }

    abstract byte[] version();

    abstract byte[] pkeyData(PkeyRequest request) throws Exception;
}
