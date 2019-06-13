package cn.springcloud.controller;

import cn.springcloud.model.anntation.ShowLogger;
import cn.springcloud.model.entity.User;
import cn.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"用户信息中心"})
public class UserController {

    @Autowired
    private UserService userService;

    @ShowLogger(info = "查询全部用户信息")
    @ApiOperation(value = "查询全部用户信息",notes = "查询全部用户信息")
    @RequestMapping(path = "/user/all",method = RequestMethod.GET)
    public List<User> userAll(){
        return userService.getUsers();
    }

    @ShowLogger(info = "查询单个用户信息")
    @ApiOperation(value = "查询单个用户信息",notes = "查询单个用户信息")
    @RequestMapping(path = "/user/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hystrixCommandMethod")    //服务熔断
    public User userById(@PathVariable(value = "id") int id){
        User user = userService.getUserById(id);
        if(StringUtils.isEmpty(user)){
            throw new RuntimeException("该用户不存在！");
        }else {
            return user;
        }
    }

    public User hystrixCommandMethod(@PathVariable(value = "id") int id){
        return new User(id,"this data not found");
    }

}
