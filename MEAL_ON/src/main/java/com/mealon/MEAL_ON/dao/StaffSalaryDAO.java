package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.StaffSalary;
import com.mealon.MEAL_ON.model.StaffSalaryID;


public interface StaffSalaryDAO extends CrudRepository<StaffSalary, StaffSalaryID>{
	List<StaffSalary> findByStaffid(int staff_id);
}
