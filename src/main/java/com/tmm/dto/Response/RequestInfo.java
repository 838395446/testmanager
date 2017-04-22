package com.tmm.dto.Response;

/**
 * Created by Captain Wang on 17/4/22.
 */
public class RequestInfo {


    private String method;
    private String url;
    private String headers;
    private String body;

    public RequestInfo() {

    }

    public RequestInfo(String method, String url, String headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
