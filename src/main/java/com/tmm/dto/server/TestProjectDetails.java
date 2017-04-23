package com.tmm.dto.server;

import java.util.Date;

/**
 * Created by Captain Wang on 17/4/23.
 */
public class TestProjectDetails {

    private Integer caseTotal;

    private Integer groupTotal;


    private Long id;


    private String title;

    private String comment;


    private Date createDate;



    private Date lastUpdateDate;


    private Date createTime;


    private Date lastUpdateTime;

    public TestProjectDetails() {
    }

    public TestProjectDetails(Integer caseTotal, Integer groupTotal, Long id, String title, String comment, Date createDate, Date lastUpdateDate, Date createTime, Date lastUpdateTime) {
        this.caseTotal = caseTotal;
        this.groupTotal = groupTotal;
        this.id = id;
        this.title = title;
        this.comment = comment;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getCaseTotal() {
        return caseTotal;
    }

    public void setCaseTotal(Integer caseTotal) {
        this.caseTotal = caseTotal;
    }

    public Integer getGroupTotal() {
        return groupTotal;
    }

    public void setGroupTotal(Integer groupTotal) {
        this.groupTotal = groupTotal;
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
}
