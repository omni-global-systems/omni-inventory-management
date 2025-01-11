package com.omni.inventory_management.supplier.service;

import com.omni.inventory_management.inventory.dto.SupplierDTO;
import com.omni.inventory_management.supplier.entity.Supplier;
import com.omni.inventory_management.supplier.mapper.SupplierMapper;
import com.omni.inventory_management.supplier.repo.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierManagementServiceImpl implements SupplierManagementService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierManagementServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public Optional<SupplierDTO> getSupplierById(UUID id) {
        Optional<Supplier> foundSupplier = supplierRepository.findById(id);
        return foundSupplier.map(supplierMapper::mapSupplierToSupplierDTO);
    }
    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.mapListSupplierToListSupplierDTOs(supplierRepository.findAll());
    }

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {

        // Map SupplierDTO to Supplier entity
        Supplier supplierToSave = supplierMapper.mapSupplierDTOToSupplier(supplierDTO);

        // Save the Supplier entity to the repository
        Supplier savedSupplier = supplierRepository.save(supplierToSave);

        // Return the SupplierDTO
        return supplierMapper.mapSupplierToSupplierDTO(savedSupplier);
    }

    @Override
    public SupplierDTO updateSupplier(UUID supplierId, SupplierDTO supplierDTO) {
        if (supplierRepository.existsById(supplierId)) {
            Supplier mappedSupplier = supplierMapper.mapSupplierDTOToSupplier(supplierDTO);
            return supplierMapper.mapSupplierToSupplierDTO(supplierRepository.save(mappedSupplier));
        }
        throw new IllegalArgumentException("Supplier with ID " + supplierId + " not found.");
    }

    @Override
    public void deleteSupplier(UUID id) {
        supplierRepository.deleteById(id);
    }
}
