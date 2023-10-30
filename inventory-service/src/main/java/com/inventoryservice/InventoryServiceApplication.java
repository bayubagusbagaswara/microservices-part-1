package com.inventoryservice;

import com.inventoryservice.entity.Inventory;
import com.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
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