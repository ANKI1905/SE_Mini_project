package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.Mess;


public interface MessService {
	
	String add(String name, String password, String messadmin);
	List<Mess> get();
	Mess get(String name, String password);
	String update(Integer mess_id, String name, String password, String messadmin, Integer rate);
	String delete(int mess_id, String name, String password);

}
