package com.tmm.service;

import com.tmm.domain.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Captain Wang on 17/4/17.
 */
public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Long>{
}
