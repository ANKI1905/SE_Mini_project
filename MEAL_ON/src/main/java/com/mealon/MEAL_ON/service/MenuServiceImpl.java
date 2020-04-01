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
	public List<Menu> get(int Mess_id) {
		// TODO Auto-generated method stub
		return menuDAO.get(1);
		
	}

	@Transactional
	@Override
	public Menu get(int menu_id, int mess_id) {
		// TODO Auto-generated method stub
		return menuDAO.get(menu_id, mess_id);
	}

	@Transactional
	@Override
	public void add(Menu menu) {
		menuDAO.add(menu);
		
	}

	@Transactional
	@Override
	public void delete(int Menu_id, int Mess_id) {
		// TODO Auto-generated method stub
		
	}

}
