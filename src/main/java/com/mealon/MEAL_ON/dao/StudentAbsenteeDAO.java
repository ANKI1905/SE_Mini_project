package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.StudentAbsentee;
import com.mealon.MEAL_ON.model.StudentAbsenteeID;


public interface StudentAbsenteeDAO extends CrudRepository<StudentAbsentee, StudentAbsenteeID>{
	List<StudentAbsentee> findByMis(int mis);
}
