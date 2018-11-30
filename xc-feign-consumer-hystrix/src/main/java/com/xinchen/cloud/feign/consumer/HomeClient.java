package com.xinchen.cloud.feign.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 指定这个接口所要调用的 提供者服务名称 "eureka-provider"
 * @author xinchen
 * @version 1.0
 * @date 29/11/2018 19:53
 */
@FeignClient(value = "eureka-provider",fallbackFactory = HystrixClientFallbackFactory.class)
public interface HomeClient {

    /**
     * 调用eureka-provider服务的 / 接口
     * @return
     */
    @GetMapping("/")
    String consumer();
}
