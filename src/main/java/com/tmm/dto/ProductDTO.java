package com.tmm.dto;

import java.math.BigDecimal;

/**
 * Created by Captain Wang on 17/4/17.
 */
public class ProductDTO {

    /**
     * Copyright 2017 bejson.com
     */


    private String details;
    //private Long id;
    private BigDecimal price;

    private Long productId;
    private BigDecimal quantity;

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    //public void setId(Long id) {
    //    this.id = id;
    //}

    //public Long getId() {
     //   return id;
    //}

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "details='" + details + '\'' +
                //", id=" + id +
                ", price=" + price +
                ", productid=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}

