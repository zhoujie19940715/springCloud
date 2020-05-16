package com.zj.consumerhystricdashboard.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;


    public String hiError(String name){
        return "hey,"+name+",there is some problem with hiService";
    }

    //断路器配置，当无法调用如下方法时就会调用自定义的hiError方法
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name)
    {
        //ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://SERVICE-HI/hi?name=" + name, Object.class);
        return restTemplate.getForObject("http://eureka-provider/hi?name=" + name, String.class);
    }

}
