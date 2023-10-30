package com.bayu.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class OrderServiceApplication {

	private static final Logger log = Logger.getLogger(OrderServiceApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		log.info("Order Service is Running...");
	}

}
