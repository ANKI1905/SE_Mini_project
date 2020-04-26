package com.mealon.MEAL_ON.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mealon.MEAL_ON.model.Mess;
import com.mealon.MEAL_ON.model.Student;
import com.mealon.MEAL_ON.service.MessService;
import com.mealon.MEAL_ON.service.StudentService;


@Controller
@RequestMapping("")
public class MainController {
	@Autowired
	private MessService messService;
	@Autowired
	private StudentService studentService;
	
	//returns homepage
	@RequestMapping("/")
	public String homePage() {
		return "homePage";
	}
	
	//student login
	@RequestMapping("/studentlogin")
	public String studentLogin() {
		return "studentLogin";
		//return "studentFeatures";
	}
	
	@RequestMapping("/studentauth")
	public String studentAuth(@RequestParam Integer mis, @RequestParam String Password) {
		return "redirect:/students/check?mis="+mis+"&password="+Password;

	}
	
	//mess admin login
	@RequestMapping("/adminlogin")
	public String adminLogin() {
		return "adminLogin";
		//return "studentFeatures";
	}
	
	@RequestMapping("/adminauth")
	public String adminAuth(@RequestParam Integer mess_id, @RequestParam String Password) {
		return "redirect:/mess/check?mess_id="+mess_id+"&password="+Password;
	}
	
	@RequestMapping ("/logout")
	public String messLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//returns admin signup page
	@PostMapping("/newadmin")
	public String newAdmin() {
		return "newAdmin";
	}

	// create an admin account
	@PostMapping("/admin/signin")
	public String signinAdmin(@RequestParam String name, @RequestParam String password, @RequestParam String messadmin, HttpSession session) {
		Integer mess_id = messService.add(name, password, messadmin);
		if (mess_id != 0) {
			session.setAttribute("mess_id", mess_id);
			session.setAttribute("messadmin", messadmin);
			return "redirect:/mess/";
		}
		session.invalidate();
		return "redirect:/";
	}
	
	/* original
	// create an admin account
	@PostMapping("/admin/signin")
	public @ResponseBody String signinAdmin(@RequestParam Integer mess_id, @RequestParam String name, @RequestParam String password, @RequestParam String messadmin, @RequestParam Integer rate) {
		String result = messService.add(mess_id, name, password, messadmin, rate);
		return result;
	}
	
	@PostMapping("/admin/login")
	public @ResponseBody Mess logInAdmin(@RequestParam Integer mess_id, @RequestParam String name, @RequestParam String password, @RequestParam String messadmin, @RequestParam Integer rate) {
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
	
	
	
	
	
	
	@PostMapping("/student/login")
	public @ResponseBody Student logInStudent(@RequestParam Integer mess_id, @RequestParam String name, @RequestParam String password, @RequestParam String messadmin, @RequestParam Integer rate) {
		Student student = studentService.get(name, password);
		return student;
	}
	original */
	
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
