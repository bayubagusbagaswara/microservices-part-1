package com.bayu.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Class Name: com.bayu.productservice.model
 * Description: microservices-part-1
 * <p>
 * Author: bayub
 * Date: 23/10/2023
 * Last Modified: 14:55-23/10/2023-10-2023
 */
@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

}
