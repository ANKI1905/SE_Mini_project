package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.ReviewRating;


public interface ReviewRatingDAO extends CrudRepository<ReviewRating, Integer>{
	List<ReviewRating> findByMenuid(int menu_id);
	ReviewRating findByMenuidAndMis(int menu_id, int mis);
}
