package com.inventoryservice.controller;

import com.inventoryservice.dto.InventoryResponse;
import com.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone-13, iphone13-red
    // http://localhost:8082/api/inventory?sku-code=iphone-13&sku-code=iphone13-red

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }

}
