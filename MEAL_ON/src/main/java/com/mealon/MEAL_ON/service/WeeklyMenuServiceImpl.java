package com.mealon.MEAL_ON.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.WeeklyMenuDAO;
import com.mealon.MEAL_ON.model.WeeklyMenu;
import com.mealon.MEAL_ON.model.WeeklyMenuID;

@Service
public class WeeklyMenuServiceImpl implements WeeklyMenuService {

	@Autowired
	private WeeklyMenuDAO weeklyMenuDAO;
	@Autowired
	private MenuService menuService;
	
	@Transactional
	@Override
	public Boolean add(int mess_id, String day, String type, String menu_id_array) {
		Boolean result;
		result = check(mess_id, menu_id_array);
		if(result) {
			WeeklyMenu newWeeklyMenu = toWeeklyMenu(mess_id, day, type, menu_id_array);
			try {
				weeklyMenuDAO.save(newWeeklyMenu);
			}
			catch (Exception e) {
				result = false;
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Transactional
	@Override
	public Boolean check(int mess_id, String menu_id_array) {
		//menu_id_array = "1,2,4,3";
		Boolean result = true;
		Integer[] list= menuService.getMenuIDs(mess_id);
		List<Integer> existingList = Arrays.asList(list);
	    List<Integer> checkList = Arrays.stream(menu_id_array.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		for(int check:checkList) {
			if(existingList.contains(check)) {
				continue;
			}
			else {
				result = false;
				break;
			}
		}
		return result;
	}
	
	@Transactional
	@Override
	public List<WeeklyMenu> get(int mess_id) {
		List<WeeklyMenu> list = null;
		try {
			list = weeklyMenuDAO.findByMessid(mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Transactional
	@Override
	public List<WeeklyMenu> getbyDay(int mess_id, String day) {
		List<WeeklyMenu> list = null;
		try {
			list = weeklyMenuDAO.findByMessidAndDay(mess_id, day);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Transactional
	@Override
	public List<WeeklyMenu> getbyType(int mess_id, String type) {
		List<WeeklyMenu> list = null;
		try {
			list = weeklyMenuDAO.findByMessidAndType(mess_id, type);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Transactional
	@Override
	public WeeklyMenu getbyDayAndType(int mess_id, String day, String type) {
		Optional<WeeklyMenu> optionalList = null;
		WeeklyMenu weeklyMenu= null;
		WeeklyMenuID id = toWeeklyMenuID(mess_id, day, type);
		try {
			optionalList = weeklyMenuDAO.findById(id);
			if(optionalList.isPresent()) {
				weeklyMenu = optionalList.get();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return weeklyMenu;
	}
	@Transactional
	@Override
	public Boolean delete(int mess_id, String day, String type) {
		Boolean result = false;
		WeeklyMenuID id = toWeeklyMenuID(mess_id, day, type);
		try {
			weeklyMenuDAO.deleteById(id);
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Transactional
	@Override
	public Boolean update(int mess_id, String day, String type, String menu_id_array) {
		Boolean result;
		result = check(mess_id, menu_id_array);
		if(result) {
			WeeklyMenu newWeeklyMenu = toWeeklyMenu(mess_id, day, type, menu_id_array);
			try {
				weeklyMenuDAO.save(newWeeklyMenu);
			}
			catch (Exception e) {
				result = false;
				e.printStackTrace();
			}
		}
		return result;
	}

	
	private WeeklyMenuID toWeeklyMenuID(int mess_id, String day, String type) {
		WeeklyMenuID newWeeklyMenuID = new WeeklyMenuID();
		newWeeklyMenuID.setMessid(mess_id);
		newWeeklyMenuID.setDay(day);
		newWeeklyMenuID.setType(type);
		return newWeeklyMenuID;
	}
	private WeeklyMenu toWeeklyMenu(int mess_id, String day, String type, String menu_id_array) {
		WeeklyMenu newWeeklyMenu = new WeeklyMenu();
		newWeeklyMenu.setMessid(mess_id);
		newWeeklyMenu.setDay(day);
		newWeeklyMenu.setType(type);
		newWeeklyMenu.setMenuidarray(menu_id_array);
		return newWeeklyMenu;
	}
	
	/*
	 * private List<Menu> iterableToList(Iterable<Menu> iterator) { List<Menu> list
	 * = new ArrayList<>(); iterator.forEach(list::add); return list; }
	 * 
	 * private List<Menu> optionalToList(Optional<Menu> iterator) { List<Menu> list
	 * = new ArrayList<>(); iterator.ifPresent(list::add); return list; }
	 */
}
