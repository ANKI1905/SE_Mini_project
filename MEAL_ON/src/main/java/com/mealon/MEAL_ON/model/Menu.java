package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	//All the variables name as small case, and attributes(@Column) name in snake case
	
	//Create such @Entity for all the tables in SQL
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id", nullable = false)
	private int menuid;
	@Column(name="name")
	private String name;
	@Column(name="mess_id")
	private int messid;
	
	
	public int getMenuId() {
		return menuid;
	}
	public void setMenuId(int menuid) {
		this.menuid = menuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMessid() {
		return messid;
	}
	public void setMessid(int messid) {
		this.messid = messid;
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", name=" + name + ", messid=" + messid + "]";
	}
	

}