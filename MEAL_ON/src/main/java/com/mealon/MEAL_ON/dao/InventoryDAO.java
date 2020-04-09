package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.Inventory;

public interface InventoryDAO extends CrudRepository<Inventory, Integer>{
	Inventory findByName(String name);
	List<Inventory> findByMessid(int mess_id);
}
