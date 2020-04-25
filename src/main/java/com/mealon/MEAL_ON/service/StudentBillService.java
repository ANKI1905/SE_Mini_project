package com.mealon.MEAL_ON.service;


import java.util.List;

import com.mealon.MEAL_ON.model.StudentBill;

public interface StudentBillService {
	Boolean add(int mis, String month, short numMeals, int currentBill, short payStatus, int prevBill);
	//List<StudentBill> getAllStudent(int mess_id) used only by messAdmin
	List<StudentBill> getAllUnpaid();
	List<StudentBill> getAllPaid();
	StudentBill get(int mis, String month);
	Boolean updatePayStatus(int mis, String month, short payStatus);
	Boolean update(int mis, String month, short numMeals, int currentBill, short payStatus, int prevBill);
	Boolean delete(int mis, String month);
}
