package com.tmm.dto.Request;

/**
 * Created by Captain Wang on 17/6/3.
 */


public class CaseStepDTO{

    private String title;

    private Long baseUrlId;

    private Long apiId;

    private String request_method;

    private String re_parameters;

    private boolean debugger;

    public CaseStepDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getBaseUrlId() {
        return baseUrlId;
    }

    public void setBaseUrlId(Long baseUrlId) {
        this.baseUrlId = baseUrlId;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
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

    public boolean isDebugger() {
        return debugger;
    }

    public void setDebugger(boolean debugger) {
        this.debugger = debugger;
    }
}
