package com.tmm.service;

import com.tmm.domain.Interface;
import com.tmm.dto.server.InputApi;

import java.util.Date;

/**
 * Created by Captain Wang on 17/4/25.
 */
public class ApiPathRepository {


    public Interface changeToInterface(InputApi inputApi) {
        Interface interfacePath = new Interface();

        interfacePath.setApiPath(inputApi.getApiPath());
        interfacePath.setComment(inputApi.getComment());
        interfacePath.setProjectId(inputApi.getProjectId());
        interfacePath.setBaseUrlId(inputApi.getBaseUrlId());
        interfacePath.setCreateDate(new Date());
        interfacePath.setLastUpdateDate(new Date());
        interfacePath.setCreateTime(new Date());
        interfacePath.setLastUpdateTime(new Date());

        return interfacePath;
    }

    public Interface updateInterface(InputApi inputApi,Interface apiPath){


        apiPath.setApiPath(inputApi.getApiPath());
        apiPath.setComment(inputApi.getComment());
        apiPath.setProjectId(inputApi.getProjectId());
        apiPath.setBaseUrlId(inputApi.getBaseUrlId());
        apiPath.setLastUpdateDate(new Date());
        apiPath.setLastUpdateTime(new Date());
        return apiPath;
    }
}
