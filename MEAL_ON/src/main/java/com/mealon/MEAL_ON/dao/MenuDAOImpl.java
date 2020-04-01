package com.mealon.MEAL_ON.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mealon.MEAL_ON.model.Menu;

@Repository
public class MenuDAOImpl implements MenuDAO {
	
	@Autowired
	private EntityManager entityManager; 
	
	@Override
	public List<Menu> get(int Mess_id) {
		Session currenSession = entityManager.unwrap(Session.class) ;
	}

	@Override
	public Menu get(int Menu_id, int Mess_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int Menu_id, int Mess_id) {
		// TODO Auto-generated method stub
		
	}

}
