package com.xinchen.cloud.feign.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xinchen
 * @version 1.0
 * @date 29/11/2018 19:55
 */
@RestController
public class ConsumerController {

    @Resource
    private HomeClient homeClient;

    @GetMapping("/hello")
    public String hello(){
        return homeClient.consumer();
    }
}
