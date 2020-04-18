package com.mealon.MEAL_ON.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.MessStaffDAO;
import com.mealon.MEAL_ON.model.MessStaff;

@Service
public class MessStaffImpl implements MessStaffService{
	@Autowired
	private MessStaffDAO messStaffDAO;
	
	@Transactional
	@Override
	public Boolean add(String name, int mess_id, int account_no, int contact, String address) {
		/* Fails if same Mess name already exists in database
		 * Fails also when DAO is unable to save::: not to be informed to the customer
		 * Success if Mess name is unique
		 */
		Boolean result = false;
		MessStaff messStaff = messStaffDAO.findByNameAndMessid(name, mess_id);
		if(messStaff == null) {
			MessStaff newMessStaff = toMessStaff(name, mess_id, account_no, contact, address);
			try {
				messStaffDAO.save(newMessStaff);
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
	public List<MessStaff> getAllMessStaff(int mess_id) {
		List<MessStaff> allMessStaffList = null;
		try {
			allMessStaffList = messStaffDAO.findAllByMessid(mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allMessStaffList;
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
	public Boolean update(String name, int mess_id, int account_no, int contact, String address) {
		/* Fails if MessStaff with given name does not exists in database
		 * Success if MessStaff is updated
		 */
		Boolean result = false;
		MessStaff messStaff = get(mess_id, name);
		if(messStaff != null) {
			int staffid = messStaff.getStaffid();
			MessStaff newMessStaff = toMessStaff(name, mess_id, account_no, contact, address);
			newMessStaff.setStaffid(staffid);
			try {
				messStaffDAO.save(newMessStaff);
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
	public Boolean delete(int mess_id, String name) {
		/* 
		 * Success if messStaff with the name does not exists,
		 * Success if messStaff is deleted.
		 */
		Boolean result = false;
		MessStaff messStaff = null;
		try {
			messStaff = messStaffDAO.findByNameAndMessid(name, mess_id);
			if(messStaff != null) {
				messStaffDAO.delete(messStaff);
			}
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private MessStaff toMessStaff(String name, int mess_id, int account_no, int contact, String address) {
		MessStaff newMessStaff = new MessStaff();
		//staff_id will be auto incremented
		newMessStaff.setName(name);
		newMessStaff.setMessid(mess_id);
		newMessStaff.setAccountno(account_no);
		newMessStaff.setContact(contact);
		newMessStaff.setAddress(address);
		return newMessStaff;
	}
	
}
