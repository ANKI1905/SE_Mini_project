package com.mealon.MEAL_ON.controller;
import java.util.List;
import com.mealon.MEAL_ON.model.*;
import com.mealon.MEAL_ON.service.MenuService;
import com.mealon.MEAL_ON.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mess")
public class MessController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuDAO menuDao;
	
	@RequestMapping("/tp")
	public String hello() {
		return menuDao.hello();
	}
	
	
	@RequestMapping("/menu/list")
	public List<Menu> get(){
		//return menuService.get(1);
		return menuDao.get(1);
	}
	
	@RequestMapping("/menu/item")
	public Menu getMenu() {
		return menuService.get(2, 1);
	}
	
	@PostMapping("/menu/add")
	public Menu add(@RequestBody Menu menuobj) {
		menuService.add(menuobj);
		return menuobj;
	}
	
	//Manage menu
	//Manage student
	//Manage  mess staff
	//Mnage asnacksmenu
	//Manage inventory
	//Add daily menu
	//review feedback

}
