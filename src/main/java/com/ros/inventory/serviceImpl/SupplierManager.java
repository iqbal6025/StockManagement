package com.ros.inventory.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.Repository.ProductRepository;
import com.ros.inventory.Repository.SupplierRepository;
import com.ros.inventory.controller.dto.AddProductDto;
import com.ros.inventory.controller.dto.ProductDto;
import com.ros.inventory.controller.dto.SupplierDescriptionDto;
import com.ros.inventory.controller.dto.SupplierDto;
import com.ros.inventory.entities.Product;
import com.ros.inventory.entities.Supplier;
import com.ros.inventory.mapper.AddProductMapper;
import com.ros.inventory.mapper.ProductMapper;
import com.ros.inventory.mapper.SupplierDescriptionMapper;
import com.ros.inventory.mapper.SupplierMapper;
import com.ros.inventory.service.ISupplierManager;

@Service
@Transactional
public class SupplierManager implements ISupplierManager {
	@Autowired
	SupplierRepository supplyRepo;

	@Autowired
	private SupplierMapper supplierMapper;

	@Autowired
	private SupplierDescriptionMapper exMapper;

	@Autowired
	private AddProductMapper addMapper;

	@Autowired
	private ProductMapper pMapper;

	@Override
	public Supplier saveSupplier(Supplier supply) throws InventoryException {
		// TODO Auto-generated method stub
		Supplier supplierFromDB = supplyRepo.getById(supply.getSupplierId());

		if (supplierFromDB != null) {
			throw new InventoryException("Supplier Already Exist");
		}

		return supplyRepo.saveAndFlush(supply);
	}

	@Override
	@Modifying
	public Supplier updateSupplier(Supplier supply) throws InventoryException {
		// TODO Auto-generated method stub

		supply.setProducts(null);

		Supplier supplier = supplyRepo.getById(supply.getSupplierId());

		supply.setProducts(supplier.getProducts());

		return supplyRepo.saveAndFlush(supply);
	}

	@Override
	public List<SupplierDto> show() throws InventoryException {
		// TODO Auto-generated method stub
		List<Supplier> supplierFromDB = supplyRepo.getAll();

		if (supplierFromDB == null || supplierFromDB.size() == 0) {
			throw new InventoryException(" No Supplier Is Present");
		}

		List<SupplierDto> suppdto = new ArrayList<SupplierDto>();

		for (Supplier s : supplierFromDB) {
			SupplierDto d = supplierMapper.convertToSupplierDto(s);
			suppdto.add(d);
		}

		return suppdto;
	}

	@Override
	public Supplier delete(UUID id) throws InventoryException {
		// TODO Auto-generated method stub
		Supplier supplierFromDB = supplyRepo.getById(id);

		if (supplierFromDB == null) {
			throw new InventoryException("No Supplier is present");
		} else {
			supplyRepo.deleteById(id);
		}
		return supplierFromDB;
	}

	@Override
	public SupplierDto byName(String sName) throws InventoryException {
		// TODO Auto-generated method stub
		Supplier supplierFromDB = supplyRepo.getByName(sName);
		if (supplierFromDB == null) {
			throw new InventoryException(" No Supplier Is Present by this name");
		}

		SupplierDto dto = supplierMapper.convertToSupplierDto(supplierFromDB);

		return dto;

	}

	@Override
	public SupplierDescriptionDto description(UUID id) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier supplierFromDB = supplyRepo.getById(id);
		if (supplierFromDB == null) {
			throw new InventoryException("Supplier Details is not present");
		}

		SupplierDescriptionDto Dto = exMapper.convertToDto(supplierFromDB);
		return Dto;

	}

	@Override
	@Modifying
	public Supplier addProduct(Supplier addProduct) throws InventoryException {
		// TODO Auto-generated method stub

		Supplier s = supplyRepo.getById(addProduct.getSupplierId());

		s.getProducts().addAll(addProduct.getProducts());

		return supplyRepo.saveAndFlush(s);

	}

}
