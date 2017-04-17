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
public class ProductDetails {

    @Id
    @GeneratedValue
    private Long id;
    private Long billId;
    private Long productId;

    private BigDecimal price;

    private BigDecimal quantity;
    @Column(length = 255)
    private String details;

    public ProductDetails() {
    }

    public ProductDetails(Long id, Long productId, BigDecimal price, BigDecimal quantity, String details) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", productId=" + productId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", details='" + details + '\'' +
                '}';
    }
}
