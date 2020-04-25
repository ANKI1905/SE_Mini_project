package com.mealon.MEAL_ON.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mealon.MEAL_ON.model.Student;
import com.mealon.MEAL_ON.service.StudentService;


@Controller
@RequestMapping(path = "/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping ("/check")
	public String messHome(@RequestParam Integer mis, @RequestParam String password, HttpSession session) {
		//Student s = studentService.get(mis);
		if(studentService.check(mis, password)) {
			session.setAttribute("mis", mis);
			session.setAttribute("log", "1");
			return "redirect:/students/";
		}
		session.invalidate();
		return "redirect:/studentlogin";
	}
	
	@RequestMapping ("/")
	public String studentHome(HttpSession session) {
		//Student s = studentService.get(mis);
		String l = (String) session.getAttribute("log");
		if (l == "1") {
			Integer mis = (Integer) session.getAttribute("mis");
			Student s = studentService.get(mis);
			session.setAttribute("name", s.getName());
			return "studentHome";
			
		}
		
		return "redirect:/studentlogin";
	}
	
	@PostMapping("/forgetpassword")
	public @ResponseBody String passwordRecover(@RequestParam Integer mis, @RequestParam Long phone, @RequestParam String password) {
		Boolean a =  studentService.forgetPassword(mis, phone, password);
		if (a) {
			return "password updated";
		}
		return "failed to update password";
	}
	
	/*
	 * 
	 * 
	 * need to fix this
	 * 
	 */
	/*@PostMapping("/changepassword")
	public @ResponseBody String passwordChange(@RequestParam Integer mis, @RequestParam String oldpass, @RequestParam String newpass, @RequestParam String newpass1) {
		return  studentService.changePassword(mis, oldpass, newpass, newpass1);
	}	*/
	
	
	
	
	/*
	 * Musadiq's work
	 * Need to separate this in StudentServiceImpl
        @Autowired
        private StudentDAO studentDAO;
        @PostMapping(path="/add")
        public @ResponseBody String addNewStudent(@RequestParam int MIS, @RequestParam String Name, @RequestParam String Room_no, @RequestParam short Year_of_Study, @RequestParam int Contact, @RequestParam String Email, @RequestParam String password, @RequestParam Long messid) {
                Student s = new Student();
                s.setMIS(MIS);
                s.setName(Name);
                s.setRoom_no(Room_no);
                s.setYear_of_Study(Year_of_Study);
                s.setContact(Contact);
                s.setEmail(Email);
                s.setPassword(password);
                //Long mess_id = m.getMessid(Mess_name);
                s.setMess_id(messid);
                studentDAO.save(s);
                return "saved";
        }

        @RequestMapping(path = "/view/{MIS}")
        public @ResponseBody String showStudent(@PathVariable("MIS")int MIS) {
                Student s = new Student();
                s = studentDAO.findByMis(MIS);
                if (s == null) {
                        return "No Records Found with MIS : " + MIS;
                }
                return s.toString();
        }
        
    */
}
