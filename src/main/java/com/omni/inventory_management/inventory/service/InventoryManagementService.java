package com.omni.inventory_management.inventory.service;

import com.omni.inventory_management.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface InventoryManagementService {

    // Methods for managing products
    List<Product> getAllProducts();
    Optional<Product> getProductById(String id);
    Product createProduct(Product product);
    Product updateProduct(String id, Product product);
    void deleteProduct(String id);

    // You can add similar methods for Supplier, Order, and OrderItem here
}
