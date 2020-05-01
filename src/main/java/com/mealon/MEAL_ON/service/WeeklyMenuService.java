package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.WeeklyMenu;

public interface WeeklyMenuService {
	//Used only by mess admins
	Boolean add(int mess_id, String day, String type, String menu_id_array);
	//Used by mes admins before adding/updating to this table
	Boolean check(int mess_id, String menu_id_array);
	//Used by mess admins and students
	List<WeeklyMenu> get(int mess_id);
	//Used by mess admins and students
	List<WeeklyMenu> getbyDay(int mess_id, String day);
	//Used only by mess admin
	List<WeeklyMenu> getbyType(int mess_id, String type);
	//Used by mess admins and students
	WeeklyMenu getbyDayAndType(int mess_id, String day, String type);
	//Used only by mess admins
	Boolean delete(int mess_id, String day, String type);
	//Used only by mess admins
	Boolean update(int mess_id, String day, String type, String menu_id_array);


}