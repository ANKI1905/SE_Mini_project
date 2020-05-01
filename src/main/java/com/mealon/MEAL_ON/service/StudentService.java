package com.mealon.MEAL_ON.service;


import java.util.List;

import com.mealon.MEAL_ON.model.Student;

public interface StudentService {
	Boolean add(int mis, String name, String room_no, short year_of_study, Long contact, String email, String password, int mess_id);
	Boolean check(int mis, String password);
	//List<Student> getAllStudent(int mess_id) used only by messAdmin
	List<Student> getAllStudents(Integer mess_id);
	Student get(int mis);
	int getMessid(int mis);
	String update(int mis, String name, String room_no, short year_of_study, Long contact, String email, String password, int mess_id);
	String delete(int mis);
	Boolean forgetPassword(Integer mis, Long phone, String password);
	Boolean changePassword(Integer mis, String oldpass, String newpass);
}