package com.pantry_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pantry_management.services.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/buyItem")
	@CrossOrigin
	public boolean buyItem(@RequestBody Map<String,Object> map) {
		String username=(String)map.get("username");
		int item_id=(int)map.get("itemId");
		int quantity_bought=(int)map.get("quantity_bought");
		return transactionService.buyItem(username, item_id, quantity_bought);
	}
	
	@GetMapping("/last30DaysItems/{username}")
	@CrossOrigin
	public List<Map<String,Object>> getItemsBoughtInLastMonth(@PathVariable String username){
		return transactionService.getItemsBoughtInLastMonth(username);
	}
}
