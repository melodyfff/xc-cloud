package com.xinchen.cloud.ribbon.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xinchen
 * @version 1.0
 * @date 29/11/2018 17:10
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("hello")
    public String hello(){
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }

}
