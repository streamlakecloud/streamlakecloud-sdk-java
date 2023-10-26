package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;

public class DescribeDomainUsageDataRequest extends AbstractRequest {
    /**
     * 加速域名。若参数为空，默认返回所有加速域名合并后数据。支持批量查询(去重)，多个用半角逗号（,）分隔。(主域名)
     */
    public String domainName;
    /**
     * 获取数据起始时间点。格式为：yyyy-MM-ddTHH:mm:ssZ（UTC时间）。
     */
    public String startTime;
    /**
     * 获取数据结束时间点，需晚于起始时间。格式为：yyyy-MM-ddTHH:mm:ssZ（UTC时间）。
     */
    public String endTime;
    /**
     * 统计时间粒度。取值：5minutes：5分钟 (最大时间范围1天,最长过去7天) hour：小时。(最大时间范围7天,最长过去30天) day：天。(最大时间范围30天, 最长过去90天)默认按时间跨度决定，小于等于1小时以5分钟为粒度，小于等于1天以1小时为粒度，大于1天则以天为粒度。
     */
    public String interval;
    /**
     * 查询95峰值, 可选值：DomesticBps, OverseaBps, TotalBps, 返回值在返回记录UsageDataItem对应字段中
     */
    public String percentile;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("DomainName", key -> this.domainName);
        map.computeIfAbsent("StartTime", key -> this.startTime);
        map.computeIfAbsent("EndTime", key -> this.endTime);
        map.computeIfAbsent("Interval", key -> this.interval);
        map.computeIfAbsent("Percentile", key -> this.percentile);
        return map;
    }

}
