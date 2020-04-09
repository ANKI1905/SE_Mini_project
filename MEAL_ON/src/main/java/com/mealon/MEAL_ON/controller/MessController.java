package com.mealon.MEAL_ON.controller;
import java.util.List;
import com.mealon.MEAL_ON.model.*;
import com.mealon.MEAL_ON.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mess")
public class MessController {
	@Autowired
	private MenuService menuService;
	
	//Only getMenu works till now, Problem in addMenu....go to MenuServiceImpl
	@RequestMapping("/menu")
	public @ResponseBody List<Menu> get(@RequestParam int mess_id){
		return menuService.get(mess_id);
	}
	
	@RequestMapping("/menu/show")
	public @ResponseBody Menu get(@RequestParam int mess_id, @RequestParam int menu_id){
		return menuService.get(mess_id, menu_id);
	}
	
	
	@PostMapping("/menu/add")
	public @ResponseBody String getMenu(@RequestParam Integer mess_id, @RequestParam String name) {
		//return menuService.get(2, 1);
		menuService.add(mess_id, name);
		return "saved";
	}
	
	
	@PostMapping("/menu/delete")
	public @ResponseBody String delMenu(@RequestParam Integer mess_id, @RequestParam String name) {
		menuService.delete(mess_id, name);
		return "saved";
	}
	
	//Manage menu
	//Manage student
	//Manage  mess staff
	//Mnage asnacksmenu
	//Manage inventory
	//Add daily menu
	//review feedback

}
