package cn.springcloud.consumer.service;

import cn.springcloud.model.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(value = "SPRINGCLOUD.START",fallbackFactory = FeignFallBackFactory.class)
public interface FeignService {

    @RequestMapping(path = "/user/all",method = RequestMethod.GET)
    List<User> userAll();

    @RequestMapping(path = "/user/get/{id}",method = RequestMethod.GET)
    User userById(@PathVariable(value = "id") int id);

}
