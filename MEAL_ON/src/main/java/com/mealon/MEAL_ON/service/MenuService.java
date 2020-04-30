package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.Menu;

public interface MenuService {
	
	void add(Integer mess_id, String name);
	
	//Also used by WeeklyMenuService to check if the menu exists in particular mess
	List<Menu> get(int mess_id);
	Integer[] getMenuIDs(int mess_id);
	//This will be rarely used
	Menu get(int mess_id, int menu_id);
	
	void delete(int mess_id, String name);

	int getMenuID(int mess_id, String name);
}
