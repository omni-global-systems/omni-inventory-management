package com.omni.inventory_management.product.mapper;

import com.omni.inventory_management.inventory.dto.ProductDTO;
import com.omni.inventory_management.product.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product mapProductDTOToProduct(ProductDTO productDTO);

    ProductDTO mapProductToProductDTO(Product product);

    List<ProductDTO> mapListProductToListProductDTOs(List<Product> products);
}
