package com.tmm.web;

import com.tmm.domain.BaseUrl;
import com.tmm.domain.TestProject;
import com.tmm.dto.server.InputBaseURL;
import com.tmm.dto.server.TestProjectDetails;
import com.tmm.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    @Autowired
    private BaseUrlRepository baseUrlRepository;


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

    @ApiOperation(value = "删除BaseURL", httpMethod= "DELETE", notes = "暂无")
    @DeleteMapping(value = "/baseurl/{baseurlId}")
    @ResponseBody
    @Transactional
    public void deleteBaseURLById(@PathVariable("baseurlId") Long baseurlId) {

        baseUrlRepository.delete(baseurlId);
    }


    @PostMapping("/baseurl")
    @ResponseBody
    @ApiOperation(value = "添加baseUrl", httpMethod = "POST", notes = "暂无")
    public BaseUrl addBaseURL(@RequestBody InputBaseURL inputBaseURL) {

        BaseURLDetailsRepository baseURLDetailsRepository = new BaseURLDetailsRepository();

        BaseUrl baseurl=baseUrlRepository.save(baseURLDetailsRepository.addBaseURL(inputBaseURL));
        return baseurl;

    }

    @GetMapping("/baseurl")
    @ResponseBody
    @ApiOperation(value = "获取baseUrl列表", httpMethod = "GET", notes = "暂无")
    public List<BaseUrl> getBaseURLList() {


        return baseUrlRepository.findAll();

    }

    @GetMapping(value = "/baseurl/{projectId}")
    @ResponseBody
    @ApiOperation(value = "用 projectId 获取baseUrl", httpMethod = "GET", notes = "暂无")
    public BaseUrl getBaseURLByProjectId(@PathVariable("projectId") Long projectId) {


        return baseUrlRepository.findBaseUrlByProjectId(projectId);

    }


    @PutMapping(value = "/baseurl/{baseurlId}")
    @ResponseBody
    @ApiOperation(value = "修改baseUrl", httpMethod = "PUT", notes = "暂无")
    public BaseUrl updateBaseURLById(@PathVariable("baseurlId") Long id,@RequestBody InputBaseURL inputBaseURL) {
        BaseURLDetailsRepository baseURLDetailsRepository = new BaseURLDetailsRepository();
        //baseURLDetailsRepository.updateBaseURL(baseUrlRepository.findOne(id),inputBaseURL);
        BaseUrl baseurl=baseUrlRepository.save(baseURLDetailsRepository.updateBaseURL(baseUrlRepository.findOne(id),inputBaseURL));
        return baseurl;

    }
}
