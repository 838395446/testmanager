package com.tmm.service;

import com.tmm.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Captain Wang on 17/4/17.
 */
public interface BillRepository extends JpaRepository<Bill,Long> {
}
