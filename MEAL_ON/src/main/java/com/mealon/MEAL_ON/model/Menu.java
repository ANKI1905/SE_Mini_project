package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Menu")
public class Menu {
	@Id
	@Column
	private int Menu_id;
	
	@Column
	private String Name;
	
	@Column
	private int Mess_id;

	public int getMenu_id() {
		return Menu_id;
	}

	public void setMenu_id(int menu_id) {
		Menu_id = menu_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getMess_id() {
		return Mess_id;
	}

	public void setMess_id(int mess_id) {
		Mess_id = mess_id;
	}
	

}
