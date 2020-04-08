package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.Inventory;

public interface InventoryService {
	List<Inventory> get();
	void add(Inventory obj);
	void update(int id, Inventory obj);
	void delete(int id);
	Inventory get(int id);

}
