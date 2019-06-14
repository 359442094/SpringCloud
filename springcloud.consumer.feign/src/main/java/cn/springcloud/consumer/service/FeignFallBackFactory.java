package cn.springcloud.consumer.service;

import cn.springcloud.model.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignFallBackFactory implements FallbackFactory<FeignService> {

    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService() {
            @Override
            public List<User> userAll() {
                return null;
            }

            @Override
            public User userById(int id) {
                return new User(id,"该服务不存在或已经关闭");
            }
        };
    }

}
