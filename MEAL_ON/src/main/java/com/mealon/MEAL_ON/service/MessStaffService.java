package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.MessStaff;


public interface MessStaffService {
	//Used only when MessAdmin is logged in

	Integer add(String name, int mess_id, Long account_no, Long contact, String address);
	List<MessStaff> getAllMessStaff(int mess_id);
	MessStaff get(int mess_id, String name);
	Boolean update(String name, int mess_id, Long account_no, Long contact, String address);
	Boolean delete(int mess_id, String name);
	List<Integer> getStaffIdList(int mess_id);
	Boolean delete(Integer staff_id);

}