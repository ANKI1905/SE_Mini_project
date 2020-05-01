package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="snacks_token")
@IdClass(SnacksTokenID.class)
public class SnacksToken {
	//All the variables name as small case, and attributes(@Column) name in snake case
	
	//Create such @Entity for all the tables in SQL
	
	//Timestamp requires testing
	
	@Id
	@Column(name="date_time")
	private String datetime; //DATETIME - format: YYYY-MM-DD HH:MI:SS
	@Id
	@Column(name="mis")
	private int mis;
	@Id
	@Column(name="snacks_id")
	private int snacksid;
	@Id
	@Column(name="id")
	private int id;
	@Column(name="price")
	private int price;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
