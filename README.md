# StreamLake Cloud SDK for Java

StreamLake SDK 是为 Java 编程语言提供的快手视频云（StreamLake）官方 SDK。

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/badge/maven--central-1.0.29-brightgreen.svg)](https://search.maven.org/artifact/com.streamlake/kuaishou-vod-open-sdk-java)

## 目录

- [功能特性](#功能特性)
- [环境要求](#环境要求)
- [安装](#安装)
- [快速开始](#快速开始)
- [核心组件](#核心组件)
- [支持的服务](#支持的服务)
- [使用示例](#使用示例)
- [项目结构](#项目结构)
- [环境配置](#环境配置)
- [贡献](#贡献)
- [许可证](#许可证)

## 功能特性

- ✅ **多服务支持**：VOD（点播）、CDN、AI、IAM、Metric 等多种服务
- ✅ **类型安全**：完整的 Java 类型定义和 Gson 序列化支持
- ✅ **请求签名**：内置 SL-HMAC-SHA256 签名算法
- ✅ **HTTP 客户端**：基于 Apache HttpClient 的高性能 HTTP 客户端
- ✅ **回调支持**：完整的回调事件模型
- ✅ **CDN 鉴权**：支持 URL 鉴权和 Pkey 加密
- ✅ **环境配置**：支持 .env 文件配置管理
- ✅ **示例代码**：提供丰富的使用示例

## 环境要求

- Java 8 或更高版本
- Maven 3.x 或 Gradle

## 安装

### Maven

在 `pom.xml` 中添加以下依赖：

```xml
<dependency>
    <groupId>com.streamlake</groupId>
    <artifactId>kuaishou-vod-open-sdk-java</artifactId>
    <version>1.0.30</version>
</dependency>
```

### Gradle

在 `build.gradle` 中添加：

```gradle
implementation 'com.streamlake:kuaishou-vod-open-sdk-java:1.0.30'
```

## 快速开始

### 1. 创建客户端

对于任何服务（如 VOD、CDN、AI、Metric、IAM），都有对应的客户端类：

```java
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.openapi.client.VodClient;

public class Demo {
    public static void main(String[] args) {
        // 配置 HTTP Profile
        HttpProfile httpProfile = HttpProfile.getDefault();
        
        // 创建认证凭证
        Credential credential = new Credential("your-access-key-id", "your-secret-key");
        
        // 创建 VodClient
        VodClient vodClient = new VodClient(httpProfile, credential);
    }
}
```

### 2. 调用 API

```java
import com.kuaishou.vod.openapi.model.request.vod.FetchUploadRequest;
import com.kuaishou.vod.openapi.model.response.vod.FetchUploadResponse;

// 创建请求
FetchUploadRequest request = new FetchUploadRequest();
request.setSpaceName("your-space-name");
// ... 设置其他参数

// 调用 API
try {
    FetchUploadResponse response = vodClient.fetchUpload(request);
    System.out.println("调用成功: " + response.toJson());
} catch (Exception e) {
    System.err.println("调用失败: " + e.getMessage());
}
```

## 核心组件

### 客户端 (Client)

| 客户端 | 说明 | 用途 |
|--------|------|------|
| `VodClient` | 点播服务客户端 | 视频上传、转码、处理等 |
| `AIClient` | AI 服务客户端 | 视频合成、人脸融合等 |
| `CdnClient` | CDN 服务客户端 | CDN 刷新、预热等 |
| `IamClient` | IAM 服务客户端 | 权限管理 |
| `MetricClient` | 指标服务客户端 | 使用量查询等 |

### 配置类

- **`HttpProfile`**：HTTP 配置，包括端点、超时时间、重试策略等
- **`Credential`**：认证凭证，包含 AccessKeyId 和 SecretKey

### 核心抽象类

- **`AbstractClient`**：所有客户端的基类，提供请求签名和 HTTP 调用功能
- **`AbstractRequest`**：所有请求类的基类
- **`AbstractResponse`**：所有响应类的基类

## 支持的服务

### VOD（点播服务）

<details>
<summary>点击展开 VOD API 列表</summary>

- `applyUploadInfo` - 申请上传信息
- `commitUpload` - 提交上传
- `fetchUpload` - 拉取上传
- `fetchStore` - 拉取存储
- `describeFetchJobs` - 查询拉取任务
- `describeMediaInfo` - 查询媒体信息
- `processMedia` - 处理媒体
- `deleteMedia` - 删除媒体
- `detectMedia` - 媒体检测
- `enhanceMedia` - 媒体增强
- `submitProcessingFlow` - 提交处理流程
- `submitMediaProcessJobs` - 提交媒体处理任务
- `submitOmniFusionTask` - 提交全景融合任务
- `listDanmakuPreAudit` - 弹幕预审列表
- `updateDanamkuAuditResult` - 更新弹幕审核结果
- `describeMediaProcessJob` - 查询媒体处理任务
- `listMediaProcessJob` - 列出媒体处理任务

</details>

### CDN（内容分发服务）

- `refresh` - 刷新缓存
- `preload` - 预热
- `queryStatus` - 查询状态
- `listUserDomains` - 列出用户域名
- `pushPCDNObjectCache` - 推送 PCDN 对象缓存

### AI（人工智能服务）

- `composeVideo` - 视频合成
- `blendFace` - 人脸融合

### IAM（身份与访问管理）

- `assumeRole` - 角色扮演

### Metric（指标服务）

- `describeStorageUsageData` - 查询存储用量
- `describeMpsUsageData` - 查询媒体处理用量
- `describeDomainUsageData` - 查询域名用量

## 使用示例

### 示例 1: 拉取视频上传

```java
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.openapi.client.VodClient;
import com.kuaishou.vod.openapi.model.request.vod.FetchUploadRequest;
import com.kuaishou.vod.openapi.model.request.vod.URLSet;
import com.kuaishou.vod.openapi.model.response.vod.FetchUploadResponse;

import java.util.ArrayList;
import java.util.List;

public class FetchUploadExample {
    public static void main(String[] args) throws Exception {
        // 创建客户端
        Credential credential = new Credential("your-access-key-id", "your-secret-key");
        VodClient vodClient = new VodClient(HttpProfile.getDefault(), credential);
        
        // 创建请求
        FetchUploadRequest request = new FetchUploadRequest();
        request.setSpaceName("your-space-name");
        
        // 设置 URL 列表
        List<URLSet> urlSetList = new ArrayList<>();
        URLSet urlSet = new URLSet();
        urlSet.setSourceUrl("https://example.com/video.mp4");
        urlSetList.add(urlSet);
        request.setUrlSets(urlSetList);
        
        // 调用 API
        FetchUploadResponse response = vodClient.fetchUpload(request);
        System.out.println("响应: " + response.toJson());
    }
}
```

### 示例 2: 提交全景融合任务

```java
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.*;
import com.kuaishou.vod.openapi.model.response.vod.SubmitOmniFusionTaskResponse;

public class OmniFusionExample {
    public static void main(String[] args) throws Exception {
        VodClient vodClient = createClient(); // 创建客户端
        
        // 创建请求
        SubmitOmniFusionTaskRequest request = new SubmitOmniFusionTaskRequest();
        request.setBizKey("CYBERCUT_TEST_TOB");
        request.setCallbackUrl("https://your-callback-url.com/callback");
        request.setTemplateId("template1");
        
        // 设置媒体源
        List<MediaSource> mediaSourceList = new ArrayList<>();
        MediaSource media = new MediaSource();
        media.setMediaType("video");
        media.setMediaId("your-media-id");
        mediaSourceList.add(media);
        request.setMediaSource(mediaSourceList);
        
        // 设置输出配置
        OutputConfig outputConfig = new OutputConfig();
        outputConfig.setOutputFormat("mp4");
        outputConfig.setQuality("high");
        request.setOutputConfig(outputConfig);
        
        // 设置视频生成请求
        VideoGenerationRequest videoGenRequest = new VideoGenerationRequest();
        videoGenRequest.setProductTitle("产品标题");
        videoGenRequest.setExpectedDuration(30);
        request.setVideoGenerationRequest(videoGenRequest);
        
        // 调用 API
        SubmitOmniFusionTaskResponse response = vodClient.submitOmniFusionTask(request);
        System.out.println("任务提交成功: " + response.toJson());
    }
}
```

### 示例 3: CDN URL 签名

```java
import com.kuaishou.vod.core.cdn.CdnClient;
import com.kuaishou.vod.core.cdn.ExtraInfo;

public class CdnSignExample {
    public static void main(String[] args) throws Exception {
        // 创建 CDN 客户端
        CdnClient cdnClient = new CdnClient("your-key", "your-iv");
        
        // 创建额外信息
        ExtraInfo extraInfo = ExtraInfo.builder()
            .ttl(3600)
            .clientIp("192.168.1.1")
            .build();
        
        // 签名 URL
        String originalUrl = "https://example.com/video.mp4";
        String signedUrl = cdnClient.signCdnUrl(originalUrl, extraInfo);
        System.out.println("签名后的 URL: " + signedUrl);
    }
}
```

## 项目结构

```
src/main/java/com/kuaishou/vod/
├── base/                    # 基础工具类
│   ├── Constant.java       # 常量定义
│   ├── SignatureHelper.java # 签名帮助类
│   └── SignatureVO.java    # 签名值对象
├── core/                    # 核心功能
│   ├── AbstractClient.java # 抽象客户端基类
│   ├── AbstractRequest.java # 抽象请求基类
│   ├── AbstractResponse.java # 抽象响应基类
│   ├── Credential.java     # 认证凭证
│   ├── HttpProfile.java    # HTTP 配置
│   ├── HttpClient.java     # HTTP 客户端
│   ├── Sign.java           # 签名工具
│   ├── cdn/                # CDN 相关工具
│   ├── play/               # 播放相关工具
│   └── exception/          # 异常定义
├── openapi/                 # OpenAPI 实现
│   ├── client/             # 客户端实现
│   │   ├── AIClient.java
│   │   ├── CdnClient.java
│   │   ├── IamClient.java
│   │   ├── MetricClient.java
│   │   └── VodClient.java
│   └── model/              # 数据模型
│       ├── request/        # 请求模型
│       │   ├── ai/        # AI 请求
│       │   ├── cdn/       # CDN 请求
│       │   ├── iam/       # IAM 请求
│       │   └── vod/       # VOD 请求
│       ├── response/       # 响应模型
│       │   ├── ai/        # AI 响应
│       │   ├── cdn/       # CDN 响应
│       │   ├── iam/       # IAM 响应
│       │   └── vod/       # VOD 响应
│       └── callback/       # 回调事件模型
└── example/                # 使用示例
    ├── FetchUploadExample.java
    └── SubmitOmniFusionTaskExample.java
```

## 环境配置

### 使用 .env 文件

推荐使用 `.env` 文件管理敏感配置：

1. 在项目根目录创建 `.env` 文件：

```properties
# StreamLake Cloud SDK 配置
ACCESS_KEY_ID=your-access-key-id
SECRET_KEY=your-secret-key
SPACE_NAME=your-space-name
```

2. 在代码中使用：

```java
import io.github.cdimascio.dotenv.Dotenv;

public class Example {
    public static void main(String[] args) {
        // 加载 .env 文件
        Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();
        
        // 读取配置
        String accessKeyId = dotenv.get("ACCESS_KEY_ID");
        String secretKey = dotenv.get("SECRET_KEY");
        
        // 创建凭证
        Credential credential = new Credential(accessKeyId, secretKey);
    }
}
```

3. 添加 dotenv 依赖（如果需要）：

```xml
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>2.3.2</version>
</dependency>
```

### HTTP 配置

可以自定义 HTTP 配置：

```java
HttpProfile httpProfile = HttpProfile.getDefault();
httpProfile.setEndPoint("vod.streamlakeapi.com");
httpProfile.setConnectionTimeout(5000);  // 连接超时 (ms)
httpProfile.setSocketTimeout(10000);      // 读取超时 (ms)
httpProfile.setRequestRetryEnabled(true); // 启用重试
httpProfile.setRequestRetryTimes(3);      // 重试次数
```

## 回调处理

SDK 提供了完整的回调事件模型，支持处理异步任务的回调通知：

```java
import com.kuaishou.vod.core.AbstractEvent;
import com.kuaishou.vod.openapi.model.callback.*;

// 解析回调事件
String callbackJson = "..."; // 接收到的回调 JSON
AbstractEvent event = AbstractEvent.fromJson(callbackJson);

// 根据事件类型处理
if (event instanceof VideoUploadEvent) {
    VideoUploadEvent uploadEvent = (VideoUploadEvent) event;
    // 处理上传完成事件
} else if (event instanceof VideoTranscodeEvent) {
    VideoTranscodeEvent transcodeEvent = (VideoTranscodeEvent) event;
    // 处理转码完成事件
}
```

## 错误处理

SDK 提供了统一的异常处理：

```java
try {
    FetchUploadResponse response = vodClient.fetchUpload(request);
} catch (KuaishouVodSdkException e) {
    // SDK 异常
    System.err.println("错误码: " + e.getErrorCode());
    System.err.println("错误信息: " + e.getMessage());
} catch (IOException e) {
    // IO 异常
    System.err.println("网络错误: " + e.getMessage());
}
```

## 贡献

欢迎贡献代码！请遵循以下步骤：

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

## 许可证

本项目采用 [Apache License 2.0](LICENSE) 许可证。

## 联系我们

- 官网：[https://www.streamlake.com](https://www.streamlake.com)
- 文档：[https://docs.streamlake.com](https://docs.streamlake.com)
- GitHub：[https://github.com/streamlakecloud/streamlakecloud-sdk-java](https://github.com/streamlakecloud/streamlakecloud-sdk-java)

## 更新日志

### v1.0.29
- 添加 SubmitOmniFusionTask API 支持
- 优化 HTTP 客户端配置
- 改进错误处理机制
- 添加更多使用示例

---

**注意**: 本 SDK 仍在持续开发中，API 可能会有变化。请关注更新日志并及时更新到最新版本。
