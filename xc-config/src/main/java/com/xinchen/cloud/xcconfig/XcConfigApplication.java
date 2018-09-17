package com.xinchen.cloud.xcconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class XcConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(XcConfigApplication.class, args);
    }
}
