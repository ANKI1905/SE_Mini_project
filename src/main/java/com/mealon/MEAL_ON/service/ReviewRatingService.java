package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.ReviewRating;

public interface ReviewRatingService {
	
	Boolean add(int mis, int menu_id, int rating, String comments);
	//Updates review when a particular MIS rates particular Menu_id again and it is overwritten
	
	//obtain Integer[] menu_ids from MenuService
	List<ReviewRating> getAll(Integer[] menu_ids);
	List<ReviewRating> getByMis(Integer[] menu_ids, int mis);
	//Pick up menu_id from MenuServices get menu_id of corresponding name
	List<ReviewRating> getByMenuid(int menu_id);
	List<ReviewRating> getByRatingLessThanEqual(Integer[] menu_ids, int rating);
	List<ReviewRating> getByRatingGreaterThanEqual(Integer[] menu_ids, int rating);
	/*Boolean delete only to be used by Admin side
	* It deletes all reviews of particular menu
	* Confirm menu_id from mess_id
	*/
	Boolean delete(int menu_id);
	
}
