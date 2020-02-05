package com.pantry_management.DAO;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pantry_management.constants.ItemConstants;
import com.pantry_management.models.Item;

@Repository
public class ItemDAO {
	private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	JdbcTemplate jdbcTemplate;
	public boolean addNewItem(Item item) {
		if(this.checkIfItemIdExists(item.getItemId())) {
			logger.log(Level.WARNING,"Invalid itemID");
			return false;
		}
		else {
//			try {
				this.jdbcTemplate.update(ItemConstants.queries.POST_ITEM,item.getItemId(),item.getName(),item.getQuantity_available());
//			}
//			catch(Exception e) {
//				return false;
//			}
		}
		return true;
	}
	public boolean checkIfItemIdExists(int id) {
		try {
		this.jdbcTemplate.queryForObject(ItemConstants.queries.GET_ID,new Object[] {id},Integer.class);
		}
		catch(Exception e) {
			logger.log(Level.WARNING,"ItemID exists");
			return false;
		}
		return true;
	}
	public boolean updateItemQuantity(int id,int quantity) {
		if(quantity<0) {
			logger.log(Level.WARNING,"Invalid item quantity");
			return false;
		}
		try {
			this.jdbcTemplate.update(ItemConstants.queries.UPDATE_QUANTITY,quantity,id);
		}
		catch(Exception e) {
			logger.log(Level.WARNING,"Invalid itemID");
			return false;
		}
		return true;
	}
	public boolean deleteItem(int id) {
		try {
			this.jdbcTemplate.update(ItemConstants.queries.DELETE_ITEM,id);
		}
		catch(Exception e) {
			logger.log(Level.WARNING,"Invalid itemID");
			return false;
		}
		return true;
	}
	public Item[] listAvailableItems() {
		List<Map<String,Object>> itemmap=this.jdbcTemplate.queryForList(ItemConstants.queries.LIST_AVAILABLE_ITEMS);
		int i=0;
		Item[] items=new Item[itemmap.size()];
		for(Map<String,Object> map:itemmap) {
			Item item=new Item();
			item.setItemId((int)map.get("item_id"));
			item.setName((String)map.get("item_name"));
			item.setQuantity_available((int)map.get("quantity_available"));
			item.setQuantity_sold((int)map.get("quantity_sold"));
			items[i++]=item;
		}
		return items;
	}
}
