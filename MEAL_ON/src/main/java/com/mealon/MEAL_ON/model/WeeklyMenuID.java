package com.mealon.MEAL_ON.model;

import java.io.Serializable;

public class WeeklyMenuID implements Serializable {
	private int messid;
	private String day;
	private String type;
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
	
	
}