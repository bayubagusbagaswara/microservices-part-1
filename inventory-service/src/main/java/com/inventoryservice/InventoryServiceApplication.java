package com.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    private static final Logger log = Logger.getLogger(InventoryServiceApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
        log.info("Inventory Service is Running...");
    }

//    @Bean
//    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
//        return args -> {
//            Inventory inventory = Inventory.builder()
//                    .skuCode("iphone_13")
//                    .quantity(100)
//                    .build();
//
//            Inventory inventory1 = Inventory.builder()
//                    .skuCode("iphone_13_red")
//                    .quantity(0)
//                    .build();
//
//            inventoryRepository.saveAll(List.of(inventory, inventory1));
//        };
//    }

}