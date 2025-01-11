package com.omni.inventory_management.supplier.service;

import com.omni.inventory_management.inventory.dto.SupplierDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplierManagementService {
    List<SupplierDTO> getAllSuppliers();
    Optional<SupplierDTO> getSupplierById(UUID id);

    SupplierDTO createSupplier(SupplierDTO supplierDTO);


    SupplierDTO updateSupplier(UUID supplierId, SupplierDTO supplierDTO);

    void deleteSupplier(UUID id);
}
