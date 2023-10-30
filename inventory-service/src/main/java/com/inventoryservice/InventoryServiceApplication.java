package com.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class InventoryServiceApplication {

    private static final Logger log = Logger.getLogger(InventoryServiceApplication.class.getName());

    public static void main(String[] args) {
        log.info("Inventory Service is Running...");
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

}