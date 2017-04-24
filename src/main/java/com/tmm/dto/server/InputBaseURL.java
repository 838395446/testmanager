package com.tmm.dto.server;

/**
 * Created by Captain Wang on 17/4/24.
 */
public class InputBaseURL {

    private String baseurl;
    private String comment;
    private Long projectId;

    public InputBaseURL() {
    }

    public InputBaseURL(String baseurl, String comment, Long projectId) {

        this.baseurl = baseurl;
        this.comment = comment;
        this.projectId = projectId;
    }



    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "InputBaseURL{" +
                " baseurl='" + baseurl + '\'' +
                ", comment='" + comment + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
