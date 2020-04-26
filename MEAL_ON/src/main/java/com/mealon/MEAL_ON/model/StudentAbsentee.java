package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="stud_absentee")
@IdClass(StudentAbsenteeID.class)
public class StudentAbsentee {
	//All the variables name as small case, and attributes(@Column) name in snake case
	
	//Create such @Entity for all the tables in SQL
	
	@Id
	@Column(name="mis")
	private int mis;
	@Id
	@Column(name="from_")
	private String from;
	@Id
	@Column(name="to_")
	private String to;
	@Id
	@Column(name="type_")
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
