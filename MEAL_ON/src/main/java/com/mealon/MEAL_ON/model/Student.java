package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
		//All the variables name as small case, and attributes(@Column) name in snake case
		
		//Create such @Entity for all the tables in SQL

		@Id
		@Column(name="mis")
        private int mis;
		@Column(name="name")
        private String name;
		@Column(name="room_no")
        private String roomno;
		@Column(name="year_of_study")
        private short yearofstudy;
		@Column(name="contact")
        private int contact;
		@Column(name="email")
        private String email;
		@Column(name="password")
        private String password;
		@Column(name="mess_id")
        private int messid;

        
		
        public int getMis() {
			return mis;
		}

		public void setMis(int mis) {
			this.mis = mis;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRoomno() {
			return roomno;
		}


		public void setRoomno(String roomno) {
			this.roomno = roomno;
		}


		public short getYearofstudy() {
			return yearofstudy;
		}


		public void setYearofstudy(short yearofstudy) {
			this.yearofstudy = yearofstudy;
		}


		public int getContact() {
			return contact;
		}


		public void setContact(int contact) {
			this.contact = contact;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public int getMessid() {
			return messid;
		}


		public void setMessid(int messid) {
			this.messid = messid;
		}


		@Override
        public String toString() {
                return "Student [MIS=" + mis + ", Name=" + name + ", Room_no=" + roomno + ", Year_of_Study=" + yearofstudy
                                + ", Contact=" + contact + ", Email=" + email + ", Mess_id=" + messid
                                + "]";
        }
}