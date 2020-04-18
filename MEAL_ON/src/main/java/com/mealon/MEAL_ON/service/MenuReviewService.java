package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.MenuReview;

public interface MenuReviewService {
	
	Boolean add(Integer menu_id, Integer avgRating, String commentOverview);
	Boolean update(Integer menu_id, Integer avgRating, String commentOverview);
	Boolean delete(Integer menu_id);
	List<MenuReview> get(Integer[] menu_ids);
	


}
