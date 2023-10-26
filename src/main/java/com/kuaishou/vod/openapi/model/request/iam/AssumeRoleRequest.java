package com.kuaishou.vod.openapi.model.request.iam;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class AssumeRoleRequest extends AbstractRequest {

    @SerializedName("TargetCustomerId")
    @Expose
    public String customerId;
    @SerializedName("RoleName")
    @Expose
    public String roleName;
    @SerializedName("RoleArn")
    @Expose
    public String roleArn;
    @SerializedName("RoleSessionName")
    @Expose
    public String roleSessionName;
    @SerializedName("RegionId")
    @Expose
    public String regionId;
    @SerializedName("Duration")
    @Expose
    public Integer duration;

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleArn() {
        return roleArn;
    }
    public void setRoleArn(String roleArn) {
        this.roleArn = roleArn;
    }

    public String getRoleSessionName() {
        return roleSessionName;
    }
    public void setRoleSessionName(String roleSessionName) {
        this.roleSessionName = roleSessionName;
    }

    public String getRegionId() {
        return regionId;
    }
    public void setRegionId(String regionId) {
        this.customerId = regionId;
    }

    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("TargetCustomerId", key -> new Gson().toJson(this.customerId));
        map.computeIfAbsent("RoleName", key -> new Gson().toJson(this.roleName));
        map.computeIfAbsent("RoleArn", key -> new Gson().toJson(this.roleArn));
        map.computeIfAbsent("RoleSessionName", key -> new Gson().toJson(this.roleSessionName));
        map.computeIfAbsent("RegionId", key -> new Gson().toJson(this.regionId));
        map.computeIfAbsent("Duration", key -> new Gson().toJson(this.duration));

        return map;
    }
}
