package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.MessStaff;

public interface MessStaffDAO extends CrudRepository <MessStaff, Integer>{
	MessStaff findByStaffid(Long staff_id);

    List<MessStaff> findAllByMessid(Long mess_id);

}
