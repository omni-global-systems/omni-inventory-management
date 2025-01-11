package com.omni.inventory_management.inventory.controller;

import com.omni.inventory_management.inventory.service.InventoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryManagementController {

    @Autowired
    private InventoryManagementService inventoryManagementService;


}
