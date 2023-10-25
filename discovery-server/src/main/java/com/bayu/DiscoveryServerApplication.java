package com.bayu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

    private static final Logger log = Logger.getLogger(DiscoveryServerApplication.class.getName());

    public static void main(String[] args) {
        log.info("Discovery Server is running...");
    }

}