package com.ros.inventory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.Repository.AddressRepository;
import com.ros.inventory.entities.Address;
import com.ros.inventory.service.IAddressManager;

@Service
public class AddressManager implements IAddressManager
{
   @Autowired
   AddressRepository addRepo;
	
//	@Override
//	public Address showAddress(long id) throws InventoryException
//	{
//		// TODO Auto-generated method stub
//		
//		Address DB = addRepo.getByAddress(id);
//		if(DB == null)
//		 {
//			 throw new InventoryException(" Information not available");
//		 }
//		return DB;
//	}

}
