package com.tmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Captain Wang on 17/4/17.
 */

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(length = 255)
    private String comment;
    @Column(length = 255)
    private String tel;

    public Customer() {
    }

    public Customer(Long id, String name, String comment, String tel) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
