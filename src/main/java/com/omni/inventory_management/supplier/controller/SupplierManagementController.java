package com.omni.inventory_management.supplier.controller;

import com.omni.inventory_management.inventory.dto.SupplierDTO;
import com.omni.inventory_management.supplier.service.SupplierManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/inventory-management/suppliers")
public class SupplierManagementController {

    private final SupplierManagementService supplierManagementService;

    public SupplierManagementController(SupplierManagementService supplierManagementService) {
        this.supplierManagementService = supplierManagementService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> supplierDTOs = supplierManagementService.getAllSuppliers();
        return ResponseEntity.ok(supplierDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable UUID id) {
        Optional<SupplierDTO> supplier = supplierManagementService.getSupplierById(id);
        return supplier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        SupplierDTO createdSupplier = supplierManagementService.createSupplier(supplierDTO);
        return ResponseEntity.ok(createdSupplier);
    }

    // Update an existing supplier
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSupplier(@PathVariable UUID id, @RequestBody SupplierDTO supplierDTO) {
        try {
            SupplierDTO updatedSupplier = supplierManagementService.updateSupplier(id, supplierDTO);
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Return a ResponseEntity with a message body and 404 status
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Supplier not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupplier(@PathVariable UUID id) {
        supplierManagementService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content after successful deletion
    }
}
