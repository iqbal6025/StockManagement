package com.ros.inventory.service;

import java.util.List;
import java.util.UUID;

import org.springframework.util.MultiValueMap;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.controller.dto.AddProductDto;
import com.ros.inventory.controller.dto.SupplierDescriptionDto;
import com.ros.inventory.controller.dto.SupplierDto;
import com.ros.inventory.entities.Supplier;

public interface ISupplierManager {

	Supplier saveSupplier(Supplier supply) throws InventoryException;

	Supplier updateSupplier(Supplier supply) throws InventoryException;

	List<SupplierDto> show() throws InventoryException;

	Supplier delete(UUID id) throws InventoryException;

	SupplierDto byName(String sName) throws InventoryException;

	SupplierDescriptionDto description(UUID id) throws InventoryException;

	Supplier addProduct(Supplier add) throws InventoryException;

}
