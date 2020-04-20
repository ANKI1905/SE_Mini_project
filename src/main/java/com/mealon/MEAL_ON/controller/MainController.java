package com.mealon.MEAL_ON.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mealon.MEAL_ON.model.Mess;
import com.mealon.MEAL_ON.service.MessService;
import com.mealon.MEAL_ON.service.StudentService;

//@CrossOrigin(origins = { "http://localhost:3000"})
@Controller
@RequestMapping("")
public class MainController {
	@Autowired
	private MessService messService;
	@Autowired
	private StudentService studentService;
	@Autowired
	
	//returns homepage
	@RequestMapping("/")
	public @ResponseBody String homePage() {
		return "This is homepage";
	}
	
	//student login
	@RequestMapping("/studentlogin")
	public String studentLogin() {
		return "studentLogin";
		//return "studentFeatures";
	}
	
	@RequestMapping("/studentauth")
	public String studentAuth(@RequestParam Integer mis, @RequestParam String Password) {
		Boolean auth = studentService.check(mis, Password);
		if (auth == true) {
			return "redirect:/students/home";
		}
		return "redirect:/studentlogin";
	}
	
	//mess admin login
	@RequestMapping("/adminlogin")
	public String adminLogin() {
		return "adminLogin";
		//return "studentFeatures";
	}
	
	// create an admin account
	@PostMapping("/admin/signin")
	public @ResponseBody String signinAdmin(@RequestParam String name, @RequestParam String password, @RequestParam String messadmin) {
		String result = messService.add(name, password, messadmin);
		return result;
	}
	
	@PostMapping("/admin/login")
	public @ResponseBody Mess logInAdmin(@RequestParam String name, @RequestParam String password) {
		Mess mess = messService.get(name, password);
		return mess;
	}
	
	@PostMapping("/admin/update")
	public @ResponseBody String updateAdmin(@RequestParam Integer mess_id, @RequestParam String name, @RequestParam String password, @RequestParam String messadmin, @RequestParam Integer rate) {
		String result = messService.update(mess_id, name, password, messadmin, rate);
		return result;
	}
	
	@PostMapping("/admin/delete")
	public @ResponseBody String deleteAdmin(@RequestParam Integer mess_id, @RequestParam String name, @RequestParam String password) {
		String result = messService.delete(mess_id, name, password);
		return result;
	}
	
	
	/*
	 * 
	 * Need to fix this
	 * 
	 * 
	 */
	/*@PostMapping("/student/login")
	public @ResponseBody Student logInStudent(@RequestParam Integer mess_id, @RequestParam String name, @RequestParam String password, @RequestParam String messadmin, @RequestParam Integer rate) {
		Student student = studentService.get(name, password);
		return student;
	}*/
	
	
	/*
	
	///Need to do Student
	
	

	
	@PostMapping("/student/update")
	public @ResponseBody String updateStudent(@RequestParam Integer mess_id, @RequestParam String name, @RequestParam String password, @RequestParam String messadmin, @RequestParam Integer rate) {
		String result = messService.add(mess_id, name, password, messadmin, rate);
		return result;
	}
	
	@PostMapping("/student/delete")
	public @ResponseBody String deleteStudent(@RequestParam Integer mess_id, @RequestParam String name, @RequestParam String password) {
		String result = messService.delete(mess_id, name, password);
		return result;
	}
	
	*/
}
