package com.mealon.MEAL_ON.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mealon.MEAL_ON.model.SnacksToken;
import com.mealon.MEAL_ON.model.SnacksTokenID;


public interface SnacksTokenDAO extends CrudRepository<SnacksToken, SnacksTokenID>{
	List<SnacksToken> findByMis(int mis);
}
