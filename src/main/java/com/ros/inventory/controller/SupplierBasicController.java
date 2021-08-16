package com.ros.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.service.ISupplierBasicManager;

@RestController
@RequestMapping("/supplierbasic")
@CrossOrigin("*")
public class SupplierBasicController {
	@Autowired
	ISupplierBasicManager supplierbasic;
//
//	/* FOR GETTING BASIC INFORMATION OF PARTICULAR SUPPLIER ID*/
//	@GetMapping("/{id}")
//	@ResponseBody
//	public ResponseEntity<?> showBasic(@PathVariable(value = "id") long id) {
//		ResponseEntity response;
//		try {
//			response = new ResponseEntity(supplierbasic.showBasic(id), HttpStatus.OK);
//		} catch (InventoryException e) {
//			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
//			e.printStackTrace();
//		}
//		return response;
//	}
//
//	/*FOR GETTING THE IMAGE OF PARTICULAR SUPPLIER*/
//	@GetMapping("/image/{id}")
//	@ResponseBody
//	public ResponseEntity<?> show(@PathVariable(name = "id") long id) {
//		ResponseEntity response;
//		try {
//			response = new ResponseEntity(supplierbasic.showimage(id), HttpStatus.OK);
//		} catch (InventoryException e) {
//			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
//			e.printStackTrace();
//		}
//		return response;
//	}

}
