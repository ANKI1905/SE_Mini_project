package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="student_bill")
@IdClass(StudentBillID.class)
public class StudentBill {
	//All the variables name as small case, and attributes(@Column) name in snake case
	
	//Create such @Entity for all the tables in SQL
	
	
	@Id
	@Column(name="mis")
	private int mis;
	@Id
	@Column(name="month_")
	private String month;
	@Column(name="nos_of_meals")
	private short nosofmeal;
	@Column(name="curr_bil")
	private int currbill;
	@Column(name="pay_status")
	private short paystatus;
	@Column(name="prev_bill")
	private int prevbill;
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
	public short getNosofmeal() {
		return nosofmeal;
	}
	public void setNosofmeal(short nosofmeal) {
		this.nosofmeal = nosofmeal;
	}
	public int getCurrbill() {
		return currbill;
	}
	public void setCurrbill(int currbill) {
		this.currbill = currbill;
	}
	public short getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(short paystatus) {
		this.paystatus = paystatus;
	}
	public int getPrevbill() {
		return prevbill;
	}
	public void setPrevbill(int prevbill) {
		this.prevbill = prevbill;
	}
	
	
	

}
