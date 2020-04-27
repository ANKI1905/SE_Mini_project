package com.mealon.MEAL_ON.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.mealon.MEAL_ON.model.Student;
import com.mealon.MEAL_ON.service.StudentService;


@Controller
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping ("/check")
	public String studentCheck(@RequestParam Integer mis, @RequestParam String password, HttpSession session) {
		//Student s = studentService.get(mis);
		
		if(studentService.check(mis, password)) {
			session.setAttribute("mis", mis);
			session.setAttribute("log", "1");
			return "redirect:/students/";
		}
		//session.invalidate();
		session.setAttribute("message", "Enter correct MIS or Password");
		return "redirect:/studentlogin";
	}
	
	@RequestMapping ("/")
	public String studentHome(HttpSession session) {
		//Student s = studentService.get(mis);
		String l = (String) session.getAttribute("log");
		
		if (l == null) {
			return "redirect:/studentlogin";
		}
		else if(l == "1") {
			session.removeAttribute("status");
		}
		Integer mis = (Integer) session.getAttribute("mis");
		Student s = studentService.get(mis);
		session.setAttribute("name", s.getName());
		session.setAttribute("log", "1");
		return "studentHome";
			
	}
	/*
	@RequestMapping ("/logout")
	public String studentLogout(HttpSession session) {
		//Student s = studentService.get(mis);
		

		session.removeAttribute("mis");
		session.removeAttribute("log");
		session.invalidate();
		return "redirect:/studentlogin";
	}
	*/
	
	@PostMapping("/forgetPassword")
	public @ResponseBody String passwordRecover(@RequestParam Integer mis, @RequestParam Long phone, @RequestParam String password) {
		Boolean a =  studentService.forgetPassword(mis, phone, password);
		if (a) {
			return "password updated";
		}
		return "failed to update password";
	}
	
	@RequestMapping(value = "/passwordChangeUpdate", method = RequestMethod.POST)
	public @ResponseBody RedirectView passwordChange(@RequestParam String oldpass, @RequestParam String newpass, @RequestParam String newpass1, HttpSession session) {
		int mis = (int) session.getAttribute("mis");
		session.removeAttribute("status");
		if(newpass.equals(newpass1)) {
			Boolean result = studentService.changePassword(mis, oldpass, newpass);
			if(result) {
				session.setAttribute("status", "Successful");
			}
			else {
				session.setAttribute("status", "Failed to change the password");
			}
		}
		else {
			session.setAttribute("status", "Please enter similar passwords!");
			RedirectView redirectView = new RedirectView();
		    redirectView.setUrl("/students/changePassword");
			return redirectView;
		}
		session.setAttribute("log", "2");
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("/students/?session="+session);
		return redirectView;
	
	}
	
	@RequestMapping("/changePassword")
	public String changePasswordPage(HttpSession session) {
		return "studentChangePassword";
	}
	
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
