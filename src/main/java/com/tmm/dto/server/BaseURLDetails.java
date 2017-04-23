package com.tmm.dto.server;

import com.tmm.domain.Interface;

import java.util.Date;
import java.util.List;

/**
 * Created by Captain Wang on 17/4/23.
 */
public class BaseURLDetails {

    private Long id;


    private String comment;


    private String baseurl;

    private Long projectId;

    private Long groupId;


    private Date createDate;


    private Date lastUpdateDate;


    private Date createTime;


    private Date lastUpdateTime;

    private List<Interface> interfaces;

    public BaseURLDetails() {
    }

    public BaseURLDetails(Long id, String comment, String baseurl, Long projectId, Long groupId, Date createDate, Date lastUpdateDate, Date createTime, Date lastUpdateTime, List<Interface> interfaces) {
        this.id = id;
        this.comment = comment;
        this.baseurl = baseurl;
        this.projectId = projectId;
        this.groupId = groupId;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.interfaces = interfaces;
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public List<Interface> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<Interface> interfaces) {
        this.interfaces = interfaces;
    }
}
