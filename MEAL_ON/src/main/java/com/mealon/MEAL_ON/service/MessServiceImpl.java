package com.mealon.MEAL_ON.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.MessDAO;
import com.mealon.MEAL_ON.model.Mess;
import com.mealon.MEAL_ON.model.Student;

@Service
public class MessServiceImpl implements MessService{
	@Autowired
	private MessDAO messDAO;
	
	@Transactional
	@Override
	public Boolean add(String name, String password, String messadmin) {
		/* Fails if same Mess name already exists in database
		 * Fails also when DAO is unable to save::: not to be informed to the customer
		 * Success if Mess name is unique
		 */
		Boolean result = false;
		Mess mess = messDAO.findByName(name);
		if(mess != null) {
			Mess newMess = toMess(name, password, messadmin, 0);
			try {
				messDAO.save(newMess);
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
	public Boolean check(String name, String password) {
		/* Fails if password of mess does not match with the saved password
		 * Success if password matches
		 */
		Boolean result = false;
		try {
			Mess mess = messDAO.findByName(name);
			String pass = mess.getPassword();
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
	public Mess get(String name) {
		Mess mess = null;
		try {
			mess = messDAO.findByName(name);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return mess;
	}
	@Transactional
	@Override
	public Boolean update(Integer mess_id, String name, String password, String messadmin, Integer rate) {
		/* Fails if Mess with given name does not exists in database
		 * Success if Mess is updated
		 */
		Boolean result = false;
		Mess mess = get(name);
		if(mess != null) {
			Mess newMess = toMess(name, password, messadmin, rate);
			newMess.setMessid(mess_id);
			try {
				messDAO.save(newMess);
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
	public Boolean delete(int mess_id, String name, String password) {
		/* Fails if password does not match,
		 * Fails if name does not match.
		 * Success if mess with the name does not exists,
		 * Success if mess is deleted.
		 */
		Boolean result = false;
		Mess mess = null;
		try {
			Optional<Mess> optional = messDAO.findById(mess_id);
			if(optional.isPresent()) {
				mess = (Mess) optionalToList(optional);
				String Password = mess.getPassword();
				String Name = mess.getName();
				if(Password.equals(password) && Name.equals(name)) {
					messDAO.deleteById(mess_id);
					result = true;
				}
			}
			else {
				result = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private Mess toMess(String name, String password, String messadmin, Integer rate) {
		Mess newMess = new Mess();
		//mess_id will be auto incremented
		//newMess.setMessid(mess_id);
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
