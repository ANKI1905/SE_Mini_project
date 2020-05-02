package com.mealon.MEAL_ON.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.mealon.MEAL_ON.model.Menu;
import com.mealon.MEAL_ON.model.SnacksMenu;
import com.mealon.MEAL_ON.model.Student;
import com.mealon.MEAL_ON.model.StudentAbsentee;
import com.mealon.MEAL_ON.model.WeeklyMenu;
import com.mealon.MEAL_ON.service.MenuService;
import com.mealon.MEAL_ON.service.ReviewRatingService;
import com.mealon.MEAL_ON.service.SnacksMenuService;
import com.mealon.MEAL_ON.service.StudentAbsenteeService;
import com.mealon.MEAL_ON.service.StudentService;
import com.mealon.MEAL_ON.service.WeeklyMenuService;


@Controller
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private WeeklyMenuService weeklyMenuService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private SnacksMenuService snacksMenuService;
	@Autowired
	private ReviewRatingService reviewRatingService;
	@Autowired
	private StudentAbsenteeService studentAbsenteeService;
	
	
	@RequestMapping ("/check")
	public String studentCheck(@RequestParam Integer mis, @RequestParam String password, HttpSession session) {
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
		
		if (l == null) {
			return "redirect:/studentlogin";
		}
		else if(l == "1") {
			session.removeAttribute("status");
		}
		Integer mis = (Integer) session.getAttribute("mis");
		Student s = studentService.get(mis);
		session.setAttribute("name", s.getName());
		session.setAttribute("messid", studentService.getMessid(mis));
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
		String l = (String) session.getAttribute("log");
		if (l == null) {
			return "redirect:/studentlogin";
		}
		return "studentChangePassword";
	}
	
	/*
	 * Menu operations student side
	 * 
	 */
	@RequestMapping("/menuToday")
	public String allMenuList (HttpSession session){
		String l = (String) session.getAttribute("log");
		if (l == null) {
			return "redirect:/studentlogin";
		}
		int messId = (int) session.getAttribute("messid");
		//This list contains menu_id. Theses menu_ids are confirmed that they foremost belong to that mess only.
		List<WeeklyMenu> weeklyMenuList = weeklyMenuService.get(messId);
		//Note: Each MenuId is unique, regardless of messId
		List<List<String>> menuNames = new ArrayList<List<String>>();
		for(WeeklyMenu weeklyMenu:weeklyMenuList) {
			String menuIdList = weeklyMenu.getMenuidarray();
		    List<Integer> checkList = Arrays.stream(menuIdList.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		    List<String> menuName = new ArrayList<>();
		    for(Integer menuId:checkList) {
		    	Menu menu = menuService.get(messId, menuId);
		    	String name = menu.getName();
		    	menuName.add(name);
		    }
		    menuNames.add(menuName);
		}
		List<SnacksMenu> snacksMenuList = snacksMenuService.get(messId);
		int i, len = menuNames.size();
		int[] totLength = new int[len];
		for(i = 0;i < len; i++) {
			totLength[i] = i;
		}
		session.setAttribute("size", totLength);
		session.setAttribute("menuLists", menuNames);
		session.setAttribute("weeklyMenuList", weeklyMenuList);
		session.setAttribute("snacksList", snacksMenuList);
		System.out.print(totLength[0]);
		return "ViewMenu";
	}
	
	@RequestMapping("/review")
	public String giveReviewRating (HttpSession session){
		String l = (String) session.getAttribute("log");
		if (l == null) {
			return "redirect:/studentlogin";
		}
		int messId = (int)session.getAttribute("messid");
		//This list contains menu_id. Theses menu_ids are confirmed that they foremost belong to that mess only.
		List<WeeklyMenu> weeklyMenuList = weeklyMenuService.get(messId);
		Calendar calender= Calendar.getInstance();
		int today = calender.get(Calendar.DAY_OF_WEEK);
		
		
		for(WeeklyMenu weeklyMenu: weeklyMenuList) {
			switch (weeklyMenu.getDay()) {
				case "Saturday":
					if(7 <= today) {
						break;
					}
					weeklyMenuList.remove(weeklyMenu);
					break;
				case "Friday":
					if(6 <= today) {
						break;
					}
					weeklyMenuList.remove(weeklyMenu);
					break;
				case "Thursday":
					if(5 <= today) {
						break;
					}
					weeklyMenuList.remove(weeklyMenu);
					break;				
				case "Wednesday":
					if(4 <= today) {
						break;
					}
					weeklyMenuList.remove(weeklyMenu);
					break;
				case "Tuesday":
					if(3 <= today) {
						break;
					}
					weeklyMenuList.remove(weeklyMenu);
					break;
				case "Monday":
					if(2 <= today) {
						break;
					}
					weeklyMenuList.remove(weeklyMenu);
					break;
				case "Sunday":
					if(1 <= today) {
						break;
					}
					break;
			}
		}
		//Note: Each MenuId is unique, regardless of messId
		Set<String> menuNames = new HashSet<String>();
		for(WeeklyMenu weeklyMenu:weeklyMenuList) {
			String menuIdList = weeklyMenu.getMenuidarray();
		    List<Integer> checkList = Arrays.stream(menuIdList.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		    for(Integer menuId:checkList) {
		    	Menu menu = menuService.get(messId, menuId);
		    	String name = menu.getName();
		    	menuNames.add(name);
		    }
		}
		
		session.setAttribute("menuLists", menuNames);
		session.setAttribute("sizeDisplayReview", menuNames.size());
		return "giveReviewMenu";
	}
	
	@RequestMapping("/reviewRatingData")
	public String reviewRatingSubmission (HttpServletRequest request, HttpSession session){
		int i, size, mis, mess_id, menu_id, rating;
		String MenuName, review;
		Map<String, String[]> parameters;
		String l = (String) session.getAttribute("log");
		if (l == null) {
			return "redirect:/studentlogin";
		}
		i = 0;
		parameters = request.getParameterMap();
		size = (int)session.getAttribute("sizeDisplayReview");
		mis = (int)session.getAttribute("mis");
		mess_id = (int)session.getAttribute("messid");
		menu_id = 0;
		rating = 0;
		review = "";
		for(String key : parameters.keySet()) {
			if(i % 2 == 0) {
		        MenuName = key.substring(4);  //star
		        try {
		        	rating = Integer.parseInt(parameters.get(key)[0]);
		        }
		        catch (Exception e) {
					rating = 0;
		        	continue;
				}
		        menu_id = menuService.getMenuID(mess_id, MenuName);
		        //if menu_id does not exists :: This case can happen if front end is changed intentionally/unintentionally by user
		        if(menu_id == 0)
		        	break;
		        i++;
			}
			else {
				MenuName = key.substring(6);  //review
	        	review = parameters.get(key)[0];
	        	if(rating == 0 || !reviewRatingService.add(mis, menu_id, rating, review)) {
					System.out.print("Failed to add review");
				}
	        	i++;
			}
			
	    }
		System.out.print("Saved!");
		return "giveReviewMenu";
	}
	
	@RequestMapping("/markAbsentee")
	public String markAbsentee (HttpSession session){
		String l = (String) session.getAttribute("log");	
		if (l == null) {
			return "redirect:/studentlogin";
		}
		int mis = (int) session.getAttribute("mis");
		List<StudentAbsentee> absenteeRecords = studentAbsenteeService.getStudentAbsentees(mis);
		session.setAttribute("absenteeRecords", absenteeRecords);
		return "markAbsentee";
	}
	
	@RequestMapping("/markAbsenteeData")
	public String markAbsenteeData (HttpSession session, HttpServletRequest request){
		Map<String, String[]> parameters;
		int mis, mess_id;
		String from, to, type = "";
		Boolean checkType;
		String l = (String) session.getAttribute("log");	
		if (l == null) {
			return "redirect:/studentlogin";
		}
		mis = (int) session.getAttribute("mis");
		
		parameters = request.getParameterMap();
		mess_id = (int)session.getAttribute("messid");
		from = parameters.get("from")[0];
		to = parameters.get("to")[0];
		checkType = parameters.containsKey("lunch");
		if(checkType) {
			type = "L";
		}
		else if(checkType == false) {
			//This is to check that at least one checkbox is selected
			checkType = parameters.containsKey("dinner");
			if(checkType) {
				type = "D";
			}
		}
		//checkTyoe will be true if type is checked by user
		if(checkType) {
			//Reusing checkType
			checkType = studentAbsenteeService.add(mis, from, to, type);			
	    }
		List<StudentAbsentee> absenteeRecords = studentAbsenteeService.getStudentAbsentees(mis);
		session.setAttribute("absenteeRecords", absenteeRecords);
		return "markAbsentee";
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
