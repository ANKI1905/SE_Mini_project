package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.menu;

public interface MenuService {
	
	void addMenu(Integer mess_id, String name);
	
	List<menu> getMenu(int mess_id);
	
	void updateMenu(Integer mess_id, String name)
	
	void deleteMenu(int menu_id, int mess_id);


}
