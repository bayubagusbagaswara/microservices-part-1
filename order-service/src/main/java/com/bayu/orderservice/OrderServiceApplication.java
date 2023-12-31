package com.bayu.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApplication {

	private static final Logger log = Logger.getLogger(OrderServiceApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		log.info("Order Service is Running...");
	}

}
