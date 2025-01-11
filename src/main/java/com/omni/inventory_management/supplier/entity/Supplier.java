package com.omni.inventory_management.supplier.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Assuming UUID as the primary key type
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "contact_info")
    private String contactInfo;

    private String address;

    private Double rating;

    @Column(name = "lead_time")
    private int leadTime; // Average delivery lead time in days

    private String remarks;
}
