package com.kuaishou.vod.openapi.model.request.vod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WatermarkSet {
    @SerializedName("WatermarkTemplateId")
    @Expose
    public String watermarkTemplateId;
    @SerializedName("ResourceKey")
    @Expose
    public String resourceKey;
    @SerializedName("MarginX")
    @Expose
    public String marginX;
    @SerializedName("MarginY")
    @Expose
    public String marginY;
    @SerializedName("Width")
    @Expose
    public String width;
    @SerializedName("Height")
    @Expose
    public String height;
    @SerializedName("ReferPosition")
    @Expose
    public String referPosition;
    @SerializedName("WidthReferEdge")
    @Expose
    public String widthReferEdge;
    @SerializedName("HeightReferEdge")
    @Expose
    public String heightReferEdge;
    @SerializedName("MarginXReferEdge")
    @Expose
    public String marginXReferEdge;
    @SerializedName("MarginYReferEdge")
    @Expose
    public String marginYReferEdge;

    public String getWatermarkTemplateId() {
        return watermarkTemplateId;
    }

    public void setWatermarkTemplateId(String watermarkTemplateId) {
        this.watermarkTemplateId = watermarkTemplateId;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public String getMarginX() {
        return marginX;
    }

    public void setMarginX(String marginX) {
        this.marginX = marginX;
    }

    public String getMarginY() {
        return marginY;
    }

    public void setMarginY(String marginY) {
        this.marginY = marginY;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getReferPosition() {
        return referPosition;
    }

    public void setReferPosition(String referPosition) {
        this.referPosition = referPosition;
    }

    public String getWidthReferEdge() {
        return widthReferEdge;
    }

    public void setWidthReferEdge(String widthReferEdge) {
        this.widthReferEdge = widthReferEdge;
    }

    public String getHeightReferEdge() {
        return heightReferEdge;
    }

    public void setHeightReferEdge(String heightReferEdge) {
        this.heightReferEdge = heightReferEdge;
    }

    public String getMarginXReferEdge() {
        return marginXReferEdge;
    }

    public void setMarginXReferEdge(String marginXReferEdge) {
        this.marginXReferEdge = marginXReferEdge;
    }

    public String getMarginYReferEdge() {
        return marginYReferEdge;
    }

    public void setMarginYReferEdge(String marginYReferEdge) {
        this.marginYReferEdge = marginYReferEdge;
    }
}
