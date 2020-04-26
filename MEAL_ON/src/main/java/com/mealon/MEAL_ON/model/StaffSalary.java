package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="staff_salary")
@IdClass(StaffSalaryID.class)
public class StaffSalary {
		//All the variables name as small case, and attributes(@Column) name in snake case
		
		//Create such @Entity for all the tables in SQL

        @Id
        @Column(name = "staffid", nullable = false)
        private int staffid;
        @Column(name="nos_of_leaves")
        private int nosofleaves;
        @Id
        @Column(name="month_")
        private String month;
        @Column(name="salary")
        private int salary;

		public int getStaffid() {
			return staffid;
		}
		public void setStaffid(int staffid) {
			this.staffid = staffid;
		}
		public int getNosofleaves() {
			return nosofleaves;
		}
		public void setNosofleaves(int nosofleaves) {
			this.nosofleaves = nosofleaves;
		}
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
        
        

}

