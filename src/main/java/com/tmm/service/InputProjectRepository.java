package com.tmm.service;

import com.tmm.domain.TestProject;
import com.tmm.dto.server.InputTestProject;

import java.util.Date;

/**
 * Created by Captain Wang on 17/4/23.
 */
public class InputProjectRepository {

    public TestProject addProject(InputTestProject inputTestProject) {


        TestProject testProject = new TestProject();
        testProject.setComment(inputTestProject.getComment());
        testProject.setTitle(inputTestProject.getTitle());
        testProject.setCreateTime(new Date());


        testProject.setUpdateTime(new Date());
        return testProject;
    }
    public TestProject updateProject(TestProject testProject,InputTestProject inputTestProject) {



        testProject.setComment(inputTestProject.getComment());
        testProject.setTitle(inputTestProject.getTitle());
        testProject.setUpdateTime(new Date());
        return testProject;
    }




}
