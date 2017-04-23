package com.tmm.service;

import com.tmm.domain.TestGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Captain Wang on 17/4/23.
 */
public interface TestGroupRespository extends JpaRepository<TestGroup,Long>{

    public List<TestGroup> findTestGroupsByProjectId (Long projectId);
}
