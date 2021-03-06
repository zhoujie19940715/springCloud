package com.zj.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix //开启断路器监控
public class ConsumerApplication {

    @Bean
    @LoadBalanced //注解表明这个restRemplate开启负载均衡的功能。
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}


}
