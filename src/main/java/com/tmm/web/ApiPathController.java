package com.tmm.web;

import com.tmm.domain.Interface;
import com.tmm.dto.server.InputApi;
import com.tmm.service.ApiPathRepository;
import com.tmm.service.InterfaceRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Captain Wang on 17/4/25.
 */

@RestController
public class ApiPathController {

    @Autowired
    private InterfaceRepository interfaceRepository;


    /**
     *
     * api 的 新增， 修改， 删除，查
     *
     *
     * @param inputApi
     * @return
     */

    @PostMapping("/apipath")
    @ResponseBody
    @ApiOperation(value = "添加接口地址", httpMethod = "POST", notes = "暂无")
    public Interface addApiPath(@RequestBody InputApi inputApi) {
        ApiPathRepository apiPathRepository = new ApiPathRepository();

        return interfaceRepository.save(apiPathRepository.changeToInterface(inputApi));

    }

    /**
     *
     * @param id
     * @param inputApi
     * @return
     */
    @PutMapping(value = "/apipath/{apipathId}")
    @ResponseBody
    @ApiOperation(value = "修改Apipath ", httpMethod = "PUT", notes = "暂无")
    public Interface updateApipathById(@PathVariable("apipathId") Long id, @RequestBody InputApi inputApi) {
        ApiPathRepository apiPathRepository = new ApiPathRepository();

        Interface apiPath=interfaceRepository.save(apiPathRepository.updateInterface(inputApi,interfaceRepository.findOne(id)));
        return apiPath;

    }


    /**
     *  获取 Api 列表
     * @return
     */

    @GetMapping(value = "/apipath")
    @ResponseBody
    @ApiOperation(value = "获取 Api 列表 ", httpMethod = "GET", notes = "暂无")
    public List<Interface> getApipaths() {

        return  interfaceRepository.findAll();

    }

    /**
     *
     * @param projectId
     * @return
     */
    @GetMapping(value = "/apipathbyproject/{projectId}")
    @ResponseBody
    @ApiOperation(value = "用 projectId apipath", httpMethod = "GET", notes = "暂无")
    public List<Interface> getApipathByProjectId(@PathVariable("projectId") Long projectId) {


        return  interfaceRepository.findInterfacesByProjectId(projectId);

    }


    /**
     *
     * @param apiId
     * @return
     */

    @GetMapping(value = "/apipath/{apiId}")
    @ResponseBody
    @ApiOperation(value = "用 Id 搜索 apipaths", httpMethod = "GET", notes = "暂无")
    public Interface getApipathById(@PathVariable("apiId") Long apiId) {

        return  interfaceRepository.findOne(apiId);

    }

    /**
     *   用id 删除
     * @param apiId
     */


    @ApiOperation(value = "删除apipath", httpMethod= "DELETE", notes = "暂无")
    @DeleteMapping(value = "/apipath/{apiId}")
    @ResponseBody
    @Transactional
    public void deleteApiPathById(@PathVariable("apiId") Long apiId) {

        interfaceRepository.delete(apiId);
    }
}
