package com.kuaishou.vod.core.cdn;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ThreadLocalRandom;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Shorts;

public class DefaultPkeyFormat extends AbstractPkeyFormat {
    private static final byte[] VERSION = new byte[] {0x00, 0x05};
    private static final byte[] DEFAULT_SERVICE_ID = new byte[] {0x00, 0x00};

    private static class Holder {
        static final DefaultPkeyFormat INSTANCE = new DefaultPkeyFormat();
    }

    public static DefaultPkeyFormat getInstance() {
        return DefaultPkeyFormat.Holder.INSTANCE;
    }

    @Override
    byte[] pkeyData(PkeyRequest request) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(Ints.toByteArray(ThreadLocalRandom.current().nextInt()));
        outputStream.write(Ints.toByteArray((int) currentTimeSecond()));
        outputStream.write(Ints.toByteArray(ttl(request.getTtl())));
        outputStream.write(request.getServiceId() > 0
                           ? Shorts.toByteArray(request.getServiceId()) : DEFAULT_SERVICE_ID);
        outputStream.write(request.getPlatformId());
        outputStream.write(Ints.toByteArray(pathCrc32(request.getUri())));
        outputStream.write(Shorts.toByteArray(request.getLimitSpeeds()));
        outputStream.write(Shorts.toByteArray(request.getLimitTimeSeconds()));
        outputStream.write(Shorts.toByteArray(request.getLimitTSIdx()));
        String gid = request.getGid() == null ? "" : request.getGid();
        outputStream.write(Shorts.toByteArray((short) gid.length()));
        outputStream.write(gid.getBytes());
        writeIpAddress(outputStream, request.getIpAddress());
        byte[] bytes = outputStream.toByteArray();
        int crc32 = crc32(bytes, 0, bytes.length);
        outputStream.write(Ints.toByteArray(crc32));
        return  ByteBuffer.wrap(outputStream.toByteArray()).array();
    }

    @Override
    byte[] version() {
        return VERSION;
    }
}
