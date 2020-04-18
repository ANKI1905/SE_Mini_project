package com.mealon.MEAL_ON.dao;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.StaffSalary;
import com.mealon.MEAL_ON.model.StaffSalaryID;


public interface StaffSalaryDAO extends CrudRepository<StaffSalary, StaffSalaryID>{

}
