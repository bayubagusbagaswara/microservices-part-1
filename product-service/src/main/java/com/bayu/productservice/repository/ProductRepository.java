package com.bayu.productservice.repository;

import com.bayu.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class Name: com.bayu.productservice.repository
 * Description: microservices-part-1
 * <p>
 * Author: bayub
 * Date: 23/10/2023
 * Last Modified: 14:59-23/10/2023-10-2023
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
