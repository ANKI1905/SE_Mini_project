package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="snacks_menu")
public class SnacksMenu {
	//All the variables name as small case, and attributes(@Column) name in snake case
	
	//Create such @Entity for all the tables in SQL
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="snacks_id")
	private int snacksid;
	@Column(name="name")
	private String name;
	@Column(name="price")
	private int price;
	@Column(name="mess_id")
	private int messid;
	
	public int getSnacksid() {
		return snacksid;
	}
	public void setSnacksid(Integer snacksid) {
		this.snacksid = snacksid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public int getMessid() {
		return messid;
	}
	public void setMessid(Integer messid) {
		this.messid = messid;
	}
	
	

}
