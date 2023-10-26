package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;

public class DescribeMpsUsageDataRequest extends AbstractRequest {
    /**
     * 获取数据起始时间点。格式为：yyyy-MM-ddTHH:mm:ssZ（UTC时间）。
     */
    public String startTime;
    /**
     * 获取数据结束时间点，需晚于起始时间。格式为：yyyy-MM-ddTHH:mm:ssZ（UTC时间）。
     */
    public String endTime;
    /**
     * 存储地域。默认返回所有区域。支持批量查询，多个地域使用半角逗号（,）分隔。取值：华北地区(北京): cn-beijing 
     */
    public String region;
    /**
     * 统计时间粒度。取值：hour：小时。(最大时间范围7天,最长过去30天) day：天。(最大时间范围30天, 最长过去90天)默认按时间跨度决定，小于等于1天以1小时为粒度，大于1天则以天为粒度。
     */
    public String interval;
    /**
     * 媒体处理的分类: Frame: 截图Transcode: 转码AudioEnhance: 音频增强AGC: 响度均衡SDR2HDR: SDR转HDR
     */
    public String processType;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("StartTime", key -> this.startTime);
        map.computeIfAbsent("EndTime", key -> this.endTime);
        map.computeIfAbsent("Region", key -> this.region);
        map.computeIfAbsent("Interval", key -> this.interval);
        map.computeIfAbsent("ProcessType", key -> this.processType);
        return map;
    }

}
