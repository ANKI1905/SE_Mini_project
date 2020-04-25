package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.MessStaff;

public interface MessStaffDAO extends CrudRepository <MessStaff, Integer>{
	
	MessStaff findByNameAndMessid(String name, int messid);
    List<MessStaff> findAllByMessid(int mess_id);

}