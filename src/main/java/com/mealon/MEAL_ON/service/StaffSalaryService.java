package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.StaffSalary;


public interface StaffSalaryService {
	//Used only when MessAdmin is logged in
	
	//call add() immediately when messStaff is created.. set month to current month, rest to 0 if required
	Boolean add(int staff_id, int num_leaves, String month, int salary);
	List<StaffSalary> getAllMonthStatus(int staff_id);
	//Obtain List<Integer> from MessStaffService for particular mess_id
	List<StaffSalary> getAllStaffSalaryStatus(List<Integer> staffIdsList);
	//Calculate new Salary according to Increasing leaves of that month
	Boolean update(int staff_id, int num_leaves, String month, int salary);
	Boolean delete(int staff_id, String month);
}
