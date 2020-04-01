package com.mealon.MEAL_ON.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import com.mealon.MEAL_ON.model.Menu;

@Repository
public class MenuDAOImpl implements MenuDAO {
	
	@Autowired
	private EntityManager entityManager; 
	
	@Autowired
	public String hello() {
		return "Helllllo";
	}
	
	@Override
	public List<Menu> get(int mess_id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Menu> query = currentSession.createQuery("from Menu", Menu.class);
		List<Menu> list = query.getResultList();
		System.out.println(list);
		return list;
	}

	@Override
	public Menu get(int menu_id, int mess_id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Menu> query = currentSession.createQuery("from mvenu", Menu.class);
		Menu menu = query.getSingleResult();
		return menu;
	}

	@Override
	public void add(Menu menu) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(menu);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int Menu_id, int Mess_id) {
		// TODO Auto-generated method stub
		
	}

}
