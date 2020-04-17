package com.mealon.MEAL_ON.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.MessDAO;
import com.mealon.MEAL_ON.model.Mess;

@Service
public class MessServiceImpl implements MessService{
	@Autowired
	private MessDAO messDAO;
	
	@Transactional
	@Override
	public String add(Integer mess_id, String name, String password, String messadmin, Integer rate) {
		String result = null;
		Mess newMess = toMess(mess_id, name, password, messadmin, rate);
		try {
			messDAO.save(newMess);
			result = "Added successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Transactional
	@Override
	public List<Mess> get() {
		List<Mess> allMessList = null;
		try {
			Iterable<Mess> iterator= messDAO.findAll();
			allMessList = iterableToList(iterator);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allMessList;
	}
	
	@Transactional
	@Override
	public Mess get(String name, String password) {
		Mess mess = null;
		try {
			mess = messDAO.findByName(name);
			String pass = mess.getPassword();
			if(!pass.equals(password)) {
				mess = null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return mess;
	}
	@Transactional
	@Override
	public String update(Integer mess_id, String name, String password, String messadmin, Integer rate) {
		Mess newMess = toMess(mess_id, name, password, messadmin, rate);
		String result = null;
		try {
			messDAO.save(newMess);
			result = "Successfully updated";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Transactional
	@Override
	public String delete(int mess_id, String name, String password) {
		Mess mess = null;
		String result = "Does not exists";
		try {
			Optional<Mess> optional = messDAO.findById(mess_id);
			mess = (Mess) optionalToList(optional);
			String Password = mess.getPassword();
			String Name = mess.getName();
			if(Password.equals(password) && Name.equals(name)) {
				messDAO.deleteById(mess_id);
				result = "Deleted successfuly";
			}
			else {
				result = "Invalid name or password";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private Mess toMess(Integer mess_id, String name, String password, String messadmin, Integer rate) {
		Mess newMess = new Mess();
		newMess.setMessid(mess_id);
		newMess.setName(name);
		newMess.setPassword(password);
		newMess.setMessadmin(messadmin);
		newMess.setRate(rate);
		return newMess;
	}
	
	private List<Mess> iterableToList(Iterable<Mess> iterator) { 
		List<Mess> list = new ArrayList<>(); 
		iterator.forEach(list::add); 
		 return list; 
	}
	
	private List<Mess> optionalToList(Optional<Mess> optional) {
		List<Mess> list = new ArrayList<>(); 
		optional.ifPresent(list::add); 
		return list; 
	}
}
