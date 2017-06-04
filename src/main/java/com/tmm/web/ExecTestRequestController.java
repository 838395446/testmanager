package com.tmm.web;

/**
 * Created by Captain Wang on 17/4/22.


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
 */