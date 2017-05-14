package com.tmm.service;

import com.tmm.domain.Interface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Captain Wang on 17/4/25.
 */
public interface InterfaceRepository extends JpaRepository<Interface,Long> {

    public List<Interface> findInterfacesByProjectId(Long projectId);


}
