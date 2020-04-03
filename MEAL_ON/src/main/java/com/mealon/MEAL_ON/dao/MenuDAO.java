package com.mealon.MEAL_ON.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.Menu;

public interface MenuDAO extends CrudRepository<Menu, Integer>, MenuDAOCustom{

}