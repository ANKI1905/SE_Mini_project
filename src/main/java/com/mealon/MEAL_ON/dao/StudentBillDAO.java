package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.StudentBill;
import com.mealon.MEAL_ON.model.StudentBillID;


public interface StudentBillDAO extends CrudRepository<StudentBill, StudentBillID>{
	List<StudentBill> findByPaystatus(short payStatus);
}
