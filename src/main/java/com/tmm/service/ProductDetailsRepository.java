package com.tmm.service;

import com.tmm.domain.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Captain Wang on 17/4/17.
 */
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

    public List<ProductDetails> findProductDetailsByBillId(Long billId);

    public void deleteByBillId(Long billId);
}
