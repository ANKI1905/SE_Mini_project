package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.Menu;


public interface MenuDAO extends CrudRepository<Menu, Integer>{

	List<Menu> findByMessid(int mess_id);
	Menu findByMenuid(int menu_id);
	Menu findByMessidAndName(int mess_id, String name);
	//void deleteByName(int mess_id, String name);

}