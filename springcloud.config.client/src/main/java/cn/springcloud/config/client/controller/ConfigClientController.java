package cn.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${spring.application.admin.name}")
    private String adminName;

    @Value("${spring.profiles.active}")
    private String active;

    @Value("${server.port}")
    private String port;

    @RequestMapping(path = "/config",method = RequestMethod.GET)
    public String showConfigInfo(){
        return "port:"+port+"\n"+"active:"+active+"\n"+"adminName:"+adminName;
    }

}
