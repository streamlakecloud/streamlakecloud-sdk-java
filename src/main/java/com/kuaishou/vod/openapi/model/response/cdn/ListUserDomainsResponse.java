package com.kuaishou.vod.openapi.model.response.cdn;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

public class ListUserDomainsResponse extends AbstractResponse {
    public ListUserDomainsResponse(Class aClass) {
        super(aClass);
    }

    @SerializedName("ResponseData")
    @Expose
    public ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public static class ResponseData {
        @SerializedName("Offset")
        @Expose
        public int offset;

        @SerializedName("Limit")
        @Expose
        public int limit;

        @SerializedName("TotalCount")
        @Expose
        public int totalCount;

        @SerializedName("DomainInfos")
        @Expose
        public List<DomainInfo> domainInfoList;

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<DomainInfo> getDomainInfoList() {
            return domainInfoList;
        }

        public void setDomainInfoList(
            List<DomainInfo> domainInfoList) {
            this.domainInfoList = domainInfoList;
        }
    }



    public static class DomainInfo {
        @SerializedName("DomainName")
        @Expose
        public String domainName;

        @SerializedName("CreateTime")
        @Expose
        public Long createTime;

        @SerializedName("UpdateTime")
        @Expose
        public Long updateTime;

        @SerializedName("CdnType")
        @Expose
        public String cdnType;

        @SerializedName("SslProtocol")
        @Expose
        public String sslProtocol;

        @SerializedName("Ipv6")
        @Expose
        public Boolean isIpv6;

        @SerializedName("Cname")
        @Expose
        public String cname;

        @SerializedName("DomainStatus")
        @Expose
        public String domainStatus;

        public String getDomainName() {
            return domainName;
        }

        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        public String getCdnType() {
            return cdnType;
        }

        public void setCdnType(String cdnType) {
            this.cdnType = cdnType;
        }

        public String getSslProtocol() {
            return sslProtocol;
        }

        public void setSslProtocol(String sslProtocol) {
            this.sslProtocol = sslProtocol;
        }

        public Boolean getIpv6() {
            return isIpv6;
        }

        public void setIpv6(Boolean ipv6) {
            isIpv6 = ipv6;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getDomainStatus() {
            return domainStatus;
        }

        public void setDomainStatus(String domainStatus) {
            this.domainStatus = domainStatus;
        }
    }
}
