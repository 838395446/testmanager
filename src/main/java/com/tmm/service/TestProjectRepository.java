package com.tmm.service;

import com.tmm.domain.TestProject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Captain Wang on 17/4/23.
 */
public interface TestProjectRepository extends JpaRepository<TestProject,Long> {
}
