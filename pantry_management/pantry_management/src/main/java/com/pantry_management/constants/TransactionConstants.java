package com.pantry_management.constants;

public class TransactionConstants {
	public static class queries{
		public final static String UPDATE_ITEM_QUANTITY_AVAILABLE="update items set quantity_available=quantity_available-? where item_id=?";
		public final static String BUY_ITEM="insert into items_bought(item_id,user_id,DOP,Quantity)  values(?,?,?,?)";
		public final static String UPDATE_ITEM_QUANITY_SOLD="update items set quantity_sold=quantity_sold+? where item_id=?";
		public final static String GET_ITEM_DETAILS_BOUGHT_TILL_LAST_MONTH="select items.item_id,items.item_name,items_bought.quantity,items_bought.DOP from items,items_bought where items.item_id=items_bought.item_id && items_bought.user_id=? && items_bought.DOP>=?";
	}

}
