package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.MessStaff;


public interface MessStaffService {
	//Used only when MessAdmin is logged in

	Boolean add(String name, int mess_id, int account_no, int contact, String address);
	List<MessStaff> getAllMessStaff(int mess_id);
	MessStaff get(int mess_id, String name);
	Boolean update(String name, int mess_id, int account_no, int contact, String address);
	Boolean delete(int mess_id, String name);

}
