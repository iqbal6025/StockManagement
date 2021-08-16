package com.ros.inventory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.Repository.OpeningStockRepository;
import com.ros.inventory.Repository.PurchaseRepository;
import com.ros.inventory.Repository.SupplierBasicRepository;
import com.ros.inventory.Repository.SupplierRepository;
import com.ros.inventory.Repository.WastageRepository;
import com.ros.inventory.controller.dto.CloseStockDetailDto;
import com.ros.inventory.controller.dto.OpeningStockDto;
import com.ros.inventory.controller.dto.purchaseOrderDto;
import com.ros.inventory.controller.dto.wastageDto;
import com.ros.inventory.entities.OpeningStock;
import com.ros.inventory.entities.PurchaseOrder;
import com.ros.inventory.entities.Supplier;
import com.ros.inventory.entities.SupplierBasicInfo;
import com.ros.inventory.entities.Wastage;
import com.ros.inventory.mapper.OpenStockMapper;
import com.ros.inventory.mapper.PurchaseOrderDtoMapper;
import com.ros.inventory.mapper.PurchaseOrderMapper;
import com.ros.inventory.service.IStockEditService;
@Service
public class EditCloseStock implements IStockEditService {
	
	
	@Autowired
	OpeningStockRepository open_repo;
	@Autowired
	PurchaseRepository purchase_repo;
	@Autowired
	OpeningStockDto open_dto;
	@Autowired
	purchaseOrderDto purchase_dto;
	@Autowired
	OpenStockMapper open_mapper;
	@Autowired
	PurchaseOrderDtoMapper purchase_mapper;
	@Autowired
	wastageDto ws_dto;
	@Autowired
	SupplierBasicRepository supp_repo;
    @Autowired
    WastageRepository ws_repo;
	@Override
	public String update_in(CloseStockDetailDto update_detail) throws InventoryException {
		// TODO Auto-generated method stub
		
		
		for(OpeningStockDto s:update_detail.getOpen_stock()) {
		//	OpeningStockDto open=new OpeningStockDto();
			
			OpeningStock open =open_repo.getData(s.getProductCode(), s.getProductName());
			
			open.setProductCode(s.getProductCode());
			open.setPricePerUnit(s.getPricePerUnit());
			open.setProductName(s.getProductName());
			open.setQty(s.getQty());
			open.setUnitMeasurement(s.getUnitMeasurement());
			open_repo.save(open);
			
		}
		
		for(purchaseOrderDto p:update_detail.getPurchase_order()) {
			
		//	purchaseOrderDto purchase=new purchaseOrderDto();
			
			PurchaseOrder purchase=purchase_repo.getOne(p.getPurchasedId());
			SupplierBasicInfo supplier=supp_repo.getOne(purchase.getSupplier().getSupplierBasic().getSupplierInfoId());
			//purchaseOrderDto purchase=purchase_mapper.convertTopurchaseOrderDto(purchase_);
			purchase.setPurchasedId(p.getPurchasedId());
			purchase.setPurchaseOrderDate(p.getPurchaseOrderDate());
			purchase.setPurchaseOrderStatus(p.getPurchaseOrderStatus());
		//	purchase.setSupplierBusinessName(p.getSupplierBusinessName());		
			purchase.setTotalAmount(p.getTotalAmount());
			supplier.setSupplierBusinessName(p.getSupplierBusinessName());
			purchase_repo.save(purchase);
		}
		
		for(wastageDto wss:update_detail.getWastage()) {
		//	wastageDto ws=new wastageDto();
			Wastage ws=ws_repo.getOne(wss.getWastageId());
			ws.setProductCode(wss.getProductCode());
			ws.setProductName(wss.getProductName());
			ws.setPricePerUnit(wss.getPricePerUnit());
			ws.setUnitMeasurement(wss.getUnitMeasurement());
			ws.setWastageId(wss.getWastageId());
			ws_repo.save(ws);
		}
		return "Updated";
	}

}