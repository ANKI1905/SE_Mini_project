package com.mealon.MEAL_ON.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.SnacksMenuDAO;
import com.mealon.MEAL_ON.model.SnacksMenu;

@Service
public class SnacksMenuServiceImpl implements SnacksMenuService {

	@Autowired
	private SnacksMenuDAO snacksMenuDAO;	

	@Transactional
	@Override
	public Boolean add(String name, int price, int mess_id) {
		Boolean result = false;
		SnacksMenu newSnacksMenu = toSnacksMenu(name, price, mess_id);
		try {
			snacksMenuDAO.save(newSnacksMenu);
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	@Transactional
	@Override
	public List<SnacksMenu> get(int mess_id) {
		List<SnacksMenu> allMenuList = null;
		try {
			allMenuList = snacksMenuDAO.findByMessid(mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allMenuList;
	}

	@Transactional
	@Override
	public Boolean updated(int snacks_id, String name, int price, int mess_id) {
		Boolean result = false;
		Optional<SnacksMenu> snacksMenu = snacksMenuDAO.findById(snacks_id);
		if(snacksMenu.isPresent()) {
			SnacksMenu newSnacksMenu = toSnacksMenu(name, price, mess_id);
			newSnacksMenu.setSnacksid(snacks_id);
			try {
				snacksMenuDAO.save(newSnacksMenu);
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
	public SnacksMenu get(int mess_id, String name) {
		SnacksMenu snacksMenu = null;
		try {
			snacksMenu = snacksMenuDAO.findByName(name);
			if(snacksMenu != null && snacksMenu.getMessid() == mess_id) {
				snacksMenuDAO.save(snacksMenu);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return snacksMenu;
	}
	
	@Transactional
	@Override
	public Boolean delete(int mess_id, String name) {
		Boolean result = false;
		try {
			SnacksMenu snacksMenu = snacksMenuDAO.findByName(name);
			if(snacksMenu != null && snacksMenu.getMessid() == mess_id) {
				snacksMenuDAO.delete(snacksMenu);
				result = true;
			}
			else if(snacksMenu == null) {
				result = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private SnacksMenu toSnacksMenu(String name, int price, int mess_id) {
		SnacksMenu newSnacksMenu = new SnacksMenu();
		newSnacksMenu.setName(name);
		newSnacksMenu.setPrice(price);
		newSnacksMenu.setMessid(mess_id);
		return newSnacksMenu;
	}
}
