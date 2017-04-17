package com.tmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Captain Wang on 17/4/17.
 */

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 255)
    private String name;

    private BigDecimal price;
    @Column(length = 255)
    private String comment;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, String comment) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.comment = comment;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                '}';
    }
}
