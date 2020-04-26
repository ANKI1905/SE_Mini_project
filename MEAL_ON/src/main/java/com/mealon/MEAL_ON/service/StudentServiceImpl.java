package com.mealon.MEAL_ON.service;


import java.util.List;

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
	public Boolean check(int mis, String password) {
		Boolean result = false;
		try {
			Student student = studentDAO.findByMis(mis);
			String pass = student.getPassword();
			if(pass.equals(password)) {
				result = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Transactional
	@Override
	public Student get(int mis) {
		Student student = null;
		try {
			student = studentDAO.findByMis(mis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	@Transactional
	@Override
	public List<Student> getAllStudent(int mess_id) {
		List<Student> student = null;
		try {
			student = studentDAO.findByMessid(mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	@Transactional
	@Override
	public String add(int mis, String name, String room_no, short year_of_study, Long contact, String email, String password, int mess_id) {
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
	public String update(int mis, String name, String room_no, short year_of_study, Long contact, String email, String password, int mess_id) {
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
	
	@Transactional
	@Override
	public Boolean forgetPassword(Integer mis, Long phone, String password) {
		Student s = studentDAO.findByMis(mis);
		if (s.getContact() == phone) {
			s.setPassword(password);
			studentDAO.save(s);
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public Boolean changePassword(Integer mis, String oldpass, String newpass) {
		Boolean result = false;
		Student s = studentDAO.findByMis(mis);
		if (s.getPassword() == oldpass) {
			s.setPassword(newpass);
			studentDAO.save(s);
			result = true;
		}
		return result;
	}
	
	
	private Student toStudent(int mis, String name, String room_no, short year_of_study, Long contact, String email, String password, int mess_id) {
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
