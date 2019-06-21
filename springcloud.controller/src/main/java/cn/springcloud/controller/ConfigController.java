package cn.springcloud.controller;

import cn.springcloud.model.anntation.ShowLogger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"配置信息中心"})
public class ConfigController {
    @Value("${spring.application.admin.name}")
    private String adminName;

    @Value("${spring.profiles.active}")
    private String active;

    @Value("${server.port}")
    private String port;

    @ShowLogger(info = "Start01配置信息")
    @ApiOperation(value = "Start01配置信息",notes = "Start01配置信息")
    @RequestMapping(path = "/config",method = RequestMethod.GET)
    public String showConfigInfo(){
        return "port:"+port+"\n"+"active:"+active+"\n"+"adminName:"+adminName;
    }

}
