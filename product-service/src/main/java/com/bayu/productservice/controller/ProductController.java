package com.bayu.productservice.controller;

import com.bayu.productservice.dto.ProductRequest;
import com.bayu.productservice.dto.ProductResponse;
import com.bayu.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class Name: com.bayu.productservice.controller
 * Description: microservices-part-1
 * <p>
 * Author: bayub
 * Date: 23/10/2023
 * Last Modified: 15:20-23/10/2023-10-2023
 */
@RestController
@RequestMapping(path = "/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}
