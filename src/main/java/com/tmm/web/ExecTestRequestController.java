package com.tmm.web;

import com.tmm.dto.Request.RequestDTO;
import com.tmm.dto.Response.ResponseResult;
import com.tmm.service.ExecTestRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Captain Wang on 17/4/22.
 */

@RestController
public class ExecTestRequestController {


    //
    @PostMapping("/exectest")
    @ResponseBody
    @ApiOperation(value = "执行测试接口", httpMethod = "POST", notes = "暂无")
    public ResponseResult execTest(@RequestBody RequestDTO body) throws Exception {


        return new ExecTestRepository(body).runTestCase();
    }
}
