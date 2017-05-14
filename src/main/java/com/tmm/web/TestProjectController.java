package com.tmm.web;

import com.tmm.domain.TestProject;
import com.tmm.dto.server.InputTestProject;
import com.tmm.service.InputProjectRepository;
import com.tmm.service.TestGroupRespository;
import com.tmm.service.TestProjectRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Captain Wang on 17/4/25.
 */

@RestController
public class TestProjectController {

    @Autowired
    private TestProjectRepository testProjectRepository;
    @Autowired
    private TestGroupRespository testGroupRespository;

    /**
     *
     *
     * @return


    @GetMapping("/projectdetails")
    @ResponseBody
    @ApiOperation(value = "获取项目列表", httpMethod = "GET", notes = "暂无")
    public List<TestProjectDetails> getProjectDetails() {
        List<TestProjectDetails> testProjectDetails = new ArrayList<TestProjectDetails>();

        for(TestProject t:testProjectRepository.findAll()){
            ProjectDetailsRepository projectDetailsRepository = new ProjectDetailsRepository();
            testProjectDetails.add(projectDetailsRepository.ProjectToProjectDetails(t,testGroupRespository.findTestGroupsByProjectId(t.getId()).size()));
        }

        return  testProjectDetails;
    }
     */
    /**
     *
     * @return
     */
    @GetMapping(value = "/project")
    @ResponseBody
    @ApiOperation(value = "获取项目列表", httpMethod = "GET", notes = "暂无")
    public List<TestProject> getProjectList() {


        return testProjectRepository.findAll();
    }

    @PostMapping(value = "/project")
    @ResponseBody
    @ApiOperation(value = "添加项目", httpMethod = "POST", notes = "暂无")
    public TestProject addProject(InputTestProject inputTestProject) {
        InputProjectRepository inputProjectRepository = new InputProjectRepository();

        return testProjectRepository.save(inputProjectRepository.addProject(inputTestProject));
    }

    @PutMapping(value = "/project/{projectId}")
    @ResponseBody
    @ApiOperation(value = "修改项目", httpMethod = "PUT", notes = "暂无")
    public TestProject UpdateProject(@PathVariable("projectId") Long projectId, InputTestProject inputTestProject) {
        InputProjectRepository inputProjectRepository = new InputProjectRepository();
        TestProject testProject = inputProjectRepository.updateProject(testProjectRepository.findOne(projectId),inputTestProject);
        testProject.setId(projectId);

        return testProjectRepository.save(testProject);
    }

    @GetMapping(value = "/project/{projectId}")
    @ResponseBody
    @ApiOperation(value = "通过ID获取项目", httpMethod = "GET", notes = "暂无")
    public TestProject getProjectById(@PathVariable("projectId")Long projectId) {




        return testProjectRepository.findOne(projectId);
    }

    @ApiOperation(value = "通过ID删除项目", httpMethod= "DELETE", notes = "暂无")
    @DeleteMapping(value = "/project/{projectId}")
    @ResponseBody
    @Transactional
    public void deleteBaseURLById(@PathVariable("projectId") Long projectId) {

        testProjectRepository.delete(projectId);
    }

}
