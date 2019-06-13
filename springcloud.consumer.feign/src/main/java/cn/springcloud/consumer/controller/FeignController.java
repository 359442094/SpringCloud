package cn.springcloud.consumer.controller;

import cn.springcloud.consumer.service.FeignService;
import cn.springcloud.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(path = "/consumer/feign/user/all",method = RequestMethod.GET)
    public List<User> getAll(){
        return feignService.userAll();
    }

    @RequestMapping(path = "/consumer/feign/user/get/{id}",method = RequestMethod.GET)
    public User getAll(@PathVariable(value = "id")int id){
        return feignService.userById(id);
    }

}
