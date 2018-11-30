package com.xinchen.cloud.feign;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 消费者 Feign
 * @author xinchen
 * @version 1.0
 * @date 29/11/2018 19:50
 */
@EnableFeignClients
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerHystrixApplication {

    /**
     * 出现 Unable to connect to Command Metric Stream. 时参考以下博客
     * https://www.cnblogs.com/mark7/p/8920288.html
     *
     * 访问 http://localhost:9000/hystrix/ 查看详情
     *  http://127.0.0.1:9000/hystrix.stream
     *  2000   hello
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }


    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerHystrixApplication.class, args);
    }

}
