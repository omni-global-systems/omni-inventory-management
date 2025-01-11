package com.omni.inventory_management.inventory.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProductDTO {

    private UUID id;
    private String name;
    private String manufacturer;
    private String supplierId;
    private SupplierDTO supplier;
    private String sku;
    private String description;
    private String category;
    private LocalDate expiryDate;
    private int quantityInStock;
    private String unitType;
    private String pricePerUnit;
    private String currency;
    private LocalDate lastSupplied;
    private int lastSuppliedQuantity;
    private int restockThreshold;
}
