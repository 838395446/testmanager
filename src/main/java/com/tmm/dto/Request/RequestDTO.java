package com.tmm.dto.Request;

/**
 * Created by Captain Wang on 17/4/22.
 */
public class RequestDTO {


    private String title;
    private String baseUrl;
    private Integer inputType;

    private String path;
    private String comment;

    private int requestMethod;

    private String parameters;

    private boolean verify;

    public RequestDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(Integer requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    @Override
    public String toString() {
        return "ExecTestRequest{" +
                "title='" + title + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", inputType=" + inputType +
                ", path='" + path + '\'' +
                ", comment='" + comment + '\'' +
                ", requestMethod=" + requestMethod +
                ", parameters='" + parameters + '\'' +
                ", verify=" + verify +
                '}';
    }
}
