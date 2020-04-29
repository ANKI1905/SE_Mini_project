package com.mealon.MEAL_ON.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.StudentAbsenteeDAO;
import com.mealon.MEAL_ON.model.Student;
import com.mealon.MEAL_ON.model.StudentAbsentee;
import com.mealon.MEAL_ON.model.StudentAbsenteeID;

@Service
public class StudentAbsenteeServiceImpl implements StudentAbsenteeService{
	
	@Autowired
	private StudentAbsenteeDAO studentAbsenteeDAO;
	
	
	
	@Transactional
	@Override
	public Boolean add(int mis, String from, String to, String type) {
		Boolean result = false;
		StudentAbsentee newStudentAbsentee = toStudentAbsentee(mis, from, to, type);
		try {
			studentAbsenteeDAO.save(newStudentAbsentee);
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Transactional
	@Override
	public Boolean update(int mis, String from, String to, String type) {
		Boolean result = false;
		StudentAbsenteeID id = toStudentAbsenteeID(mis, from, to, type);
		Optional<StudentAbsentee> studentAbsentee = studentAbsenteeDAO.findById(id);
		if(studentAbsentee.isPresent()) {
			StudentAbsentee newStudentAbsentee = toStudentAbsentee(mis, from, to, type);
			try {
				studentAbsenteeDAO.save(newStudentAbsentee);
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Transactional
	@Override
	public List<StudentAbsentee> getStudentAbsentees(int mis) {
		List<StudentAbsentee> studentAbsenteeList = null;
		try {
			studentAbsenteeList = studentAbsenteeDAO.findByMis(mis);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return studentAbsenteeList;
	}
	
	@Transactional
	@Override
	public Boolean delete(int mis) {
		Boolean result = false;
		List<StudentAbsentee> studentAbsenteeList = null;
		try {
			studentAbsenteeList = studentAbsenteeDAO.findByMis(mis);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		if(studentAbsenteeList != null) {
			for(StudentAbsentee studentAbsentee:studentAbsenteeList)
				studentAbsenteeDAO.delete(studentAbsentee);
			result = true;
		}
		return result;
	}
	
	
	
	private StudentAbsentee toStudentAbsentee(int mis, String from, String to, String type) {
		StudentAbsentee newStudentAbsentee = new StudentAbsentee();
		newStudentAbsentee.setMis(mis);
		newStudentAbsentee.setFrom(from);
		newStudentAbsentee.setTo(to);
		newStudentAbsentee.setType(type);
		return newStudentAbsentee;
	}

	private StudentAbsenteeID toStudentAbsenteeID(int mis, String from, String to, String type) {
		StudentAbsenteeID newStudentAbsenteeID = new StudentAbsenteeID();
		newStudentAbsenteeID.setMis(mis);
		newStudentAbsenteeID.setFrom(from);
		newStudentAbsenteeID.setTo(to);
		newStudentAbsenteeID.setType(type);
		return newStudentAbsenteeID;
	}
}
