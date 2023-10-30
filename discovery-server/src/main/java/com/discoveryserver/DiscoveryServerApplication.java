package com.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

    private static final Logger log = Logger.getLogger(DiscoveryServerApplication.class.getName());

    public static void main(String[] args) {
        log.info("Discovery Server is Running...");
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }

}