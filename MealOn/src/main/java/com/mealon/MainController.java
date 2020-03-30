package com.mealon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/mess")
public class MainController {
	@Autowired
	private MessRepository messRepository;
	
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewMess(@RequestParam String Name, @RequestParam String Password, @RequestParam String Mess_Admin, @RequestParam Integer Rate) {
		Mess m = new Mess();
		m.setName(Name);
		m.setPassword(Password);
		m.setMess_Admin(Mess_Admin);
		m.setRate(Rate);
		return "Saved";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Mess> getAllMess() {
		return messRepository.findAll();
	}
}
