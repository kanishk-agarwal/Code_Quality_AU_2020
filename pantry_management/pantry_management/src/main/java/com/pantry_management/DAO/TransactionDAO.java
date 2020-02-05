package com.pantry_management.DAO;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pantry_management.constants.ItemConstants;
import com.pantry_management.constants.TransactionConstants;
import com.pantry_management.constants.UserConstants;
import com.pantry_management.util.GenerateDate;

@Repository
public class TransactionDAO {
	private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	JdbcTemplate jdbcTemplate;
	public boolean buyItem(String username,int item_id,int quantity_bought) {
		Date d=GenerateDate.generateDate();
		java.sql.Date dop=new java.sql.Date(d.getTime());
		if(this.getItemQuantity(item_id)<quantity_bought || quantity_bought<=0) {
			logger.log(Level.WARNING,"Invalid item quantity");
			return false;
		}
		else {
		try {
			int user_id=this.getUserID(username);
			this.jdbcTemplate.update(TransactionConstants.queries.BUY_ITEM,item_id,user_id,dop,quantity_bought);
			this.jdbcTemplate.update(TransactionConstants.queries.UPDATE_ITEM_QUANITY_SOLD,quantity_bought,item_id);
			this.jdbcTemplate.update(TransactionConstants.queries.UPDATE_ITEM_QUANTITY_AVAILABLE,quantity_bought,item_id);
		}
		catch(Exception e) {
			logger.log(Level.WARNING,"Invalid entry");
			return false;
		}
		return true;
		}
	}
	public List<Map<String,Object>> getItemsBoughtInLastMonth(String username) {
		int user_id=this.getUserID(username);
		List<Map<String,Object>> itemList=this.jdbcTemplate.queryForList(TransactionConstants.queries.GET_ITEM_DETAILS_BOUGHT_TILL_LAST_MONTH,
				user_id,GenerateDate.generateDate30DaysBefore());
		if(itemList.isEmpty()) {
			logger.log(Level.INFO,"User has not bought anything");
			return null;
		}
		return itemList;
	}
	public int getUserID(String username) {
		int id=this.jdbcTemplate.queryForObject(UserConstants.queries.GET_ID_FROM_USERNAME,new Object[] {username},Integer.class);
		return id;
	}
	public int getItemQuantity(int item_id) {
		int quantity=this.jdbcTemplate.queryForObject(ItemConstants.queries.GET_QUANTITY_AVAILABLE,new Object[] {item_id},Integer.class);
		return quantity;
	}
}
