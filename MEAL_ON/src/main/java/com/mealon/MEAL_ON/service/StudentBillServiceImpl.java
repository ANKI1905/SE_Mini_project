package com.mealon.MEAL_ON.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.StudentBillDAO;
import com.mealon.MEAL_ON.model.StudentBill;
import com.mealon.MEAL_ON.model.StudentBillID;

@Service
public class StudentBillServiceImpl implements StudentBillService{
	
	@Autowired
	private StudentBillDAO studentBillDAO;
	

	@Transactional
	@Override
	public Boolean add(int mis, String month, short numMeals, int currentBill, short payStatus, int prevBill) {
		Boolean result = false;
		StudentBill newStudentBill = toStudentBill(mis, month, numMeals, currentBill, payStatus, prevBill);
		try {
			studentBillDAO.save(newStudentBill);
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	@Transactional
	@Override
	public List<StudentBill> getAllUnpaid() {
		List<StudentBill> studentUnpaidBillList= new ArrayList<StudentBill>();
		try {
			studentUnpaidBillList = studentBillDAO.findByPaystatus((short) 0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return studentUnpaidBillList;
	}
	
	
	@Transactional
	@Override
	public List<StudentBill> getAllPaid() {
		List<StudentBill> studentPaidBillList= new ArrayList<StudentBill>();
		try {
			studentPaidBillList = studentBillDAO.findByPaystatus((short) 1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return studentPaidBillList;
	}
	
	@Transactional
	@Override
	public StudentBill get(int mis, String month) {
		StudentBill studentBill = null;
		StudentBillID id = toStudentBillID(mis, month);
		try {
			Optional<StudentBill> optionalStudentBill = studentBillDAO.findById(id);
			if(optionalStudentBill.isPresent()) {
				studentBill = optionalStudentBill.get();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return studentBill;
	}
	
	@Transactional
	@Override
	public Boolean updatePayStatus(int mis, String month, short payStatus) {
		Boolean result = false;
		StudentBill studentBill = get(mis, month);
		if(studentBill != null) {
			studentBill.setPaystatus(payStatus);
			try {
				studentBillDAO.save(studentBill);
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
	public Boolean update(int mis, String month, short numMeals, int currentBill, short payStatus, int prevBill) {
		Boolean result = false;
		StudentBill studentBill = get(mis, month);
		if(studentBill != null) {
			studentBill = toStudentBill(mis, month, numMeals, currentBill, payStatus, prevBill);
			try {
				studentBillDAO.save(studentBill);
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
	public Boolean delete(int mis, String month) {
		Boolean result = false;
		StudentBill studentBill = get(mis, month);
		if(studentBill != null) {
			try {
				studentBillDAO.delete(studentBill);
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else {
			result = true;
		}
		return result;
	}
	
	
	private StudentBill toStudentBill(int mis, String month, short numMeals, int currentBill, short payStatus, int prevBill) {
		StudentBill newStudentBill = new StudentBill();
		newStudentBill.setMis(mis);
		newStudentBill.setMonth(month);
		newStudentBill.setNosofmeal(numMeals);
		newStudentBill.setCurrbill(currentBill);
		newStudentBill.setPrevbill(prevBill);
		newStudentBill.setPaystatus(payStatus);
		return newStudentBill;
	}
	
	private StudentBillID toStudentBillID(int mis, String month) {
		StudentBillID newStudentBillID = new StudentBillID();
		newStudentBillID.setMis(mis);
		newStudentBillID.setMonth(month);
		return newStudentBillID;
	}
}

