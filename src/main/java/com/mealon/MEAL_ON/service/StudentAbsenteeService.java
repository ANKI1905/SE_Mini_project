package com.mealon.MEAL_ON.service;


import java.util.List;

import com.mealon.MEAL_ON.model.StudentAbsentee;

public interface StudentAbsenteeService {
	Boolean add(int mis, String from, String to, String type);
	//check if the mis lies in the same mess
	List<StudentAbsentee> getStudentAbsentees(int mis);
	Boolean update(int mis, String from, String to, String type);
	Boolean delete(int mis);
}
