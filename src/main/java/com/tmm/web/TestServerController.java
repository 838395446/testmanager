package com.tmm.web;

import com.tmm.domain.TestProject;
import com.tmm.dto.server.TestProjectDetails;
import com.tmm.service.ProjectDetailsRepository;
import com.tmm.service.TestGroupRespository;
import com.tmm.service.TestProjectRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Captain Wang on 17/4/23.
 */
@RestController
public class TestServerController {
    @Autowired
    private TestProjectRepository testProjectRepository;
    @Autowired
    private TestGroupRespository testGroupRespository;



    @GetMapping("/project")
    @ResponseBody
    @ApiOperation(value = "获取项目列表", httpMethod = "GET", notes = "暂无")
    public List<TestProjectDetails> getProjects() {
        List<TestProjectDetails> testProjectDetails = new ArrayList<TestProjectDetails>();

        for(TestProject t:testProjectRepository.findAll()){
            ProjectDetailsRepository projectDetailsRepository = new ProjectDetailsRepository();
            testProjectDetails.add(projectDetailsRepository.ProjectToProjectDetails(t,testGroupRespository.findTestGroupsByProjectId(t.getId()).size()));
        }
        
        return  testProjectDetails;
    }

    @GetMapping("/projects")
    @ResponseBody
    @ApiOperation(value = "获取项目列表", httpMethod = "GET", notes = "暂无")
    public List<TestProject> getProjectList() {


        return testProjectRepository.findAll();
    }
}
