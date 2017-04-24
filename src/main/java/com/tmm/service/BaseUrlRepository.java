package com.tmm.service;

import com.tmm.domain.BaseUrl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Captain Wang on 17/4/23.
 */
public interface BaseUrlRepository extends JpaRepository<BaseUrl,Long> {
    public BaseUrl findBaseUrlByProjectId(Long projectId);
}
