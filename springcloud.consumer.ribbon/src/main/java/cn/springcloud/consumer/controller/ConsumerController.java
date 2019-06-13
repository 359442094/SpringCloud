package cn.springcloud.consumer.controller;

import cn.springcloud.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    private final String prefix="http://springcloud.start";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/consumer/ribbon/user/all",method = RequestMethod.GET)
    public List<User> getAll(){
        return restTemplate.getForObject(prefix+"/user/all", List.class);
    }

    @RequestMapping(path = "/consumer/ribbon/user/get/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id")int id){
        return restTemplate.getForObject(prefix+"/user/get/"+id, User.class);
    }

}
