package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.SnacksToken;


public interface SnacksTokenService {
	//date_time will be auto generated as current time
	Boolean add(int mis, int snacks_id, int id, int price);
	List<SnacksToken> get(int mis);
	
	Boolean delete(String datetime, int mis, int snacks_id, int id, int price);


}
