# media-cloud-vod-open-sdk-go

StreamLake SDK for the Java programming language.

## NOTICE

The java SDK is still in early staging.

## Convention

For any `{Service}` like AI, CDN, Metric or VOD, there will be a `{Service}Client`.

```java
public class Demo {
    public void createVodClient() {
        HttpProfile profile = HttpProfile.getDefault();
        profile.setEndPoint(Constant.OPENAPI_HOST);
        Credential credential = new Credential(Constant.ACCESS_KEY_ID_STAGE, Constant.ACCESS_KEY_SECRET_STAGE);
        VodClient client = new VodClient(profile, credential);
    }
}
```