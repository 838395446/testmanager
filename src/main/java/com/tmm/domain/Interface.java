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

    private Long baseUrlId;


    private Long projectId;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;


    @Temporal(TemporalType.TIME)
    private Date createTime;

    @Temporal(TemporalType.TIME)
    private Date lastUpdateTime;

    public Interface() {
    }

    public Interface(Long id, String comment, String apiPath, Long projectId, Date createDate, Date lastUpdateDate, Date createTime, Date lastUpdateTime) {
        this.id = id;
        this.comment = comment;
        this.apiPath = apiPath;
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

    public Long getBaseUrlId() {
        return baseUrlId;
    }

    public void setBaseUrlId(Long baseUrlId) {
        this.baseUrlId = baseUrlId;
    }

    @Override
    public String toString() {
        return "Interface{" +
                "id=" + id +
                ", apiPath='" + apiPath + '\'' +
                ", comment='" + comment + '\'' +
                ", baseUrlId=" + baseUrlId +
                ", projectId=" + projectId +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
/**
 * id	title	comment	baseurlId	projectId	createDate	lastUpdateDate	createTime	lastUpdateTime
 *
 * @Temporal(TemporalType.DATE)        @Temporal(TemporalType.TIME)
 */