package com.tmm.web;

import com.tmm.dto.Request.CaseStepByRequest;
import com.tmm.dto.Request.CaseStepDTO;
import com.tmm.dto.Response.ResponseResult;
import com.tmm.retrofit.RetrofitToolsByRequest;
import com.tmm.service.BaseUrlRepository;
import com.tmm.service.CaseStepRepository;
import com.tmm.service.InterfaceRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Captain Wang on 17/6/3.
 */

@RestController
public class TestStepController {

    @Autowired
    private CaseStepRepository caseStepRepository;

    @Autowired
    private BaseUrlRepository baseUrlRepository;

    @Autowired
    private InterfaceRepository interfaceRepository;

    @PostMapping("/teststep")
    @ResponseBody
    @ApiOperation(value = "添加测试步骤", httpMethod = "POST", notes = "暂无")
    public ResponseResult addTestStep(@RequestBody CaseStepDTO caseStepDTO) {
        CaseStepByRequest caseStepByRequest = new CaseStepByRequest();


        if(caseStepDTO.isDebugger()){
            System.out.println("Step is debug ...");
            caseStepByRequest.setTitle(caseStepDTO.getTitle());
            caseStepByRequest.setBaseUrl(baseUrlRepository.findOne(caseStepDTO.getBaseUrlId()).getBaseurl());
            caseStepByRequest.setApi(interfaceRepository.findOne(caseStepDTO.getApiId()).getApiPath());
            caseStepByRequest.setRequest_method(caseStepDTO.getRequest_method());
            caseStepByRequest.setRe_parameters(caseStepDTO.getRe_parameters());
            RetrofitToolsByRequest retrofitToolsByRequest = new RetrofitToolsByRequest(caseStepByRequest);
            return retrofitToolsByRequest.exceRequest();

        }else{
            return null;
        }

    }


}
