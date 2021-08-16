package com.ros.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.controller.dto.CloseStockDto;
import com.ros.inventory.controller.dto.ClosingValueDto;
import com.ros.inventory.entities.PurchaseOrder;
import com.ros.inventory.service.IClosingValueService;

@RestController
@RequestMapping("/closing")
@CrossOrigin("*")
public class ClosingValueController {

	@Autowired
	IClosingValueService iclosingValue;
	// View Closing values

	// ------------------------ VIEW CLOSE VALUES ------------------------------//
	@GetMapping("/view_close_values")
	@ResponseBody
	public ResponseEntity<?> getItems() {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<Object>(iclosingValue.getValues(), HttpStatus.OK);

		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}

	// --------------------------PUT CLOSE VALUES----------------------------//
	@PostMapping("/set_close_values")
	@ResponseBody
	public ResponseEntity<?> setValues(@RequestBody List<ClosingValueDto> close_stock_values) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<Object>(iclosingValue.setValues(close_stock_values), HttpStatus.OK);

		} catch (InventoryException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
}
