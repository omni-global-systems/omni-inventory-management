package com.omni.inventory_management.service;

import com.omni.inventory_management.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryManagementServiceImpl implements InventoryManagementService {
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return Optional.empty();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(String id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {
    }
}
