package com.tmm.dto.Response;

/**
 * Created by Captain Wang on 17/4/22.
 */
public class ResponseResult {

    private String msg;
    private RequestInfo requestInfo;
    private ResponseInfo responseInfo;



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseResult() {
    }

    public ResponseResult(ResponseInfo responseInfo, RequestInfo requestInfo) {
        this.responseInfo = responseInfo;
        this.requestInfo = requestInfo;
    }

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }
}
