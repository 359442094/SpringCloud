package cn.springcloud.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@EnableSwagger2
@EnableEurekaClient
public class App01 {
    public static void main(String[] args) {
        SpringApplication.run(App01.class,args);
    }
}
