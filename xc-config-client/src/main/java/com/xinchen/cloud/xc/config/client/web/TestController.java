package com.xinchen.cloud.xc.config.client.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/9/17 23:43
 */
@RestController
public class TestController {
    @Value("${content}")
    String content;

    @RequestMapping("/")
    public String home(){
        return "content:" + content;
    }
}
