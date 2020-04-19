package com.mealon.MEAL_ON.model;

import java.io.Serializable;


public class SnacksTokenID implements Serializable {
	private String datetime;

	private int mis;
	private int snacksid;
	private int id;
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getMis() {
		return mis;
	}
	public void setMis(int mis) {
		this.mis = mis;
	}
	public int getSnacksid() {
		return snacksid;
	}
	public void setSnacksid(int snacksid) {
		this.snacksid = snacksid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}