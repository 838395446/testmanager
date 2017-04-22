package com.tmm.dto.Response;

import java.sql.Date;

/**
 * Created by Captain Wang on 17/4/22.
 */
public class ResponseInfo {


    private int code;
    private String msg;
    private String headers;

    private Date contentType;

    private String transferEncoding;

    private String date;

    private String errorbody;

    private boolean successful;

    private String message;

    private String body;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public Date getContentType() {
        return contentType;
    }

    public void setContentType(Date contentType) {
        this.contentType = contentType;
    }

    public String getTransferEncoding() {
        return transferEncoding;
    }

    public void setTransferEncoding(String transferEncoding) {
        this.transferEncoding = transferEncoding;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getErrorbody() {
        return errorbody;
    }

    public void setErrorbody(String errorbody) {
        this.errorbody = errorbody;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ResponseInfo() {
    }

    public ResponseInfo(int code, String msg, String headers, Date contentType, String transferEncoding, String date, String errorbody, boolean successful, String message, String body) {
        this.code = code;
        this.msg = msg;
        this.headers = headers;
        this.contentType = contentType;
        this.transferEncoding = transferEncoding;
        this.date = date;
        this.errorbody = errorbody;
        this.successful = successful;
        this.message = message;
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", headers='" + headers + '\'' +
                ", contentType=" + contentType +
                ", transferEncoding='" + transferEncoding + '\'' +
                ", date='" + date + '\'' +
                ", errorbody='" + errorbody + '\'' +
                ", successful=" + successful +
                ", message='" + message + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
