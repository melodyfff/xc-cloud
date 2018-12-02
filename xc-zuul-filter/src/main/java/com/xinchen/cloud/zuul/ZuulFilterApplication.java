package com.xinchen.cloud.zuul;

import com.xinchen.cloud.zuul.filter.PasswordFilter;
import com.xinchen.cloud.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * zuul 网关过滤器
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/12/2 19:45
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulFilterApplication {

    /**
     * 加入过滤器
     * 访问带参 http://localhost:9000/?token=ok&password=xinchen
     *
     */
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    @Bean
    public PasswordFilter passwordFilter(){
        return new PasswordFilter();
    }


    public static void main(String[] args) {
        SpringApplication.run(ZuulFilterApplication.class, args);
    }

}
