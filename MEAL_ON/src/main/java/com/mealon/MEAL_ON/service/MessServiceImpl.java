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
	public Integer add(String name, String password, String messadmin) {
		/* Fails if same Mess name already exists in database
		 * Fails also when DAO is unable to save::: not to be informed to the customer
		 * Success if Mess name is unique
		 */
		Integer result = 0;
		Mess mess = messDAO.findByName(name);
		if(mess == null) {
			Mess newMess = toMess(name, password, messadmin, 0);
			try {
				messDAO.save(newMess);
				result = newMess.getMessid();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Transactional
	@Override
	public Boolean check(Integer mess_id , String password) {
		/* Fails if password of mess does not match with the saved password
		 * Success if password matches
		 */
		Boolean result = false;
		try {
			Mess mess = messDAO.findByMessid(mess_id);
			String pass = mess.getPassword();
			System.out.println(mess.getName());
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
	public Mess get(Integer mess_id) {
		Mess mess = null;
		try {
			mess = messDAO.findByMessid(mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return mess;
	}
	@Transactional
	@Override
	public Boolean update(Integer mess_id, String name, String messadmin, Integer rate) {
		/* Fails if Mess with given name does not exists in database
		 * Success if Mess is updated
		 */
		Boolean result = false;
		Mess mess = get(mess_id);
		if(mess != null) {
			Mess newMess = toMess(name, mess.getPassword(), messadmin, rate);
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
	public Boolean changePassword(Integer mess_id, String oldpass, String newpass) {
		Boolean result = false;
		Mess mess= messDAO.findByMessid(mess_id);
		System.out.print(mess.getPassword()  +  oldpass + mess.getPassword().equals(oldpass));
		if (mess != null && mess.getPassword().equals(oldpass)) {
			mess.setPassword(newpass);
			try {
				messDAO.save(mess);
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print(result);
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