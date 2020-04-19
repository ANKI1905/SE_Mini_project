package com.mealon.MEAL_ON.model;

import java.io.Serializable;

public class StaffSalaryID implements Serializable {
    private int staffid;
    private String month;
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
    
}