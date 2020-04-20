package com.mealon.MEAL_ON.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mealon.MEAL_ON.service.StudentService;


@Controller
@RequestMapping(path = "/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping ("/home")
	public @ResponseBody String studentHome() {
		//Student s = studentService.get(mis);
		return "Hey Student";
	}
	
	@PostMapping("/forgetpassword")
	public @ResponseBody String passwordRecover(@RequestParam Integer mis, @RequestParam Integer phone, @RequestParam String password) {
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
