package com.omni.inventory_management.product.service;

import com.omni.inventory_management.inventory.dto.ProductDTO;
import com.omni.inventory_management.product.entity.Product;
import com.omni.inventory_management.product.mapper.ProductMapper;
import com.omni.inventory_management.product.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductManagementServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {

        return productMapper.mapListProductToListProductDTOs(productRepository.findAll());
    }

    @Override
    public Optional<ProductDTO> getProductById(UUID productId) {
        Optional<Product> foundProduct = productRepository.findById(productId);
        return foundProduct.map(productMapper::mapProductToProductDTO);
    }


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        // Map ProductDTO to Product entity
        Product productToSave = productMapper.mapProductDTOToProduct(productDTO);

        // Save the Product entity to the repository
        Product savedProduct = productRepository.save(productToSave);

        // Return the ProductDTO
        return productMapper.mapProductToProductDTO(savedProduct);
    }


    @Override
    public ProductDTO updateProduct(UUID productId, ProductDTO productDTO) {
        if (productRepository.existsById(productId)) {
            Product mappedProduct = productMapper.mapProductDTOToProduct(productDTO);
            return productMapper.mapProductToProductDTO(productRepository.save(mappedProduct));
        }
        throw new IllegalArgumentException("Product with ID " + productId + " not found.");
    }

    @Override
    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }
}
