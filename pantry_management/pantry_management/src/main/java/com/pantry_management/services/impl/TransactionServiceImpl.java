package com.pantry_management.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pantry_management.DAO.TransactionDAO;
import com.pantry_management.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDAO transactionDAO;
	@Override
	public boolean buyItem(String username, int item_id, int quantity_bought) {
		return transactionDAO.buyItem(username, item_id, quantity_bought);
	}
	
	public List<Map<String,Object>> getItemsBoughtInLastMonth(String username){
		return transactionDAO.getItemsBoughtInLastMonth(username);
	}

}
