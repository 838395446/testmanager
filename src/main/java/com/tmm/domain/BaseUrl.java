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

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;

    @Temporal(TemporalType.TIME)
    private Date createTime;

    @Temporal(TemporalType.TIME)
    private Date lastUpdateTime;

    public BaseUrl() {
    }

    public BaseUrl(String comment, String baseurl, Long projectId, Long groupId, Date createDate, Date lastUpdateDate, Date createTime, Date lastUpdateTime) {
        this.comment = comment;
        this.baseurl = baseurl;
        this.projectId = projectId;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "BaseUrl{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", baseurl='" + baseurl + '\'' +
                ", projectId=" + projectId +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
