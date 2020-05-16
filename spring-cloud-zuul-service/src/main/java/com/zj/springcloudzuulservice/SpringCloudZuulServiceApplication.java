package com.zj.springcloudzuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启 Zuul 服务网关
@EnableEurekaClient
public class SpringCloudZuulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulServiceApplication.class, args);
    }

}
