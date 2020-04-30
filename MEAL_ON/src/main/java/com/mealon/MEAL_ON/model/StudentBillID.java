package com.mealon.MEAL_ON.model;

import java.io.Serializable;


public class StudentBillID implements Serializable {
	private int mis;
	private String month;
	public int getMis() {
		return mis;
	}
	public void setMis(int mis) {
		this.mis = mis;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
}