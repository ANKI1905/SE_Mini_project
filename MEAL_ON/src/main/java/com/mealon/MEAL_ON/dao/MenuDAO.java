package com.mealon.MEAL_ON.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.menu;


public interface MenuDAO extends CrudRepository<menu, Integer>{

	List<menu> findByMessid(int mess_id);

}