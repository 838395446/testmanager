package com.tmm.web;

import com.tmm.domain.BaseUrl;
import com.tmm.dto.server.InputBaseURL;
import com.tmm.service.BaseURLDetailsRepository;
import com.tmm.service.BaseUrlRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Captain Wang on 17/4/25.
 */
@RestController
public class BaseUrlController {

    @Autowired
    private BaseUrlRepository baseUrlRepository;


    /**
     *
     * @param baseurlId
     */
    @ApiOperation(value = "删除BaseURL", httpMethod= "DELETE", notes = "暂无")
    @DeleteMapping(value = "/baseurl/{baseurlId}")
    @ResponseBody
    @Transactional
    public void deleteBaseURLById(@PathVariable("baseurlId") Long baseurlId) {

        baseUrlRepository.delete(baseurlId);
    }

    /**
     *
     * @param inputBaseURL
     * @return
     */

    @PostMapping("/baseurl")
    @ResponseBody
    @ApiOperation(value = "添加baseUrl", httpMethod = "POST", notes = "暂无")
    public BaseUrl addBaseURL(@RequestBody InputBaseURL inputBaseURL) {

        BaseURLDetailsRepository baseURLDetailsRepository = new BaseURLDetailsRepository();

        BaseUrl baseurl=baseUrlRepository.save(baseURLDetailsRepository.addBaseURL(inputBaseURL));
        return baseurl;

    }

    /**
     *
     *
     * @return
     */
    @GetMapping("/baseurl")
    @ResponseBody
    @ApiOperation(value = "获取baseUrl列表", httpMethod = "GET", notes = "暂无")
    public List<BaseUrl> getBaseURLList() {


        return baseUrlRepository.findAll();

    }

    /**
     *
     * @param projectId
     * @return
     */
    @GetMapping(value = "/baseurl/{projectId}")
    @ResponseBody
    @ApiOperation(value = "用 projectId 获取baseUrl", httpMethod = "GET", notes = "暂无")
    public List<BaseUrl> getBaseURLByProjectId(@PathVariable("projectId") Long projectId) {


        return  baseUrlRepository.findBaseUrlByProjectId(projectId);

    }

    /**
     *
     * @param id
     * @param inputBaseURL
     * @return
     */

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
