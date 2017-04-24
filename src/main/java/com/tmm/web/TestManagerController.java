package com.tmm.web;

import com.google.gson.Gson;
import com.tmm.service.BillRepository;
import com.tmm.service.ProductDetailsRepository;
import com.tmm.service.ProductRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Captain Wang on 17/4/18.
 */

@Controller
public class TestManagerController {

    private Gson gson = new Gson();
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

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

}
