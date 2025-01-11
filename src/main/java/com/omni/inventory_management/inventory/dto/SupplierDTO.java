package com.omni.inventory_management.inventory.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
public class SupplierDTO {
    private UUID id;
    private String name;
    private String contactInfo;
    private String address;
    private Double rating;
    private Integer leadTime;
    private String remarks;
}
