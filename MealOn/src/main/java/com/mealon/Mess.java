package com.mealon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mess {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Mess_id;
	private String Name;
	private String Password;
	private String Mess_Admin;
	private Integer Rate;
	public Integer getMess_id() {
		return Mess_id;
	}
	public void setMess_id(Integer mess_id) {
		Mess_id = mess_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMess_Admin() {
		return Mess_Admin;
	}
	public void setMess_Admin(String mess_Admin) {
		Mess_Admin = mess_Admin;
	}
	public Integer getRate() {
		return Rate;
	}
	public void setRate(Integer rate) {
		Rate = rate;
	}
	
}
