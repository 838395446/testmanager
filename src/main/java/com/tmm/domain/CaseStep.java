package com.tmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Captain Wang on 17/6/3.
 */

@Entity
public class CaseStep {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 200)
    private String title;

    private Long baseUrlId;

    private Long apiId;
    @Column(length = 200)
    private String request_method;
    @Column(length = 2000)
    private String re_parameters;


    public CaseStep() {
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

    public Long getBaseUrlId() {
        return baseUrlId;
    }

    public void setBaseUrlId(Long baseUrlId) {
        this.baseUrlId = baseUrlId;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getRequest_method() {
        return request_method;
    }

    public void setRequest_method(String request_method) {
        this.request_method = request_method;
    }

    public String getRe_parameters() {
        return re_parameters;
    }

    public void setRe_parameters(String re_parameters) {
        this.re_parameters = re_parameters;
    }
}
