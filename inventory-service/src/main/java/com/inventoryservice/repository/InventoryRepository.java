package com.inventoryservice.repository;

import com.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    List<Inventory> findBySkuCodeIn(List<String> skuCode);

}
