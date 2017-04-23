package com.tmm.service;

import com.tmm.domain.TestProject;
import com.tmm.dto.server.TestProjectDetails;

/**
 * Created by Captain Wang on 17/4/23.
 */
public class ProjectDetailsRepository {

    public TestProjectDetails ProjectToProjectDetails(TestProject testProjects,Integer groupTotal) {


        TestProjectDetails testProjectDetails = new TestProjectDetails();
        testProjectDetails.setComment(testProjects.getComment());
        testProjectDetails.setId(testProjects.getId());
        testProjectDetails.setGroupTotal(groupTotal);
        testProjectDetails.setTitle(testProjects.getTitle());
        testProjectDetails.setCreateDate(testProjects.getCreateDate());
        testProjectDetails.setCreateTime(testProjects.getCreateTime());
        testProjectDetails.setLastUpdateDate(testProjects.getLastUpdateDate());
        testProjectDetails.setLastUpdateTime(testProjects.getLastUpdateTime());
        return testProjectDetails;
    }
}
