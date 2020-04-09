package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mess")
public class Mess {
		//All the variables name as small case, and attributes(@Column) name in snake case
		
		//Create such @Entity for all the tables in SQL

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="mess_id")
        private Integer messid;
        @Column(name="name")
        private String name;
        @Column(name="password")
        private String password;
        @Column(name="mess_admin")
        private String messadmin;
        @Column(name="rate")
        private Integer rate;
		public Integer getMessid() {
			return messid;
		}
		public void setMessid(Integer messid) {
			this.messid = messid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMessadmin() {
			return messadmin;
		}
		public void setMessadmin(String messadmin) {
			this.messadmin = messadmin;
		}
		public Integer getRate() {
			return rate;
		}
		public void setRate(Integer rate) {
			this.rate = rate;
		}
        
}
