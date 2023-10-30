package com.bayu.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {

	private static final Logger log = Logger.getLogger(ProductServiceApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		log.info("Product Service is Running...");
	}

}
