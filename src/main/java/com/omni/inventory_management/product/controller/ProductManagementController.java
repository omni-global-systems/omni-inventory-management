package com.omni.inventory_management.product.controller;

import com.omni.inventory_management.inventory.dto.ProductDTO;
import com.omni.inventory_management.product.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/inventory-management/products")
public class ProductManagementController {

    private final ProductManagementService productManagementService;

    @Autowired
    public ProductManagementController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOs = productManagementService.getAllProducts();
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID id) {
        Optional<ProductDTO> product = productManagementService.getProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productManagementService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {
        try {
            ProductDTO updatedProduct = productManagementService.updateProduct(id, productDTO);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Return a ResponseEntity with a message body and 404 status
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Product not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable UUID id) {
        productManagementService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content after successful deletion
    }
}
