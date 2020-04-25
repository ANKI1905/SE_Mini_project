package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.MenuReview;

public interface MenuReviewDAO extends CrudRepository<MenuReview, Integer>{
	List<MenuReview> findByMessid(int messid);
}
