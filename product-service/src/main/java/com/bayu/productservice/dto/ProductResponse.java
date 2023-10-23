package com.bayu.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Class Name: com.bayu.productservice.dto
 * Description: microservices-part-1
 * <p>
 * Author: bayub
 * Date: 23/10/2023
 * Last Modified: 15:06-23/10/2023-10-2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String id;

    private String name;

    private String description;

    private BigDecimal price;

}
