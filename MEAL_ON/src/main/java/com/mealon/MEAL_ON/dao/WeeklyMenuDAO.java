package com.mealon.MEAL_ON.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.WeeklyMenu;
import com.mealon.MEAL_ON.model.WeeklyMenuID;


public interface WeeklyMenuDAO extends CrudRepository<WeeklyMenu, WeeklyMenuID>{
	List<WeeklyMenu> findByMessid(int messid);
	List<WeeklyMenu> findByMessidAndDay(int messid, String day);
	List<WeeklyMenu> findByMessidAndType(int messid, String type);

}