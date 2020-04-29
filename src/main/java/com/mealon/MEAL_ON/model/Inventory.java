package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
		//All the variables name as small case, and attributes(@Column) name in snake case
	
		//Create such @Entity for all the tables in SQL
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="inventory_id")
        private int inventoryid;
		@Column(name="name")
        private String name;
		@Column(name="stock")
        private int stock;
		@Column(name="avg_price")
        private int avgprice;
		@Column(name="mess_id")
        private int messid;
		
		
		public int getInventoryid() {
			return inventoryid;
		}
		public void setInventoryid(int inventoryid) {
			this.inventoryid = inventoryid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public int getAvgprice() {
			return avgprice;
		}
		public void setAvgprice(int avgprice) {
			this.avgprice = avgprice;
		}
		public int getMessid() {
			return messid;
		}
		public void setMessid(int messid) {
			this.messid = messid;
		}
		@Override
		public String toString() {
			return "Inventory [inventoryid=" + inventoryid + ", name=" + name + ", stock=" + stock + ", avgprice="
					+ avgprice + ", messid=" + messid + "]";
		}
        
}
