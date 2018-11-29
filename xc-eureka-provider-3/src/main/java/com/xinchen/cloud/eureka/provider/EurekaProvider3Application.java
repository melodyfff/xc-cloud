package com.xinchen.cloud.eureka.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Eureka Provider 服务提供者实例
 * @author xinchen
 * @version 1.0
 * @date 29/11/2018 10:57
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaProvider3Application {

    @Value("${server.port}")
    String port;

    @GetMapping("/")
    public String home(){
        return "Hello World! port:"+port;
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider3Application.class, args);
    }

}
