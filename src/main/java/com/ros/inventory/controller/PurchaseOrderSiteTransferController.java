package com.ros.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.Repository.PurchaseRepository;
import com.ros.inventory.service.IPurchaseOrderSiteTransferManager;


@RestController
@RequestMapping("/purchase/sitetransfer")
@CrossOrigin("*")
public class PurchaseOrderSiteTransferController {
	@Autowired
	private IPurchaseOrderSiteTransferManager sitetransfer;
	@Autowired
	private PurchaseRepository pRepo;

	
	@GetMapping("/view")
	   @ResponseBody
	   public ResponseEntity<?> show()
	   {
		   ResponseEntity response;
			   try
	   			{
				   response = new ResponseEntity(sitetransfer.showByStatus(),HttpStatus.OK);
	   			}
			   catch (InventoryException e)
				{
					response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
					e.printStackTrace();
				}
				return response;	
	   }
	/*...............Showing the Product Details.................. */
	@GetMapping("/PurchaseOrder")
	   @ResponseBody
	   public ResponseEntity<?> showproduct()
	   {
		   ResponseEntity response;
			   try
	   			{
				   response = new ResponseEntity(sitetransfer.showProduct(),HttpStatus.OK);
	   			}
			   catch (InventoryException e)
				{
					response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
					e.printStackTrace();
				}
				return response;	
	   }
/*..............Showing Delivery Details.............*/
	@GetMapping("/Delivery")
	   @ResponseBody
	   public ResponseEntity<?> showDelivery()
	   {
		   ResponseEntity response;
			   try
	   			{
				   response = new ResponseEntity(sitetransfer.showDelivery(),HttpStatus.OK);
	   			}
			   catch (InventoryException e)
				{
					response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
					e.printStackTrace();
				}
				return response;	
	   }
	/*..............Showing Delivery Details.............*/
	@GetMapping("/Invoice")
	   @ResponseBody
	   public ResponseEntity<?> showInvoice()
	   {
		   ResponseEntity response;
			   try
	   			{
				   response = new ResponseEntity(sitetransfer.showInvoice(),HttpStatus.OK);
	   			}
			   catch (InventoryException e)
				{
					response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
					e.printStackTrace();
				}
				return response;	
	   }

}
