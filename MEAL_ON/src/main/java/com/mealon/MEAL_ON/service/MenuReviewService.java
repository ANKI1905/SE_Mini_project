package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.MenuReview;

public interface MenuReviewService {
	
	Boolean add(int mess_id, int menu_id, float avgRating, String commentOverview);
	Boolean update(int mess_id, int menu_id, float avgRating, String commentOverview);
	List<MenuReview> get(int mess_id);
	Boolean delete(int mess_id, int  menu_id);

}
