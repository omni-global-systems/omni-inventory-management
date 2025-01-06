package com.omni.inventory_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "customer_id")
    private UUID customerId; // Optional, can be linked to a customer entity

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private String status; // Status of the order (e.g., "Pending", "Completed")

    private String remarks; // Additional notes related to the order
}
