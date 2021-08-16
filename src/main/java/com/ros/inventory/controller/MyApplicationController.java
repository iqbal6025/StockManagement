package com.ros.inventory.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ros.inventory.Exception.InventoryException;
import com.ros.inventory.controller.dto.ClosingValueDto;
import com.ros.inventory.controller.dto.Summary;
import com.ros.inventory.controller.dto.wastageDto;
import com.ros.inventory.service.IClosingValueService;
import com.ros.inventory.service.IWastageManager;
import com.ros.inventory.service.stockService;

@Controller
public class MyApplicationController {

	@Autowired
	private stockService prod;
	@Autowired
	private IWastageManager wastage1;
	@Autowired
	private IClosingValueService iclosing;

	@GetMapping("/home")
	public String show(Model model) throws InventoryException {

		model.addAttribute("close_stock", prod.get_view_close_stock());

		return "stockManagement";
	}

	@GetMapping("/StockPeriod.ftl")
	public String stockPeriod(Model model) {
		return "StockPeriod";
	}

	// List of wastage product
	@GetMapping("/wastage.ftl")
	public String wastage_list(Model model) throws InventoryException {
		Summary summary = prod.getSummary();
		model.addAttribute("endDate", summary.getStock_period_end_date());
		List<String> arr = new ArrayList();
		model.addAttribute("wastId", arr);
		model.addAttribute("purchase_size", prod.getpurchaseOrder().size());
		model.addAttribute("balance_size", prod.getStockBalance().size());
		model.addAttribute("open_size", prod.getOpenStock().size());
		model.addAttribute("wast_size", prod.showWastage().size());
		model.addAttribute("wastList", prod.showWastage());
		model.addAttribute("isWastage", false);
		model.addAttribute("addClose", true);
		return "wastage";
	}

	// delete wastage
	@GetMapping("/delete/{id}")
	public String deleteWastage(@PathVariable("id") UUID id) throws InventoryException {
		wastage1.delete(id);
		return "redirect:/wastage.ftl";
	}

	// List of Opening products
	@GetMapping("/Opening.ftl")
	public String OpeningList(Model model) throws InventoryException {

		Summary summary = prod.getSummary();
		model.addAttribute("endDate", summary.getStock_period_end_date());
		model.addAttribute("purchase_size", prod.getpurchaseOrder().size());
		model.addAttribute("balance_size", prod.getStockBalance().size());
		model.addAttribute("open_size", prod.getOpenStock().size());
		model.addAttribute("wast_size", prod.showWastage().size());
		model.addAttribute("openingList", prod.getOpenStock());
		return "Opening";
	}

	// List of purchase orders
	@GetMapping("/purchase.ftl")
	public String purchaseList(Model model) throws InventoryException {
		Summary summary = prod.getSummary();
		model.addAttribute("endDate", summary.getStock_period_end_date());
		model.addAttribute("purchase_size", prod.getpurchaseOrder().size());
		model.addAttribute("balance_size", prod.getStockBalance().size());
		model.addAttribute("open_size", prod.getOpenStock().size());
		model.addAttribute("wast_size", prod.showWastage().size());
		model.addAttribute("purchaseList", prod.getpurchaseOrder());
		return "purchase";
	}

	// SUMMARY
	@GetMapping("/summary.ftl")
	public String summaryList(Model model) throws InventoryException {
		model.addAttribute("purchase_size", prod.getpurchaseOrder().size());
		model.addAttribute("balance_size", prod.getStockBalance().size());
		model.addAttribute("open_size", prod.getOpenStock().size());
		model.addAttribute("wast_size", prod.showWastage().size());
		model.addAttribute("summary", prod.getSummary());

		return "summary";
	}

	// stock balance
	@GetMapping("/StockBalance.ftl")
	public String stockBalanceList(Model model) throws InventoryException {
		Summary summary = prod.getSummary();
		model.addAttribute("endDate", summary.getStock_period_end_date());
		model.addAttribute("purchase_size", prod.getpurchaseOrder().size());
		model.addAttribute("balance_size", prod.getStockBalance().size());
		model.addAttribute("open_size", prod.getOpenStock().size());
		model.addAttribute("wast_size", prod.showWastage().size());
		model.addAttribute("balance", prod.getStockBalance());
		return "StockBalance";
	}

	// close stock view
	@GetMapping("/closeStock/{id}")
	public String closeStock(Model model, @PathVariable("id") UUID id) throws InventoryException {

		prod.view_stock_detail_date(id);
		return "redirect:/summary.ftl";
	}

	@GetMapping("/back")
	public String back() throws InventoryException {
		prod.back_real_time();
		return "redirect:/home";
	}

	@GetMapping("/approve/{stockID}")
	public String approve(@PathVariable("stockID") UUID stockID) throws InventoryException {
		prod.approved_stock_period(stockID);
		return "redirect:/home";
	}

	@GetMapping("/create")
	public String add(Model model) {
		wastageDto wastage = new wastageDto();
		model.addAttribute("wastage", wastage);
		model.addAttribute("isUpdate", false);
		return "create";
	}

	@PostMapping("/create")
	public String createWastage(@ModelAttribute("wastage") wastageDto wastage) throws InventoryException {

		wastage1.add(wastage);
		return "redirect:/wastage.ftl";
	}

	// Close Stock period Status
	@GetMapping("/status/{stockID}")
	public ResponseEntity<?> closeStatus(@PathVariable("stockID") UUID stockID) {
		ResponseEntity<?> response;
		response = new ResponseEntity(prod.getStatus(stockID), HttpStatus.OK);

		return response;
	}

	// End Session
	@GetMapping("/EndSession")
	public String CloseSession(Model model) throws InventoryException {
		Summary summary = prod.getSummary();

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
		LocalDate d = summary.getStock_period_start_date();
		LocalDate startDate = summary.getStock_period_start_date();

		model.addAttribute("Day", startDate.getDayOfWeek());
		model.addAttribute("Date", startDate.getDayOfMonth());
		model.addAttribute("month", startDate.getMonthValue());
		model.addAttribute("year", startDate.getYear());

		model.addAttribute("endDate", ft.format(dNow));
		model.addAttribute("addProduct_", iclosing.getValues());
		return "EndSession";
	}

   // submit close list
	@RequestMapping(value = "/EndSession", method = RequestMethod.POST)
	public String addStock(@RequestBody List<ClosingValueDto> close_stock_values) throws InventoryException {
//		iclosing.setValues(close_stock_values);
		System.out.println("Data for closeStock "+close_stock_values);
		return "redirect:/home";
	}
}
