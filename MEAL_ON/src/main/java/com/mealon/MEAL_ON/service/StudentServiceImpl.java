package com.mealon.MEAL_ON.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.StudentDAO;
import com.mealon.MEAL_ON.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Transactional
	@Override
	public Student check(int mis, String password) {
		Student student = null;
		try {
			student = studentDAO.findByMis(mis);
			String pass = student.getPassword();
			if(!pass.equals(password)) {
				student = null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	@Transactional
	@Override
	public String add(int mis, String name, String room_no, short year_of_study, int contact, String email, String password, int mess_id) {
		String result = null;
		Student newStudent = toStudent(mis, name, room_no, year_of_study, contact, email, password, mess_id);
		try {
			studentDAO.save(newStudent);
			result = "Added successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Transactional
	@Override
	public String update(int mis, String name, String room_no, short year_of_study, int contact, String email, String password, int mess_id) {
		String result = null;
		Student newStudent = toStudent(mis, name, room_no, year_of_study, contact, email, password, mess_id);
		try {
			studentDAO.save(newStudent);
			result = "Updated successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Transactional
	@Override
	public String delete(int mis) {
		String result = null;
		Student student = studentDAO.findByMis(mis);
		if(student != null) {
			studentDAO.delete(student);
			result = "Deleted Successfully";
		}
		return result;
	}
	
	@Override
	public Boolean forgetPassword(Integer mis, Integer phone, String password) {
		Student s = studentDAO.findByMis(mis);
		if (s.getContact() == phone) {
			s.setPassword(password);
			studentDAO.save(s);
			return true;
		}
		return false;
	}
	
	
	private Student toStudent(int mis, String name, String room_no, short year_of_study, int contact, String email, String password, int mess_id) {
		Student newStudent = new Student();
		newStudent.setMis(mis);
		newStudent.setName(name);
		newStudent.setRoomno(room_no);
		newStudent.setYearofstudy(year_of_study);
		newStudent.setContact(contact);
		newStudent.setEmail(email);
		newStudent.setPassword(password);
		newStudent.setMessid(mess_id);
		return newStudent;
	}
}
