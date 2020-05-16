package com.zj.consumer.controller;

import com.zj.consumer.service.HelloService;
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

    @GetMapping(value = "/hello")
    public String hello(String name) {
        return restTemplate.getForObject("http://eureka-provider/hi?name=" + name, String.class);
    }

}
