package com.mealon.MEAL_ON.controller;
import java.util.List;
import com.mealon.MEAL_ON.model.*;
import com.mealon.MEAL_ON.service.InventoryService;
import com.mealon.MEAL_ON.service.MenuService;
import com.mealon.MEAL_ON.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mess")
public class MessController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private StudentService studentService;
	
	/*
	 * Menu
	 * 
	 */
	@RequestMapping("/menu")
	public @ResponseBody List<Menu> getMenu(@RequestParam int mess_id){
		return menuService.get(mess_id);
	}
	
	@RequestMapping("/menu/show")
	public @ResponseBody Menu getMenu(@RequestParam int mess_id, @RequestParam int menu_id){
		return menuService.get(mess_id, menu_id);
	}
	
	@PostMapping("/menu/add")
	public @ResponseBody String addMenu(@RequestParam Integer mess_id, @RequestParam String name) {
		menuService.add(mess_id, name);
		return "saved";
	}
	
	@PostMapping("/menu/delete")
	public @ResponseBody String delMenu(@RequestParam Integer mess_id, @RequestParam String name) {
		menuService.delete(mess_id, name);
		return "saved";
	}
	
	
	
	
	
	/*
	 * Inventory
	 * 
	 */
	
	@RequestMapping("/inventory")
	public @ResponseBody List<Inventory> getInventory(@RequestParam int mess_id){
		return inventoryService.get(mess_id);
	}
	
	@RequestMapping("/inventory/{name}")
	public @ResponseBody Inventory getInventory(@RequestParam int mess_id, @PathVariable("name") String name){
		return inventoryService.getInfo(mess_id, name);
	}
	
	@PostMapping("/inventory/add")
	public @ResponseBody String addInventory(@RequestParam Integer id, @RequestParam String name, @RequestParam int stock, @RequestParam int avg_price, @RequestParam int mess_id) {
		return inventoryService.add(id, name, stock, avg_price, mess_id);
	}
	
	@PostMapping("/inventory/{name}/update")
	public @ResponseBody String updateInventory(@RequestParam Integer inventoryid, @PathVariable("name") String name, @RequestParam int stock, @RequestParam int avg_price, @RequestParam int mess_id) {
		return inventoryService.update(inventoryid, name, stock, avg_price, mess_id);
	}
	
	@PostMapping("/inventory/{name}/updateStock")
	public @ResponseBody String updateInventoryStock(@PathVariable("name") String name, @RequestParam int stock, @RequestParam int mess_id) {
		return inventoryService.updateStock(name, stock, mess_id);
	}
	
	
	/*
	 * Student
	 * 
	 */
	
	
	@PostMapping("/student/signin")
	public @ResponseBody String signinStudent(@RequestParam Integer mis, @RequestParam String name, @RequestParam String room_no, @RequestParam short year_of_study, @RequestParam Integer contact, @RequestParam String email, @RequestParam String password, @RequestParam Integer mess_id) {
		return studentService.add(mis, name, room_no, year_of_study, contact, email, password, mess_id);
	}
	
	
	///Update and delete design it accrdingly (as per requirement) later
	
	@PostMapping("/student/update")
	public @ResponseBody String updateStudent(@RequestParam Integer mis, @RequestParam String name, @RequestParam String room_no, @RequestParam short year_of_study, @RequestParam Integer contact, @RequestParam String email, @RequestParam String password, @RequestParam Integer mess_id) {
		return studentService.update(mis, name, room_no, year_of_study, contact, email, password, mess_id);
	}
	
	@PostMapping("/student/delete")
	public @ResponseBody String deleteStudent(@RequestParam Integer mis, @RequestParam String name, @RequestParam String room_no, @RequestParam short year_of_study, @RequestParam Integer contact, @RequestParam String email, @RequestParam String password, @RequestParam Integer mess_id) {
		return studentService.delete();
	}
	
	//Manage menu
	//Manage student
	//Manage  mess staff
	//Mnage asnacksmenu
	//Manage inventory
	//Add daily menu
	//review feedback

}
