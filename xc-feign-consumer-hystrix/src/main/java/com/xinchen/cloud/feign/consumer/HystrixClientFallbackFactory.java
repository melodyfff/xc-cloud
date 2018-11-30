package com.xinchen.cloud.feign.consumer;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 错误回滚类
 * @author xinchen
 * @version 1.0
 * @date 30/11/2018 16:29
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory {
    @Override
    public HomeClient create(Throwable throwable) {
        return ()->"feign + hystrix ,提供者服务挂了";
    }
}
