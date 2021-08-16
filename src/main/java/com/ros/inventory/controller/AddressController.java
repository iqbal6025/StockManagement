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
import com.ros.inventory.service.IAddressManager;

@RestController
@RequestMapping("/address")
@CrossOrigin("*")
public class AddressController
{
	@Autowired
	IAddressManager addressmanager;
	
//	/*FOR GETTING ADDRESS BY ID*/
//	  @GetMapping("/{id}")
//	   @ResponseBody
//	   public ResponseEntity<?> showAddress(@PathVariable(value="id") long id)
//	   {
//		   ResponseEntity response;
//			   try
//	   			{
//				   response = new ResponseEntity(addressmanager.showAddress(id),HttpStatus.OK);
//	   			}
//			   catch (InventoryException e)
//				{
//					response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
//					e.printStackTrace();
//				}
//				return response;	
//	   }
}
