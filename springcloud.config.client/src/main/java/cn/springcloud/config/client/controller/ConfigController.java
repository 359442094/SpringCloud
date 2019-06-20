package cn.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${server.port}")
    private String port;
    @Value("${spring.cloud.config.profile}")
    private String profile;

    @RequestMapping(path = "/config",method = RequestMethod.GET)
    public String configInfo(){
        return new String("port:"+port+"\n"+"profile:"+profile+"\n");
    }

}
