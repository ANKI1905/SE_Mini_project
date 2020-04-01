package com.mealon.MEAL_ON.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.model.Menu;

@Service
public class MenuServiceImpl implements MenuService {

	@Transactional
	@Override
	public List<Menu> get(int Mess_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Menu get(int Menu_id, int Mess_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void add(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(int Menu_id, int Mess_id) {
		// TODO Auto-generated method stub
		
	}

}
