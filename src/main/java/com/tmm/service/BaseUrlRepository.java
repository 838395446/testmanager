package com.tmm.service;

import com.tmm.domain.BaseUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Captain Wang on 17/4/23.
 */
public interface BaseUrlRepository extends JpaRepository<BaseUrl,Long> {
    public List<BaseUrl> findBaseUrlByProjectId(Long projectId);
}
