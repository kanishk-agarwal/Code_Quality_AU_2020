package com.pantry_management.constants;

public class ItemConstants {
	public static class queries{
		public final static String POST_ITEM="Insert into items(item_id,item_name,quantity_available) values(?,?,?)";
		public final static String GET_QUANTITY_AVAILABLE="select quantity_available from items where item_id=?";
		public final static String GET_ID="select top 1 item_id from items where item_id=?";
		public final static String UPDATE_QUANTITY="update items set quantity_available=? where item_id=?";
		public final static String DELETE_ITEM="delete from items where item_id=?";
		public final static String LIST_AVAILABLE_ITEMS="select * from items where quantity_available>0";
		public final static String GET_AVAILABLE_AMOUNT="select quantity_available from items where item_id=?";
	}
}
