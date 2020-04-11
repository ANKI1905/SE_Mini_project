package com.mealon.MEAL_ON.dao;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.Mess;

public interface MessDAO extends CrudRepository<Mess, Integer>{
	Mess findByName(String name);

	Mess findByMessid(Integer messid);
}