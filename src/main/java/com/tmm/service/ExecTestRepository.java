package com.tmm.service;


import com.tmm.dto.Request.RequestDTO;
import com.tmm.dto.Response.ResponseResult;
import com.tmm.retrofit.RetrofitTools;

import java.io.IOException;

/**
 * Created by Captain Wang on 17/4/22.
 */
public class ExecTestRepository {

    private RequestDTO requestDTO;

    private ResponseResult resultDTO;

    public RequestDTO getRequestDTO() {
        return requestDTO;
    }

    public void setRequestDTO(RequestDTO requestDTO) {
        this.requestDTO = requestDTO;
    }

    public ResponseResult getResultDTO() {
        return resultDTO;
    }

    public void setResultDTO(ResponseResult resultDTO) {
        this.resultDTO = resultDTO;
    }

    public ExecTestRepository(RequestDTO requestDTO){
        this.requestDTO = requestDTO;

    }

    public ResponseResult runTestCase() throws IOException {

        RetrofitTools retrofitTools = new RetrofitTools(this.requestDTO);
        return  retrofitTools.exceRequest();

    }

}
