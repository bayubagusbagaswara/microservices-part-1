package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ApiGatewayApplication {

    private static final Logger log = Logger.getLogger(ApiGatewayApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
        log.info("API Gateway is Running...");
    }

}