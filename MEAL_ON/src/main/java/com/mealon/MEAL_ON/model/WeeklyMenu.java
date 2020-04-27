package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="weekly_menu")
@IdClass(WeeklyMenuID.class)
public class WeeklyMenu {	
	//All the variables name as small case, and attributes(@Column) name in snake case
	
	//Create such @Entity for all the tables in SQL
	
	@Id
	@Column(name="mess_id")
	private int messid;
	@Id
	@Column(name="day_")
	private String day;
	@Id
	@Column(name="type_")
	private String type;
	@Column(name="menu_id_array")
	private String menuidarray;
	public int getMessid() {
		return messid;
	}
	public void setMessid(int messid) {
		this.messid = messid;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMenuidarray() {
		return menuidarray;
	}
	public void setMenuidarray(String menuidarray) {
		this.menuidarray = menuidarray;
	}


}
