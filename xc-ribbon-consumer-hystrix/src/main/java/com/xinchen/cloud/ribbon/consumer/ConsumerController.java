package com.xinchen.cloud.ribbon.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    /**
     * @HystrixCommand  表明该方法为hystrix包裹，可以对依赖服务进行隔离、降级、快速失败、快速重试等
     * fallbackMethod = "defaultStores" 熔断方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultStores")
    @GetMapping("hello")
    public String hello(){
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }


    public String defaultStores() {
        return "Ribbon + hystrix ,提供者服务挂了";
    }


}
