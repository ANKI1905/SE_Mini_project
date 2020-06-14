package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu_review")
public class MenuReview {
	//All the variables name as small case, and attributes(@Column) name in snake case
	
	//Create such @Entity for all the tables in SQL
	
	@Id
	@Column(name="menu_id")
	private int menuid;
	@Column(name="mess_id")
	private int messid;
	@Column(name="avg_rating")
	private float avgrating;
	@Column(name="comment_overview")
	private String commentoverview;
	
	
	public int getMessid() {
		return messid;
	}
	public void setMessid(int messid) {
		this.messid = messid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public float getAvgrating() {
		return avgrating;
	}
	public void setAvgrating(float avgrating) {
		this.avgrating = avgrating;
	}
	public String getCommentoverview() {
		return commentoverview;
	}
	public void setCommentoverview(String commentoverview) {
		this.commentoverview = commentoverview;
	}
	
	
	

}
