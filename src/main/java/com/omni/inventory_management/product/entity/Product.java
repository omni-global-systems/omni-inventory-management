package com.omni.inventory_management.product.entity;

import com.omni.inventory_management.supplier.entity.Supplier;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Assuming UUID as the primary key type
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String manufacturer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @Column(nullable = false, unique = true)
    private String sku;

    private String description;

    private String category;

    private java.time.LocalDate expiryDate;

    @Column(name = "quantity_in_stock", nullable = false)
    private int quantityInStock;

    @Column(name = "unit_type")
    private String unitType;

    @Column(name = "price_per_unit")
    private String pricePerUnit;

    private String currency;

    @Column(name = "last_supplied")
    private java.time.LocalDate lastSupplied;

    @Column(name = "last_supplied_quantity")
    private int lastSuppliedQuantity;

    @Column(name = "restock_threshold")
    private int restockThreshold;
}
