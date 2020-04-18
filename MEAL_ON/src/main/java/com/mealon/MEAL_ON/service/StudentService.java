package com.mealon.MEAL_ON.service;


import com.mealon.MEAL_ON.model.Student;

public interface StudentService {
	String add(int mis, String name, String room_no, short year_of_study, int contact, String email, String password, int mess_id);
	Student check(int mis, String password);
	Student get(int mis);
	String update(int mis, String name, String room_no, short year_of_study, int contact, String email, String password, int mess_id);
	String delete(int mis);
	Boolean forgetPassword(Integer mis, Integer phone, String password);
	Boolean changePassword(Integer mis, String oldpass, String newpass);
}
