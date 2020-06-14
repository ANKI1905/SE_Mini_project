package com.mealon.MEAL_ON.controller;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import com.mealon.MEAL_ON.model.*;
import com.mealon.MEAL_ON.service.InventoryService;
import com.mealon.MEAL_ON.service.MenuReviewService;
import com.mealon.MEAL_ON.service.MenuService;
import com.mealon.MEAL_ON.service.MessService;
import com.mealon.MEAL_ON.service.MessStaffService;
import com.mealon.MEAL_ON.service.StaffSalaryService;
import com.mealon.MEAL_ON.service.StudentBillService;
import com.mealon.MEAL_ON.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/mess")
public class MessController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuReviewService menuReviewService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private MessService messService;
	@Autowired
	private MessStaffService messStaffService;
	@Autowired
	private StaffSalaryService staffSalaryService;
	@Autowired
	private StudentBillService studentBillService;
	/*
	 * Mess
	 * 
	 */
	
	@PostMapping("/add")
	public @ResponseBody String messAdd(@RequestParam String name, @RequestParam String password, @RequestParam String messadmin) {
		return "" + messService.add(name, password, messadmin);
		
	}
	
	@RequestMapping ("/check")
	public String messHome(@RequestParam Integer mess_id, @RequestParam String password, HttpSession session) {
		//Student s = studentService.get(mis);
		if(messService.check(mess_id, password)) {
			session.setAttribute("mess_id", mess_id);
			session.setAttribute("log", "1");
			return "redirect:/mess/";
		}
		session.invalidate();
		return "redirect:/adminlogin";
	}
	
	@RequestMapping ("/")
	public String messHome(HttpSession session) {
		String l = (String) session.getAttribute("log");
		if (l == null) {
			return "redirect:/adminlogin";
		}
		Integer mess_id = (Integer) session.getAttribute("mess_id");
		Mess m = messService.get(mess_id);
		session.setAttribute("admin", m.getMessadmin());
		session.removeAttribute("status");
		return "messHome";
	}
	

	@RequestMapping(value = "/passwordChangeUpdate", method = RequestMethod.POST)
	public @ResponseBody RedirectView passwordChange(@RequestParam String oldpass, @RequestParam String newpass, @RequestParam String newpass1, HttpSession session) {
		int mess_id = (int) session.getAttribute("mess_id");
		session.removeAttribute("status");
		if(newpass.equals(newpass1)) {
			Boolean result = messService.changePassword(mess_id, oldpass, newpass);
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
		    redirectView.setUrl("/mess/changePassword");
			return redirectView;
		}
		session.setAttribute("log", "2");
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("/mess/?session="+session);
		return redirectView;
	
	}
	
	@RequestMapping("/changePassword")
	public String changePasswordPage(HttpSession session) {
		String l = (String) session.getAttribute("log");
		if (l == null) {
			return "redirect:/adminlogin";
		}
		return "messChangePassword";
	}
	
	
	@RequestMapping("/viewProfile")
	public String viewAdminProfile(HttpSession session) {
		String l = (String) session.getAttribute("log");
		if (l == null) {
			return "redirect:/adminlogin";
		}
		int mess_id, menu_id, size, i;
		mess_id = (int) session.getAttribute("mess_id");
		List<MenuReview> menuReviewList = menuReviewService.get(mess_id);
		List<String> menuNameList = new ArrayList<String>();
		size = menuReviewList.size();
		List<Integer> sizeList = new ArrayList<Integer>();
		for(i = 0; i < size; i++) {
			sizeList.add(i);
		}
		for(MenuReview menuReview:menuReviewList) {
			menu_id = menuReview.getMenuid();
			menuNameList.add(menuService.get(mess_id, menu_id).getName());
		}
		session.setAttribute("menuReviewList", menuReviewList);
		session.setAttribute("menuNameList", menuNameList);
		session.setAttribute("size", sizeList);
		return "adminProfile";
	}
	/*@RequestMapping ("/logout")
	public @ResponseBody String messLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/adminlogin";
	}*/
	
	/*
	 * Menu
	 * 
	 */
	
	@RequestMapping("/menu")
	public String getMenu(HttpSession session){
		Integer mess_id = (Integer) session.getAttribute("mess_id");
		List<Menu> menuList = menuService.get(mess_id);
		session.setAttribute("menuList", menuList);
		System.out.println(menuList);
		return "menuHome";
	}
	
	@RequestMapping("/menu/show")
	public @ResponseBody Menu getMenu(@RequestParam int mess_id, @RequestParam int menu_id){
		return menuService.get(mess_id, menu_id);
	}
	
	@PostMapping("/menu/add")
	public String addMenu(@RequestParam String name, HttpSession session) {
		Integer mess_id = (Integer) session.getAttribute("mess_id");
		menuService.add(mess_id, name);
		return "redirect:/mess/menu";
	}
	
	@RequestMapping("/menu/add/page")
	public String addMenuPage() {
		return "addMenu";
	}
	
	@PostMapping("/menu/delete")
	public String delMenu(@RequestParam String name, HttpSession session) {
		Integer mess_id = (Integer) session.getAttribute("mess_id");
		menuService.delete(mess_id, name);
		return "redirect:/mess/menu";
	}
	
	
	
	
	
	/*
	 * Inventory
	 * 
	 */
	
	@RequestMapping("/inventory")
	public String inventoryHome(HttpSession session) {
		Integer mess_id = (Integer) session.getAttribute("mess_id");
		List<Inventory> inventoryList = inventoryService.getAllInventory(mess_id);
		session.setAttribute("inventoryList", inventoryList);
		return "inventoryHome";
	}
	
	@RequestMapping("/inventory/{name}")
	public @ResponseBody Inventory getInventory(@RequestParam int mess_id, @PathVariable("name") String name){
		return inventoryService.getInfo(mess_id, name);
	}
	
	@PostMapping("/inventory/add")
	public String addInventory(@RequestParam String name, @RequestParam int stock, @RequestParam int avg_price, HttpSession session) {
		Integer mess_id = (Integer) session.getAttribute("mess_id");
		String result = inventoryService.add(name, stock, avg_price, mess_id);
		session.setAttribute("message", result);
		return "redirect:/mess/inventory";
	}
	
	@GetMapping("/inventory/add/page")
	public String addInventoryPage(HttpSession session) {
		if ((String)session.getAttribute("log") == "1") {
			return "inventoryAdd";
		}
		return "redirect:/adminlogin";
	}
	
	@PostMapping("/inventory/{name}/update")
	public @ResponseBody String updateInventory(@RequestParam Integer inventoryid, @PathVariable("name") String name, @RequestParam int stock, @RequestParam int avg_price, @RequestParam int mess_id) {
		return inventoryService.update(inventoryid, name, stock, avg_price, mess_id);
	}
	
	@PostMapping("/inventory/{name}/updateStock")
	public @ResponseBody String updateInventoryStock(@PathVariable("name") String name, @RequestParam int stock, @RequestParam int mess_id) {
		return inventoryService.updateStock(name, stock, mess_id);
	}
	
	@RequestMapping("/inventory/delete")
	public String inventoryDelete (@RequestParam Integer inventory_id) {
		inventoryService.delete(inventory_id);
		return "redirect:/mess/inventory";
	}
	
	/*
	 * Student
	 * 
	 */
	
	@RequestMapping("/student")
	public String studentHome(HttpSession session) {
		String l = (String) session.getAttribute("log");
		if (l == null) {
			return "redirect:/adminlogin";
		}
		else if(l == "1") {
			session.removeAttribute("status");
		}
		Integer mess_id = (Integer) session.getAttribute("mess_id");
		List<Student> studentList = studentService.getAllStudents(mess_id);
		session.setAttribute("studentList", studentList);
		session.setAttribute("log", "1");
		return "messStudentHome";
	}
	
	@RequestMapping("/newstudent")
	public String newStudent(HttpSession session) {
		return "newStudent";
	}
	
	@RequestMapping(value = "/student/signin", method = RequestMethod.POST)
	public @ResponseBody RedirectView signinStudent(@RequestParam Integer mis, @RequestParam String name, @RequestParam String room_no, @RequestParam short year_of_study, @RequestParam Long contact, @RequestParam String email, @RequestParam String password, HttpSession session) {
		String l = (String) session.getAttribute("log");
		if (l == null) {
			RedirectView redirectView = new RedirectView();
		    redirectView.setUrl("/adminlogin");
			return redirectView;
		}
		int mess_id = (int) session.getAttribute("mess_id");
		//existence of student check done internally
		Boolean result = studentService.add(mis, name, room_no, year_of_study, contact, email, password, mess_id);
		if(result) {
			Calendar cal = Calendar.getInstance();
			String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
			int numDays = cal.getActualMaximum(Calendar.DATE);
			int d = cal.get(Calendar.DAY_OF_MONTH);
			int days_remaining = numDays -d;
			short numMeals = (short) (days_remaining*2);
			LocalTime cmp = LocalTime.parse("13:30");
			LocalTime c = LocalTime.now();
			if (c.isBefore(cmp)){
				numMeals = (short) (numMeals + 1);
			}
			numMeals = (short) (numMeals + 1);
			studentBillService.add(mis, month, numMeals, (short)0, (short)0, (short)0);
			session.setAttribute("status", "Added a student");
		}
		else {
			session.setAttribute("status", "Failed to add student");
		}
		session.setAttribute("log", "2");
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("/mess/student/?session="+session);
		return redirectView;
	}
	
	
	///Update and delete design it accrdingly (as per requirement) later
	
	@PostMapping("/student/update")
	public @ResponseBody String updateStudent(@RequestParam Integer mis, @RequestParam String name, @RequestParam String room_no, @RequestParam short year_of_study, @RequestParam Long contact, @RequestParam String email, @RequestParam String password, @RequestParam Integer mess_id) {
		return studentService.update(mis, name, room_no, year_of_study, contact, email, password, mess_id);
	}
	
	//Only mess admins can delete a student account
	@RequestMapping("/student/delete")
	public String deleteStudent(@RequestParam Integer mis, @RequestParam String pass, HttpSession session) {
		session.removeAttribute("status");
		Student s = studentService.get(mis);
		int mess_id = s.getMessid();
		Mess m = messService.get(mess_id);
		if (m.getPassword().equals(pass)) {
			studentService.delete(mis);
			session.setAttribute("status", "Student Removed Successfully");
		}
		else {
			session.setAttribute("status", "Password Incorrect!!, Please Enter Correct Password");
		}
		return "redirect:/mess/student";
	}
	
	//Manage menu
	//Manage student
	//Manage  mess staff
	//Mnage asnacksmenu
	//Manage inventory
	//Add daily menu
	//review feedback
	
	/*
	 * Staff
	 * 
	 */
	@RequestMapping("/staff")
	public String messStaffHome (HttpSession session){
		int mess_id = (int) session.getAttribute("mess_id");
		List<MessStaff> staffList = messStaffService.getAllMessStaff(mess_id);
		session.setAttribute("staffList", staffList);
		return "staffHome";
	}
	@RequestMapping("/staff/add/page")
	public String messStaffAddPage (){
		return "staffAdd";
	}
	@RequestMapping(value = "/staff/add", method = RequestMethod.POST)
	public String messStaffAdd (@RequestParam String name, @RequestParam Long account_no, @RequestParam Long contact, @RequestParam String address, @RequestParam Integer salary, HttpSession session) {
		Calendar cal = Calendar.getInstance();
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		session.removeAttribute("status");
		//session.removeAttribute("error");
		Integer mess_id = (Integer) session.getAttribute("mess_id");
		Integer staff_id = messStaffService.add(name, mess_id, account_no, contact, address);
		if (staff_id != 0) {
			staffSalaryService.add(staff_id, 0, month, salary);
			session.setAttribute("status", "Added Successfully");
			return "redirect:/mess/staff";
		}
		session.setAttribute("status", "Failed To Add, Please Re-try");
		return "redirect:/mess/staff";	
	}
	
	@RequestMapping("/staff/delete")
	public String messStaffDelete (@RequestParam Integer staff_id, @RequestParam String password, HttpSession session) {
		session.removeAttribute("status");
		MessStaff s = messStaffService.get(staff_id);
		int mess_id = s.getMessid();
		Mess m = messService.get(mess_id);
		if (m.getPassword().equals(password)) {
			messStaffService.delete(staff_id);
			session.setAttribute("status", "Staff Member Removed Successfully");
		}
		else {
			session.setAttribute("status", "Password Incorrect!!, Please Enter Correct Password");
		}
		return "redirect:/mess/staff";
	}
	
	
}