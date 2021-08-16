package com.ros.inventory.controller.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class stock_balance {

	
	private long productCode;
	private String productName;
	private int opening_qty;
	private int ordered_qty;
	private long wastage_qty;
	private long total;
}
