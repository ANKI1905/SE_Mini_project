package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mess_staff")
public class MessStaff {
		//All the variables name as small case, and attributes(@Column) name in snake case
		
		//Create such @Entity for all the tables in SQL

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "staff_id", nullable = false)
        private int staffid;
        @Column(name="name")
        private String name;
        @Column(name="mess_id")
        private int messid;
        @Column(name="account_no")
        private Long accountno;
        @Column(name="contact")
        private Long contact;
        @Column(name="address")
        private String address;
        
        public int getStaffid() {
			return staffid;
		}

		public void setStaffid(int staffid) {
			this.staffid = staffid;
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


		public Long getAccountno() {
			return accountno;
		}


		public void setAccountno(Long accountno) {
			this.accountno = accountno;
		}


		public Long getContact() {
			return contact;
		}


		public void setContact(Long contact) {
			this.contact = contact;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		@Override
        public String toString() {
                return "Mess_staff [staff_id=" + staffid + ", Name=" + name + ", Mess_id=" + messid + ", Account_no="
                                + accountno + ", contact=" + contact + ", Address=" + address + "]";
        }

}