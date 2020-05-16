package com.zj.consumerhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zj.consumerhystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){

        return helloService.hiService(name);
    }
    /*
    @HystrixCommand(fallbackMethod = "defaultStores")
    该注解对该方法创建了熔断器的功能,并指定了defaultStores熔断方法
     */
    @HystrixCommand(fallbackMethod = "defaultStores")
    @GetMapping(value = "/hello")
    public String hello(String name) {
        return restTemplate.getForObject("http://eureka-provider/hi?name=" + name, String.class);
    }

    public String defaultStores() {
        return "Ribbon + hystrix ,提供者服务挂了";
    }
}
