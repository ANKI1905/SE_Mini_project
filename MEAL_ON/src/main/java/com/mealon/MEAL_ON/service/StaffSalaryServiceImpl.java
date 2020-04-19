package com.mealon.MEAL_ON.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.MessStaffDAO;
import com.mealon.MEAL_ON.dao.StaffSalaryDAO;
import com.mealon.MEAL_ON.model.MessStaff;
import com.mealon.MEAL_ON.model.StaffSalary;
import com.mealon.MEAL_ON.model.StaffSalaryID;

@Service
public class StaffSalaryServiceImpl implements StaffSalaryService{
	@Autowired
	private StaffSalaryDAO staffSalaryDAO;
	
	@Transactional
	@Override
	public Boolean add(int staff_id, int num_leaves, String month, int salary) {
		Boolean result = false;
		StaffSalary newStaffSalary = toStaffSalary(staff_id, num_leaves, month, salary);
		try {
			staffSalaryDAO.save(newStaffSalary);
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Transactional
	@Override
	public List<StaffSalary> getAllMonthStatus(int staff_id) {
		 List<StaffSalary> staffSalaryList = new ArrayList<StaffSalary>();
		try {
			staffSalaryList = staffSalaryDAO.findByStaffid(staff_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return staffSalaryList;
	}
	
	@Transactional
	@Override
	public List<StaffSalary> getAllStaffSalaryStatus(List<Integer> staffIdsList) {
		 List<StaffSalary> allStaffSalaryList = new ArrayList<StaffSalary>();
		 List<StaffSalary> staffSalaryList = new ArrayList<StaffSalary>();

		try {
			for(Integer staff_id:staffIdsList) {
				staffSalaryList = getAllMonthStatus(staff_id);
				for(StaffSalary staffSalary:staffSalaryList)
					allStaffSalaryList.add(staffSalary);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return staffSalaryList;
	}
	
	
	@Transactional
	@Override
	public MessStaff get(int mess_id, String name) {
		MessStaff messStaff = null;
		try {
			messStaff = messStaffDAO.findByNameAndMessid(name, mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return messStaff;
	}
	
	@Transactional
	@Override
	public Boolean update(int staff_id, int num_leaves, String month, int salary) {
		Boolean result = false;
		StaffSalaryID id = toStaffSalaryID(staff_id, month);
		Optional<StaffSalary> optinalStaffSalary = staffSalaryDAO.findById(id);
		if(optinalStaffSalary.isPresent()) {
			StaffSalary staffSalary = optinalStaffSalary.get();
			if(staffSalary.getStaffid() == staff_id && staffSalary.getMonth() == month) {
				StaffSalary newStaffSalary = toStaffSalary(staff_id, num_leaves, month, salary);
				try {
					staffSalaryDAO.save(newStaffSalary);
					result = true;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	@Transactional
	@Override
	public Boolean delete(int staff_id, String month) {
		/* 
		 * Success if staffSalary with the staff_id, month does not exists,
		 * Success if staffSalary is deleted.
		 * Fails if staffSalary with the staff_id, month does exists but could not delete
		 */
		Boolean result = false;
		StaffSalaryID id = toStaffSalaryID(staff_id, month);
		try {
			Optional<StaffSalary> optionalStaffSalary = staffSalaryDAO.findById(id);
			if(optionalStaffSalary.isPresent()) {
				StaffSalary staffSalary = optionalStaffSalary.get();
				staffSalaryDAO.delete(staffSalary);
			}
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private StaffSalary toStaffSalary(int staff_id, int num_leaves, String month, int salary) {
		StaffSalary newStaffSalary = new StaffSalary();
		//staff_id will be auto incremented
		newStaffSalary.setStaffid(staff_id);
		newStaffSalary.setNosofleaves(num_leaves);
		newStaffSalary.setMonth(month);
		newStaffSalary.setSalary(salary);
		return newStaffSalary;
	}
	
	private StaffSalaryID toStaffSalaryID(int staff_id, String month) {
		StaffSalaryID id = new StaffSalaryID();
		id.setMonth(month);
		id.setStaffid(staff_id);
		return id;
	}
}
