package com.mealon.MEAL_ON.dao;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.Student;

public interface StudentDAO extends CrudRepository<Student, Integer>{

	Student findByName(String name);
	Student findByMis(Integer mis);
	
}