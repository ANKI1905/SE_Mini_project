package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.SnacksMenu;


public interface SnacksMenuDAO extends CrudRepository<SnacksMenu, Integer>{
	List<SnacksMenu> findByMessid(int messid);
	SnacksMenu findByName(String name);
}
