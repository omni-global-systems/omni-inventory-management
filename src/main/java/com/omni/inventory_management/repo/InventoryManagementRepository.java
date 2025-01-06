package com.omni.inventory_management.repo;

import com.omni.inventory_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryManagementRepository extends JpaRepository<Product, Integer> {
}
