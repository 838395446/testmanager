package com.tmm.web;

import com.google.gson.Gson;
import com.tmm.service.BillRepository;
import com.tmm.service.ProductDetailsRepository;
import com.tmm.service.ProductRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Captain Wang on 17/4/18.
 */

@RestController
public class TestManagerController {

    private Gson gson = new Gson();
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    //
    @PostMapping("/123")
    @ResponseBody
    @ApiOperation(value = "添加商品", httpMethod = "POST", notes = "暂无")
    public void addProduct(@RequestBody String body) {}

}
