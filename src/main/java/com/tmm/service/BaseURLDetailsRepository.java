package com.tmm.service;

import com.tmm.domain.BaseUrl;
import com.tmm.dto.server.InputBaseURL;

import java.util.Date;

/**
 * Created by Captain Wang on 17/4/24.
 */
public class BaseURLDetailsRepository {
    public BaseUrl addBaseURL(InputBaseURL inputBaseURL) {
        BaseUrl baseUrl = new BaseUrl();
        baseUrl.setProjectId(inputBaseURL.getProjectId());


        baseUrl.setComment(inputBaseURL.getComment());
        baseUrl.setBaseurl(inputBaseURL.getBaseurl());
        baseUrl.setLastUpdateTime(new Date());
        baseUrl.setLastUpdateDate(new Date());


        baseUrl.setCreateTime(new Date());
        baseUrl.setCreateDate(new Date());


        return baseUrl;
    }

    public BaseUrl updateBaseURL(BaseUrl baseUrl, InputBaseURL inputBaseURL) {

        try {

            if (inputBaseURL.getProjectId() != null && inputBaseURL.getProjectId() != 0) {

                baseUrl.setProjectId(inputBaseURL.getProjectId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        baseUrl.setComment(inputBaseURL.getComment());
        baseUrl.setBaseurl(inputBaseURL.getBaseurl());
        return baseUrl;
    }


}
