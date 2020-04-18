package com.mealon.MEAL_ON.service;


import java.util.List;

import com.mealon.MEAL_ON.model.Student;

public interface StudentService {
	String add(int mis, String name, String room_no, short year_of_study, int contact, String email, String password, int mess_id);
	Boolean check(int mis, String password);
	//List<Student> getAllStudent(int mess_id) used only by messAdmin
	List<Student> getAllStudent(int mess_id);
	Student get(int mis);
	String update(int mis, String name, String room_no, short year_of_study, int contact, String email, String password, int mess_id);
	String delete(int mis);
	Boolean forgetPassword(Integer mis, Integer phone, String password);
	Boolean changePassword(Integer mis, String oldpass, String newpass);
}
