package com.tmm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Captain Wang on 17/4/23.
 */

@Entity
public class TestProject {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 1000)

    private String title;
    @Column(length = 2000)
    private String comment;

    @Temporal(TemporalType.DATE)
    private Date createDate;


    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;

    @Temporal(TemporalType.TIME)
    private Date createTime;

    @Temporal(TemporalType.TIME)
    private Date lastUpdateTime;

    public TestProject() {
    }

    public TestProject(Long id, String title, String comment, Date createDate, Date lastUpdateDate, Date createTime, Date lastUpdateTime) {
        this.id = id;
        this.title = title;
        this.comment = comment;
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