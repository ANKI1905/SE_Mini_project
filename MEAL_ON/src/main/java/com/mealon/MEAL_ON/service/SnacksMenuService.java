package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.SnacksMenu;

public interface SnacksMenuService {
	//snacks_id will be auto generated
	Boolean add(String name, int price, int mess_id);
	List<SnacksMenu> get(int mess_id);
	//send snacks_id by SnacksMenu.get().getSnacksid
	Boolean updated(int snacks_id, String name, int price, int mess_id);
	SnacksMenu get(int mess_id, String name);
	Boolean delete(int mess_id, String name);


}
