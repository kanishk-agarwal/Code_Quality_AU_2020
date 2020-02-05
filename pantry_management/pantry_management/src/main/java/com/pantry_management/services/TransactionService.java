package com.pantry_management.services;

import java.util.List;
import java.util.Map;

public interface TransactionService {
	public boolean buyItem(String username,int item_id,int quantity_bought);
	public List<Map<String,Object>> getItemsBoughtInLastMonth(String username);
}
