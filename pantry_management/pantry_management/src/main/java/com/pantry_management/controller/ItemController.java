package com.pantry_management.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pantry_management.models.Item;
import com.pantry_management.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@PostMapping("/addItem")
	@CrossOrigin
	public boolean addNewItem(@RequestBody Item item) {
		return itemService.addNewItem(item);
	}
	
	@PostMapping("/updateItem")
	@CrossOrigin
	public boolean updateItemQuantity(@RequestBody Map<String,Integer> map) {
		int item_id=(int)map.get("item_id");
		int quantity=(int)map.get("quantity");
		return itemService.updateItemQuantity(item_id, quantity);
	}
	
	@DeleteMapping("/deleteItem/{item_id}")
	@CrossOrigin
	public boolean deleteItem(@PathVariable int item_id) {
		return itemService.deleteItem(item_id);
	}
	
	@GetMapping("/getAllAvailableItems")
	@CrossOrigin
	public Item[] listAllAvailableItems() {
		return itemService.listAllAvailableItems();
	}
}
