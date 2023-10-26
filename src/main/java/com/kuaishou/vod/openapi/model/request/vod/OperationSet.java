package com.kuaishou.vod.openapi.model.request.vod;

import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author code generator
 */
public class OperationSet {
    /**
     * 媒体处理的模板
     */
    @SerializedName("TemplateId")
    @Expose
    private String templateId;
    /**
     * 媒体处理作业类型
     */
    @SerializedName("ProcessType")
    @Expose
    private String processType;
    @SerializedName("InputFileSet")
    @Expose
    private InputFileSet inputFileSet;
    @SerializedName("OutputFileSet")
    @Expose
    private OutputFileSet outputFileSet;
    /**
     * 覆盖的参数,map结构,key和value都是String
     */
    @SerializedName("ExtraParams")
    @Expose
    private Map<String, String> extraParams;

    /**
     * 媒体处理的模板
     */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
     * 媒体处理的模板
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public InputFileSet getInputFileSet() {
        return inputFileSet;
    }

    public void setInputFileSet(InputFileSet inputFileSet) {
        this.inputFileSet = inputFileSet;
    }

    public OutputFileSet getOutputFileSet() {
        return outputFileSet;
    }

    public void setOutputFileSet(OutputFileSet outputFileSet) {
        this.outputFileSet = outputFileSet;
    }

    /**
     * 覆盖的参数,map结构,key和value都是String
     */
    public Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    /**
     * 覆盖的参数,map结构,key和value都是String
     */
    public void setExtraParams(Map<String, String> extraParams) {
        this.extraParams = extraParams;
    }

}
