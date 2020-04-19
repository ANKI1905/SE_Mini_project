package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.MenuReview;

public interface MenuReviewService {
	
	Boolean add(int mess_id, int menu_id, Integer avgRating, String commentOverview);
	Boolean update(int mess_id, int menu_id, Integer avgRating, String commentOverview);
	Boolean delete(int mess_id, int  menu_id);
	List<MenuReview> get(int mess_id);
	


}
