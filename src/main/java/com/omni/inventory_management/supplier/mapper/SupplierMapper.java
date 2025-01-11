package com.omni.inventory_management.supplier.mapper;

import com.omni.inventory_management.inventory.dto.SupplierDTO;
import com.omni.inventory_management.supplier.entity.Supplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    Supplier mapSupplierDTOToSupplier(SupplierDTO supplierDTO);

    SupplierDTO mapSupplierToSupplierDTO(Supplier supplier);

    List<SupplierDTO> mapListSupplierToListSupplierDTOs(List<Supplier> suppliers);
}
