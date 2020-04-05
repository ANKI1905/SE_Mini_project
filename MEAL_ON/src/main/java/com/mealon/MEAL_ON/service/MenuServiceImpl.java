package com.mealon.MEAL_ON.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.model.menu;
import com.mealon.MEAL_ON.dao.*;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;
	
	

	@Transactional
	@Override
	public void addMenu(Integer mess_id, String name) {
		menu newMenu = new menu();
		newMenu.setMessid(mess_id);
		newMenu.setName(name);
		menuDAO.save(newMenu);
		//problem in this method, menu_id should be auto increment
	}

	
	@Transactional
	@Override
	public List<menu> getMenu(int mess_id) {
		List<menu> allMenuList = null;
		try {
			allMenuList = menuDAO.findByMessid(mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allMenuList;
	}


	@Transactional
	@Override
	public void updateMenu(Integer mess_id, String name) {
		menu newMenu = new menu();
		newMenu.setMessid(mess_id);
		newMenu.setName(name);
		menuDAO.save(newMenu);
		//problem in this method, menu_id should be auto increment
	}
	
	
	@Transactional
	@Override
	public void deleteMenu(int menu_id, int mess_id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	private List<menu> iterableToList(Iterable<menu> iterator) {
		List<menu> list = new ArrayList<>();
		iterator.forEach(list::add);
		return list;
	}
	
	private List<menu> optionalToList(Optional<menu> iterator) {
		List<menu> list = new ArrayList<>();
		iterator.ifPresent(list::add);
		return list;
	}
}
