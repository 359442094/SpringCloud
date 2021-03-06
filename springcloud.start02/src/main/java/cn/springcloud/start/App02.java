package cn.springcloud.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {
        "cn.springcloud.model",
        "cn.springcloud.service",
        "cn.springcloud.start",
        "cn.springcloud.controller"
})
@MapperScan(basePackages = {
        "cn.springcloud.model.mapper"
})
@EnableSwagger2         //开启Swagger2
@EnableEurekaClient     //自动注册至eureka注册中心
@EnableCircuitBreaker   //开启hystrix服务
public class App02 {
    public static void main(String[] args) {
        SpringApplication.run(App02.class,args);
    }
}
