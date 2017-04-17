package com.tmm.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Captain Wang on 17/4/17.
 */

public class BillDto {
    private Long id;

    private Long customerId;

    private List<Products> products;

    private BigDecimal totalPrices;

    private String details;

    public BillDto() {
    }

    public BillDto(Long id, BigDecimal totalPrices, String details) {
        this.id = id;
        this.totalPrices = totalPrices;
        this.details = details;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Products> getProducts() {
        return this.products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(BigDecimal totalPrices) {
        this.totalPrices = totalPrices;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "BillDto{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", products=" + products +
                ", totalPrices=" + totalPrices +
                ", details='" + details + '\'' +
                '}';
    }
}
