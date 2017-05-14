package com.tmm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Captain Wang on 17/4/23.
 */

@Entity
public class TestGroup {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    @Column(length = 1000)
    private String comment;
    @Column(length = 2000)
    private String parameters;

    private Long projectId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public TestGroup() {
    }

    public TestGroup(String title, String comment, String parameters, Long projectId, Date createTime, Date updateTime) {
        this.title = title;
        this.comment = comment;
        this.parameters = parameters;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
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
        return "TestGroup{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", parameters='" + parameters + '\'' +
                ", projectId=" + projectId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}