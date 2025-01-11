package com.omni.inventory_management.product.service;

import com.omni.inventory_management.inventory.dto.ProductDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductManagementService {

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(UUID productId);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(UUID productId, ProductDTO productDTO);

    void deleteProduct(UUID productId);
}

