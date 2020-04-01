package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.Menu;

public interface MenuService {
List<Menu> get(int Mess_id);
	
	Menu get(int Menu_id, int Mess_id);
	
	void add(Menu menu);
	
	void delete(int Menu_id, int Mess_id);


}
