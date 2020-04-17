package com.mealon.MEAL_ON.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="menu_review")
public class MenuReview {
	//All the variables name as small case, and attributes(@Column) name in snake case
	
	//Create such @Entity for all the tables in SQL
	
	
	@Column(name="menu_id")
	private int menuid;
	@Column(name="avg_rating")
	private int avgrating;
	@Column(name="comment_overview")
	private String commentoverview;
	
	
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getAvgrating() {
		return avgrating;
	}
	public void setAvgrating(int avgrating) {
		this.avgrating = avgrating;
	}
	public String getCommentoverview() {
		return commentoverview;
	}
	public void setCommentoverview(String commentoverview) {
		this.commentoverview = commentoverview;
	}
	
	
	

}
