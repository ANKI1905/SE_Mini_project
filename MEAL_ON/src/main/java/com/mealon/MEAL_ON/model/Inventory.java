package com.mealon.MEAL_ON.model;

import javax.persistence.Entity;

@Entity
public class Inventory {
	
	private int Inventory_Id;
	
	private String Name;
	
	private int Stock;
	
	private int Avg_Price;
	
	private int Mess_id;

	/**
	 * @return the inventory_Id
	 */
	public int getInventory_Id() {
		return Inventory_Id;
	}

	/**
	 * @param inventory_Id the inventory_Id to set
	 */
	public void setInventory_Id(int inventory_Id) {
		Inventory_Id = inventory_Id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return Stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		Stock = stock;
	}

	/**
	 * @return the avg_Price
	 */
	public int getAvg_Price() {
		return Avg_Price;
	}

	/**
	 * @param avg_Price the avg_Price to set
	 */
	public void setAvg_Price(int avg_Price) {
		Avg_Price = avg_Price;
	}

	/**
	 * @return the mess_id
	 */
	public int getMess_id() {
		return Mess_id;
	}

	/**
	 * @param mess_id the mess_id to set
	 */
	public void setMess_id(int mess_id) {
		Mess_id = mess_id;
	}
	

}
