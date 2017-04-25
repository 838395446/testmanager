package com.tmm.dto.server;

/**
 * Created by Captain Wang on 17/4/25.
 */
public class InputApi {

    private String comment;


    private String apiPath;

    private Long projectId;

    private Long baseUrlId;

    public InputApi() {
        this.comment = "";
        this.apiPath = "";
        this.projectId = 0L;
        this.baseUrlId = 0L;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getBaseUrlId() {
        return baseUrlId;
    }

    public void setBaseUrlId(Long baseUrlId) {
        this.baseUrlId = baseUrlId;
    }
}
