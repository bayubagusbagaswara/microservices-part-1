package com.bayu;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ApiGatewayApplication {

    private static final Logger log = Logger.getLogger(ApiGatewayApplication.class.getName());

    public static void main(String[] args) {
        log.info("API Gateway is running...");
    }

}