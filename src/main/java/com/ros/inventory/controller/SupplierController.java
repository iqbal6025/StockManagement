package com.ros.inventory.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.controller.dto.AddProductDto;
import com.ros.inventory.entities.Supplier;
import com.ros.inventory.service.ISupplierManager;

@RestController
@RequestMapping("/supplier")
@CrossOrigin("*")
public class SupplierController {
	@Autowired
	private ISupplierManager suppliermanager;

	/*-------------- FOR ADDING SUPPLIER ------------------------------------*/
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody Supplier supply) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<Object>(suppliermanager.saveSupplier(supply), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	/*------------------- FOR UPDATING SUPPLIER ----------------------------------*/
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Supplier supply) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<Object>(suppliermanager.updateSupplier(supply), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	/*--------------------FOR GETTING LIST OF ALL SUPPLIER DTO --------------------------------*/
	@GetMapping("/show")
	@ResponseBody
	public ResponseEntity<?> show() {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity(suppliermanager.show(), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	/*-------------------------- FOR GETTING PARTICULAR SUPPLIER BY NAME DTO-------------------------*/
	@GetMapping("/name/{sName}")
	@ResponseBody
	public ResponseEntity<?> bySupplierName(@PathVariable(value = "sName") String sName) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity(suppliermanager.byName(sName), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();

		}

		return response;
	}

	/*--------------------- FOR DELETING THE SUPPLIER ------------------------------*/
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
		ResponseEntity response;
		try {
			response = new ResponseEntity(suppliermanager.delete(id), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	/*------------------------------ FOR VEIWING THE PARTICULAR SUPPLIER DESCRIPTION------------------------------ */
	@GetMapping("/descp/{id}")
	@ResponseBody
	public ResponseEntity<?> getDescription(@PathVariable(value = "id") UUID id) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity(suppliermanager.description(id), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	/*------------------ FOR ADDING PRODUCT----------------------------------*/
	@PostMapping("/addproduct")
	@ResponseBody
	public ResponseEntity<?> addProduct(@RequestBody Supplier add) {
		ResponseEntity response;
		try {
			response = new ResponseEntity(suppliermanager.addProduct(add), HttpStatus.OK);
		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
}
