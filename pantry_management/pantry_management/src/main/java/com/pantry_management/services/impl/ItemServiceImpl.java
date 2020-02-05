package com.pantry_management.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pantry_management.DAO.ItemDAO;
import com.pantry_management.models.Item;
import com.pantry_management.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;
	@Override
	public boolean addNewItem(Item item) {
		return itemDAO.addNewItem(item);
	}

	@Override
	public boolean deleteItem(int item_id) {
		return itemDAO.deleteItem(item_id);
	}

	@Override
	public boolean updateItemQuantity(int item_id, int quantity) {
		return itemDAO.updateItemQuantity(item_id, quantity);
	}

	@Override
	public Item[] listAllAvailableItems() {
		return itemDAO.listAvailableItems();
	}
	
}
