package com.pantry_management.services;


import com.pantry_management.models.Item;

public interface ItemService {
	public boolean addNewItem(Item item);
	public boolean deleteItem(int item_id);
	public boolean updateItemQuantity(int item_id,int quantity);
	public Item[] listAllAvailableItems();
}
