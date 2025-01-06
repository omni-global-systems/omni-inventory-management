package com.omni.inventory_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
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
