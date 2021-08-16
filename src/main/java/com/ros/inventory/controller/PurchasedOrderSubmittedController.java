package com.ros.inventory.controller;

import java.util.List;
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
import com.ros.inventory.controller.dto.DraftsDto;
import com.ros.inventory.entities.PurchaseOrder;
import com.ros.inventory.service.IPurchaseOrderManager;
import com.ros.inventory.service.IPurchasedOrderSubmittedManager;

@RestController
@RequestMapping("/purchase/submitted")
@CrossOrigin("*")
public class PurchasedOrderSubmittedController {
	
	@Autowired
	private  IPurchasedOrderSubmittedManager purchaseorderSubmitted;
	
	/*.............Saving Purchase Order in Submitted section........*/
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<?> addItem(@RequestBody PurchaseOrder purchase )
	{
		ResponseEntity<?> response;
		try
		{
			response=new ResponseEntity<Object>(purchaseorderSubmitted.save(purchase),HttpStatus.OK);
		}
		catch (InventoryException e)
		{
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;	
	}
/* ...........  View PurchaseOrder in Submitted section .............. */
	@GetMapping("/view")
	   @ResponseBody
	   public ResponseEntity<?> show()
	   {
		   ResponseEntity response;
			   try
	   			{
				   response = new ResponseEntity(purchaseorderSubmitted.showByStatus(),HttpStatus.OK);
	   			}
			   catch (InventoryException e)
				{
					response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
					e.printStackTrace();
				}
				return response;	
	   }
/* ..............  Rejecting the Purchase Order in Submitted ........ */
	@DeleteMapping("/delete/{id}")
	   @ResponseBody
	   public ResponseEntity<?> delete(@PathVariable(name="id") UUID id)
	   {
		   ResponseEntity response;
		   try
		   {
			   response = new ResponseEntity(purchaseorderSubmitted.delete(id),HttpStatus.OK);
		   }
		   catch (InventoryException e)
			{
				response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
				e.printStackTrace();
			}
			return response;	
	   }

/*..........Approve Single PurchaseOrder................ */
	@PutMapping("/approvePurchaseOrder/{purchasedId}")
	@ResponseBody
	public ResponseEntity<?> approvedPurchaseOrder(@PathVariable("purchasedId") UUID purchasedId) throws InventoryException{
		ResponseEntity<?> response;
		response=new ResponseEntity(purchaseorderSubmitted.approveSinglePurchaseOrder(purchasedId),HttpStatus.OK);
				//prod.approved_stock_period(purchasedId),HttpStatus.OK);
		return response;
	}
	/*..........Reject Single PurchaseOrder................ */
	@PutMapping("/rejectPurchaseOrder/{purchasedId}")
	@ResponseBody
	public ResponseEntity<?> rejectedPurchaseOrder(@PathVariable("purchasedId") UUID purchasedId) throws InventoryException{
		ResponseEntity<?> response;
		response=new ResponseEntity(purchaseorderSubmitted.rejectSinglePurchaseOrder(purchasedId),HttpStatus.OK);
		return response;
	}
	/*..........Approve bulk PurchaseOrders................ */
	@PutMapping("/bulkApproval")
	@ResponseBody
	public ResponseEntity<?> bulk_approved(@RequestBody List<DraftsDto> bulkapprove)
			throws InventoryException {
		ResponseEntity<?> response;

		//System.out.println(close_stock_bulk);

		response = new ResponseEntity<Object>(purchaseorderSubmitted.bulkApprove(bulkapprove), HttpStatus.OK);

		return response;
	}
	/*..........Reject bulk PurchaseOrders................ */
	@PutMapping("/bulkRejected")
	@ResponseBody
	public ResponseEntity<?> bulkRejected(@RequestBody List<DraftsDto> bulkreject)
			throws InventoryException {
		ResponseEntity<?> response;

		//System.out.println(close_stock_bulk);

		response = new ResponseEntity<Object>(purchaseorderSubmitted.bulkReject(bulkreject), HttpStatus.OK);

		return response;
	}
	
}
