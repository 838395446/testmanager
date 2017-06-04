package com.tmm.dto.Request;

/**
 * Created by Captain Wang on 17/6/4.
 */
public class CaseStepByRequest {

    private String title;

    private String baseUrl;

    private String api;

    private String request_method;

    private String re_parameters;

    private Boolean debugger;

    public CaseStepByRequest() {
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

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getRequest_method() {
        return request_method;
    }

    public void setRequest_method(String request_method) {
        this.request_method = request_method;
    }

    public String getRe_parameters() {
        return re_parameters;
    }

    public void setRe_parameters(String re_parameters) {
        this.re_parameters = re_parameters;
    }

    public Boolean isDebugger() {
        return debugger;
    }

    public void setDebugger(Boolean debugger) {
        this.debugger = debugger;
    }

    @Override
    public String toString() {
        return "CaseStepByRequest{" +
                "title='" + title + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", api='" + api + '\'' +
                ", request_method='" + request_method + '\'' +
                ", re_parameters='" + re_parameters + '\'' +
                ", debugger=" + debugger +
                '}';
    }
}
