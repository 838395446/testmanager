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
public class Bill {
    @Id
    @GeneratedValue
    private Long id;

    private  Long customerId;

    private BigDecimal totalPrices;
    @Column(length = 255)
    private String details;

    public Bill() {
    }

    public Bill(Long customerId, BigDecimal totalPrices, String details) {
        this.customerId = customerId;

        this.totalPrices = totalPrices;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
        return "Bill{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", totalPrices=" + totalPrices +
                ", details='" + details + '\'' +
                '}';
    }
}
