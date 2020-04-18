package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.MenuReview;

public interface ReviewRatingService {
	
	Boolean add(int mis, int menu_id, int rating, String comments);
	//Cannot update review, once added is final
	/*Boolean delete only to be used by Admin side
	* It deletes all reviews of particular menu
	* Confirm menu_id from mess_id
	*/
	Boolean delete(int menu_id);
	//obtain Integer[] menu_ids from MenuService
	List<MenuReview> getAll(Integer[] menu_ids);
	List<MenuReview> getByMis(Integer[] menu_ids, int mis);
	List<MenuReview> getByMenuid(Integer[] menu_ids, int menu_id);
	List<MenuReview> getByRatingLessThan(Integer[] menu_ids, int rating);
	List<MenuReview> getByRatingGreaterThan(Integer[] menu_ids, int rating);
	
	
	


}
