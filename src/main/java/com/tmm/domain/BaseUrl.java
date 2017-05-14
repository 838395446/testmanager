package com.tmm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Captain Wang on 17/4/23.
 */

@Entity
public class BaseUrl {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 2000)
    private String comment;

    @Column(length = 1000)
    private String baseurl;

    private Long projectId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public BaseUrl() {
    }

    public BaseUrl(String comment, String baseurl, Long projectId, Date createTime, Date updateTime) {
        this.comment = comment;
        this.baseurl = baseurl;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
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
        return "BaseUrl{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", baseurl='" + baseurl + '\'' +
                ", projectId=" + projectId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
