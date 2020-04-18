package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.Mess;


public interface MessService {
	
	Boolean add(String name, String password, String messadmin);
	Boolean check(String name, String password);
	//Very rarely used::
	List<Mess> get();
	//Used only when MessAdmin is logged in
	Mess get(String name);
	Boolean update(Integer mess_id, String name, String password, String messadmin, Integer rate);
	Boolean delete(int mess_id, String name, String password);

}
