package com.mealon.MEAL_ON.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.model.Menu;
import com.mealon.MEAL_ON.dao.*;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;
	
	

	@Transactional
	@Override
	public void add(Integer mess_id, String name) {
		Menu newMenu = toMenu(mess_id, name);
		try {
			menuDAO.save(newMenu);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Transactional
	@Override
	public List<Menu> get(int mess_id) {
		List<Menu> allMenuList = null;
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
	public Menu get(int mess_id, int menu_id) {
		Menu menu = null;
		try {
			menu = menuDAO.findByMenuid(menu_id);
			if(menu.getMessid() != mess_id) {
				menu = null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}
	
	@Transactional
	@Override
	public void delete(int mess_id, String name) {
		Menu menu = null;
		try {
			menu = menuDAO.findByMessidAndName(mess_id, name);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(menu != null) {
			menuDAO.deleteById(menu.getMenuId());
		}
		return;
		// TODO Auto-generated method stub
		
	}
	
	private Menu toMenu(Integer mess_id, String name) {
		Menu newMenu = new Menu();
		newMenu.setMessid(mess_id);
		newMenu.setName(name);
		return newMenu;
	}
	
	/*
	 * private List<Menu> iterableToList(Iterable<Menu> iterator) { List<Menu> list
	 * = new ArrayList<>(); iterator.forEach(list::add); return list; }
	 * 
	 * private List<Menu> optionalToList(Optional<Menu> iterator) { List<Menu> list
	 * = new ArrayList<>(); iterator.ifPresent(list::add); return list; }
	 */
}
