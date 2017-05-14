package com.tmm.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Captain Wang on 17/4/18.
 */

@Controller
public class TestManagerController {
    //
    @GetMapping(value = "/")
    @ApiOperation(value = "平台首页", httpMethod = "GET", notes = "暂无")
    public String returnIndex() {
        return "index.html";
    }

    @GetMapping(value = "/addproject")
    @ApiOperation(value = "添加项目", httpMethod = "GET", notes = "暂无")
    public String addProject() {
        return "project_add.html";
    }

    @GetMapping(value = "/projectlist")
    @ApiOperation(value = "获取项目列表页", httpMethod = "GET", notes = "暂无")
    public String getProjectList() {
        return "project_list.html";
    }


    @GetMapping(value = "/apilist")
    @ApiOperation(value = "获取api列表页", httpMethod = "GET", notes = "暂无")
    public String getApitList() {
        return "api_list.html";
    }

}
