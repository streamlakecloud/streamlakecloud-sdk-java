package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;

public class DescribeStorageUsageDataRequest extends AbstractRequest {
    /**
     * 获取数据起始时间点。格式为：yyyy-MM-ddTHH:mm:ssZ（UTC时间）。
     */
    public String startTime;
    /**
     * 获取数据结束时间点，需晚于起始时间。格式为：yyyy-MM-ddTHH:mm:ssZ（UTC时间）。
     */
    public String endTime;
    /**
     * 存储地域。默认返回所有地域。支持批量查询，多个区域用半角逗号（,）分隔。取值：华北地区(北京): cn-beijing 目前只要华北
     */
    public String region;
    /**
     * 存储桶的名字,暂时还不支持(暂时隐藏掉)
     */
    public String bucket;
    /**
     * 统计时间粒度。取值：5minutes：5分钟 (最大时间范围1天,最长过去7天) hour：小时。(最大时间范围7天,最长过去30天) day：天。(最大时间范围30天, 最长过去90天) 默认按时间跨度决定，小于等于1小时以5分钟为粒度，小于等于1天以1小时为粒度，大于1天则以天为粒度。
     */
    public String interval;

    /**
     * 存储类型，有效值：
     * Normal：按时间粒度Interval聚合
     * Total：时间段内加总的数据
     * 默认为Normal
     */
    public String aggregateType;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("StartTime", key -> this.startTime);
        map.computeIfAbsent("EndTime", key -> this.endTime);
        map.computeIfAbsent("Region", key -> this.region);
        map.computeIfAbsent("Bucket", key -> this.bucket);
        map.computeIfAbsent("Interval", key -> this.interval);
        map.computeIfAbsent("AggregateType", key -> this.aggregateType);
        return map;
    }

}
