package com.mealon.MEAL_ON.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mealon.MEAL_ON.model.Student;

@Controller
@RequestMapping(path = "/students")
public class StudentController {

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
                s = studentDAO.findByMIS(MIS);
                if (s == null) {
                        return "No Records Found with MIS : " + MIS;
                }
                return s.toString();
        }
}
