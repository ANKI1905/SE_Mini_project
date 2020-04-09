package com.mealon.MEAL_ON.dao;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.Inventory;

public interface InventoryDAO extends CrudRepository<Inventory, Integer>{

}
