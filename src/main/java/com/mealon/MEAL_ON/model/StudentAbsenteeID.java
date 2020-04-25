package com.mealon.MEAL_ON.model;

import java.io.Serializable;

public class StudentAbsenteeID implements Serializable{
	private int mis;
	private String from;
	private String to;
	private String type;
	public int getMis() {
		return mis;
	}
	public void setMis(int mis) {
		this.mis = mis;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
