package com.tmm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Captain Wang on 17/4/23.
 */

@Entity
public class Interface {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 1000)
    private String apiPath;


    @Column(length = 2000)

    private String comment;

    private Long projectId;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public Interface() {
    }

    public Interface(String apiPath, String comment, Long projectId, Date createTime, Date updateTime) {
        this.apiPath = apiPath;
        this.comment = comment;

        this.projectId = projectId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Interface{" +
                "id=" + id +
                ", apiPath='" + apiPath + '\'' +
                ", comment='" + comment + '\'' +
                ", projectId=" + projectId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
/**
 * id	title	comment	baseurlId	projectId	createDate	lastUpdateDate	createTime	lastUpdateTime
 *
 * @Temporal(TemporalType.DATE)        @Temporal(TemporalType.TIME)
 */