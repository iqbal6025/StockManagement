package com.ros.inventory.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.ros.inventory.entities.TransferType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiTeTransfersDto {		
	private String date;
	private TransferType transferType;
	private SupplierDto2 supplier;
}
