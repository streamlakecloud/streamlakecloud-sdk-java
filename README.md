# StreamLake Cloud SDK for Java

[English](README.md) | 简体中文

The official Java SDK for [StreamLake](https://www.streamlake.com), Kuaishou's enterprise video cloud platform. [CyberCut](https://cybercut.ai) is an AI-powered video creation platform built on StreamLake — capabilities such as Omni Fusion in this SDK are designed for CyberCut workflow integration.

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/badge/maven--central-1.0.33-brightgreen.svg)](https://search.maven.org/artifact/com.streamlake/kuaishou-vod-open-sdk-java)

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Quick Start](#quick-start)
- [Core Components](#core-components)
- [Supported Services](#supported-services)
- [Usage Examples](#usage-examples)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## Features

- ✅ **Multi-service support**: VOD, CDN, AI, IAM, Metric, and more
- ✅ **Type-safe**: Full Java type definitions with Gson serialization
- ✅ **Request signing**: Built-in SL-HMAC-SHA256 signature algorithm
- ✅ **HTTP client**: High-performance client based on Apache HttpClient
- ✅ **Callback support**: Complete callback event models
- ✅ **CDN authentication**: URL signing and Pkey encryption
- ✅ **Environment config**: `.env` file support for credential management
- ✅ **Examples**: Rich sample code for common use cases

## Requirements

- Java 8 or later
- Maven 3.x or Gradle

## Installation

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.streamlake</groupId>
    <artifactId>kuaishou-vod-open-sdk-java</artifactId>
    <version>1.0.33</version>
</dependency>
```

### Gradle

Add to your `build.gradle`:

```gradle
implementation 'com.streamlake:kuaishou-vod-open-sdk-java:1.0.33'
```

## Quick Start

### 1. Create a Client

Each service (VOD, CDN, AI, Metric, IAM) has a dedicated client class:

```java
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.openapi.client.VodClient;

public class Demo {
    public static void main(String[] args) {
        HttpProfile httpProfile = HttpProfile.getDefault();
        Credential credential = new Credential("your-access-key-id", "your-secret-key");
        VodClient vodClient = new VodClient(httpProfile, credential);
    }
}
```

### 2. Call an API

```java
import com.kuaishou.vod.openapi.model.request.vod.FetchUploadRequest;
import com.kuaishou.vod.openapi.model.response.vod.FetchUploadResponse;

FetchUploadRequest request = new FetchUploadRequest();
request.setSpaceName("your-space-name");
// ... set other parameters

try {
    FetchUploadResponse response = vodClient.fetchUpload(request);
    System.out.println("Success: " + response.toJson());
} catch (Exception e) {
    System.err.println("Failed: " + e.getMessage());
}
```

## Core Components

### Clients

| Client | Description | Use Case |
|--------|-------------|----------|
| `VodClient` | Video-on-demand client | Upload, transcode, media processing |
| `AIClient` | AI service client | Video composition, face blending |
| `CdnClient` | CDN client | Cache refresh, preload |
| `IamClient` | IAM client | Access management |
| `MetricClient` | Metrics client | Usage queries |

### Configuration

- **`HttpProfile`**: HTTP settings — endpoint, timeouts, retry policy
- **`Credential`**: Authentication credentials (AccessKeyId and SecretKey)

### Base Classes

- **`AbstractClient`**: Base class for all clients — signing and HTTP calls
- **`AbstractRequest`**: Base class for all request models
- **`AbstractResponse`**: Base class for all response models

## Supported Services

### VOD (Video on Demand)

<details>
<summary>Click to expand VOD API list</summary>

- `applyUploadInfo` - Apply for upload credentials
- `commitUpload` - Commit upload
- `fetchUpload` - Fetch upload from URL
- `fetchStore` - Fetch to storage
- `describeFetchJobs` - Query fetch jobs
- `describeMediaInfo` - Query media info
- `processMedia` - Process media
- `deleteMedia` - Delete media
- `detectMedia` - Media detection
- `enhanceMedia` - Media enhancement
- `submitProcessingFlow` - Submit processing flow
- `submitMediaProcessJobs` - Submit media processing jobs
- `submitOmniFusionTask` - Submit multimodal fusion task (CyberCut)
- `queryOmniFusionTask` - Query multimodal fusion task status
- `listDanmakuPreAudit` - List danmaku pre-audit
- `updateDanamkuAuditResult` - Update danmaku audit result
- `describeMediaProcessJob` - Query media processing job
- `listMediaProcessJob` - List media processing jobs

</details>

### CDN (Content Delivery Network)

- `refresh` - Refresh cache
- `preload` - Preload content
- `queryStatus` - Query status
- `listUserDomains` - List user domains
- `pushPCDNObjectCache` - Push PCDN object cache

### AI (Artificial Intelligence)

- `composeVideo` - Video composition
- `blendFace` - Face blending

### IAM (Identity and Access Management)

- `assumeRole` - Assume role

### Metric

- `describeStorageUsageData` - Query storage usage
- `describeMpsUsageData` - Query media processing usage
- `describeDomainUsageData` - Query domain usage

## Usage Examples

### Example 1: Fetch Upload

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
        Credential credential = new Credential("your-access-key-id", "your-secret-key");
        VodClient vodClient = new VodClient(HttpProfile.getDefault(), credential);

        FetchUploadRequest request = new FetchUploadRequest();
        request.setSpaceName("your-space-name");

        List<URLSet> urlSetList = new ArrayList<>();
        URLSet urlSet = new URLSet();
        urlSet.setSourceUrl("https://example.com/video.mp4");
        urlSetList.add(urlSet);
        request.setUrlSets(urlSetList);

        FetchUploadResponse response = vodClient.fetchUpload(request);
        System.out.println("Response: " + response.toJson());
    }
}
```

### Example 2: Submit Omni Fusion Task (AUTO_GENERATE Mode)

```java
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.*;
import com.kuaishou.vod.openapi.model.response.vod.SubmitOmniFusionTaskResponse;

public class OmniFusionExample {
    public static void main(String[] args) throws Exception {
        VodClient vodClient = createClient();

        SubmitOmniFusionTaskRequest request = new SubmitOmniFusionTaskRequest();
        request.setBizKey("CYBERCUT_TEST_TOB");
        request.setCallbackUrl("https://your-callback-url.com/callback");
        request.setTemplateId("template1");

        // AUTO_GENERATE mode does not allow audio in media_source
        List<MediaSource> mediaSourceList = new ArrayList<>();
        MediaSource media = new MediaSource();
        media.setMediaType(MediaType.VIDEO);
        media.setMediaId("your-media-id");
        mediaSourceList.add(media);
        request.setMediaSource(mediaSourceList);

        OutputConfig outputConfig = new OutputConfig();
        outputConfig.setOutputFormat("mp4");
        outputConfig.setQuality(Quality.HIGH);
        request.setOutputConfig(outputConfig);

        VideoGenerationRequest videoGenRequest = new VideoGenerationRequest();
        videoGenRequest.setGenerationType(GenerationType.AUTO_GENERATE);
        videoGenRequest.setProductTitle("Product Title");
        videoGenRequest.setProductDescription("Product Description");
        videoGenRequest.setExpectedDuration(30);
        videoGenRequest.setEnableSubtitle(true);
        request.setVideoGenerationRequest(videoGenRequest);

        SubmitOmniFusionTaskResponse response = vodClient.submitOmniFusionTask(request);
        System.out.println("Task submitted: " + response.toJson());
    }
}
```

### Example 3: Submit Omni Fusion Task (USER_SCRIPT Mode)

```java
// USER_SCRIPT mode: use a user-provided script; audio media is required
SubmitOmniFusionTaskRequest request = new SubmitOmniFusionTaskRequest();
request.setBizKey("CYBERCUT_TEST_TOB");
request.setCallbackUrl("https://your-callback-url.com/callback");

List<MediaSource> mediaSourceList = new ArrayList<>();

MediaSource video = new MediaSource();
video.setMediaType(MediaType.VIDEO);
video.setMediaId("video-media-id");
mediaSourceList.add(video);

MediaSource audio = new MediaSource();
audio.setMediaType(MediaType.AUDIO);  // At most one audio asset
audio.setMediaId("audio-media-id");
mediaSourceList.add(audio);

request.setMediaSource(mediaSourceList);

VideoGenerationRequest videoGenRequest = new VideoGenerationRequest();
videoGenRequest.setGenerationType(GenerationType.USER_SCRIPT);
videoGenRequest.setSourceScript("User script content, matching the audio...");
request.setVideoGenerationRequest(videoGenRequest);

SubmitOmniFusionTaskResponse response = vodClient.submitOmniFusionTask(request);
```

### Example 4: Query Omni Fusion Task Status

```java
import com.kuaishou.vod.openapi.model.request.vod.QueryOmniFusionTaskRequest;
import com.kuaishou.vod.openapi.model.response.vod.QueryOmniFusionTaskResponse;
import com.kuaishou.vod.openapi.model.response.vod.QueryOmniFusionTaskResponse.*;

QueryOmniFusionTaskRequest request = new QueryOmniFusionTaskRequest();
request.setTaskId("your-task-id");

QueryOmniFusionTaskResponse response = vodClient.queryOmniFusionTask(request);
ResponseData data = response.getResponseData();

if (WorkflowStatus.COMPLETED.equals(data.getWorkflowStatus())) {
    String videoUrl = data.getResultData().getVideo().getUrl();
    System.out.println("Video URL: " + videoUrl);
} else if (WorkflowStatus.RUNNING.equals(data.getWorkflowStatus())) {
    System.out.println("Progress: " + data.getProgress() + "%");
}
```

### Example 5: Query Media Info

```java
import com.kuaishou.vod.openapi.model.request.vod.DescribeMediaInfoRequest;
import com.kuaishou.vod.openapi.model.response.vod.DescribeMediaInfoResponse;

DescribeMediaInfoRequest request = new DescribeMediaInfoRequest();
request.setMediaId("your-media-id");
// Optional filter:
// request.setFilters("basicInfo,sourceInfo,transCodeInfo");

DescribeMediaInfoResponse response = vodClient.describeMediaInfo(request);
System.out.println("Media info: " + response.toJson());
```

### Example 6: CDN URL Signing

```java
import com.kuaishou.vod.core.cdn.CdnClient;
import com.kuaishou.vod.core.cdn.ExtraInfo;

public class CdnSignExample {
    public static void main(String[] args) throws Exception {
        CdnClient cdnClient = new CdnClient("your-key", "your-iv");

        ExtraInfo extraInfo = ExtraInfo.builder()
            .ttl(3600)
            .clientIp("192.168.1.1")
            .build();

        String originalUrl = "https://example.com/video.mp4";
        String signedUrl = cdnClient.signCdnUrl(originalUrl, extraInfo);
        System.out.println("Signed URL: " + signedUrl);
    }
}
```

## Project Structure

```
src/main/java/com/kuaishou/vod/
├── base/                    # Utilities
│   ├── Constant.java
│   ├── SignatureHelper.java
│   └── SignatureVO.java
├── core/                    # Core functionality
│   ├── AbstractClient.java
│   ├── AbstractRequest.java
│   ├── AbstractResponse.java
│   ├── Credential.java
│   ├── HttpProfile.java
│   ├── HttpClient.java
│   ├── Sign.java
│   ├── cdn/
│   ├── play/
│   └── exception/
├── openapi/
│   ├── client/
│   │   ├── AIClient.java
│   │   ├── CdnClient.java
│   │   ├── IamClient.java
│   │   ├── MetricClient.java
│   │   └── VodClient.java
│   └── model/
│       ├── request/
│       ├── response/
│       └── callback/
└── example/
    ├── FetchUploadExample.java
    ├── DescribeMediaInfoExample.java
    ├── SubmitOmniFusionTaskExample.java
    └── QueryOmniFusionTaskExample.java
```

## Configuration

### Using a `.env` File

We recommend managing credentials via a `.env` file:

1. Create a `.env` file in the project root:

```properties
# StreamLake Cloud SDK
ACCESS_KEY_ID=your-access-key-id
SECRET_KEY=your-secret-key
SPACE_NAME=your-space-name
```

2. Load it in code:

```java
import io.github.cdimascio.dotenv.Dotenv;

public class Example {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

        String accessKeyId = dotenv.get("ACCESS_KEY_ID");
        String secretKey = dotenv.get("SECRET_KEY");
        Credential credential = new Credential(accessKeyId, secretKey);
    }
}
```

3. Add the dotenv dependency if needed:

```xml
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>2.3.2</version>
</dependency>
```

### HTTP Configuration

Customize HTTP settings as needed:

```java
HttpProfile httpProfile = HttpProfile.getDefault();
httpProfile.setEndPoint("vod.streamlakeapi.com");
httpProfile.setConnectionTimeout(5000);  // Connection timeout (ms)
httpProfile.setSocketTimeout(10000);     // Read timeout (ms)
httpProfile.setRequestRetryEnabled(true);
httpProfile.setRequestRetryTimes(3);
```

## Callback Handling

The SDK provides complete callback event models for async task notifications:

```java
import com.kuaishou.vod.core.AbstractEvent;
import com.kuaishou.vod.openapi.model.callback.*;

String callbackJson = "..."; // Received callback JSON
AbstractEvent event = AbstractEvent.fromJson(callbackJson);

if (event instanceof VideoUploadEvent) {
    VideoUploadEvent uploadEvent = (VideoUploadEvent) event;
    // Handle upload completion
} else if (event instanceof VideoTranscodeEvent) {
    VideoTranscodeEvent transcodeEvent = (VideoTranscodeEvent) event;
    // Handle transcode completion
}
```

## Error Handling

```java
try {
    FetchUploadResponse response = vodClient.fetchUpload(request);
} catch (KuaishouVodSdkException e) {
    System.err.println("Error code: " + e.getErrorCode());
    System.err.println("Error message: " + e.getMessage());
} catch (IOException e) {
    System.err.println("Network error: " + e.getMessage());
}
```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the [Apache License 2.0](LICENSE).

## Contact

- StreamLake: [https://www.streamlake.com](https://www.streamlake.com)
- CyberCut: [https://cybercut.ai](https://cybercut.ai)
- Documentation: [https://docs.streamlake.com](https://docs.streamlake.com)
- GitHub: [https://github.com/streamlakecloud/streamlakecloud-sdk-java](https://github.com/streamlakecloud/streamlakecloud-sdk-java)

## Changelog

### v1.0.33
- Added `enable_subtitle` field to `video_generation_request` in `SubmitOmniFusionTask` to control subtitle generation (defaults to `true` on the server)

### v1.0.31
- Added `QueryOmniFusionTask` API for polling multimodal fusion task status
- Added `generation_type` to `SubmitOmniFusionTask` — supports `AUTO_GENERATE` and `USER_SCRIPT` modes
- Added `source_script` field for user script mode
- Added `vhuman_config` for virtual human configuration
- Added `audio` media type support in `SubmitOmniFusionTask`
- Added `MediaIds` field to `FetchUploadResponse`
- Added `DescribeMediaInfoExample` and `QueryOmniFusionTaskExample`
- Added constant classes: `GenerationType`, `MediaType`, `OutputFormat`, `Quality`, `WorkflowStatus`

### v1.0.30
- Added `SubmitOmniFusionTask` API support
- Improved HTTP client configuration
- Enhanced error handling
- Added more usage examples

---

**Note**: This SDK is under active development. APIs may change — please check the changelog and keep up to date.
