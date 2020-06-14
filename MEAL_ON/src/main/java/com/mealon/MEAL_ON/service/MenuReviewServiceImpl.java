package com.mealon.MEAL_ON.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.MenuReviewDAO;
import com.mealon.MEAL_ON.model.MenuReview;


@Service
public class MenuReviewServiceImpl implements MenuReviewService {

	@Autowired
	private MenuReviewDAO menuReviewDAO;
	
	

	@Transactional
	@Override
	public Boolean add(int mess_id, int menu_id, float avgRating, String commentOverview) {
		Boolean result = false;
		MenuReview newMenuReview = toMenuReview(mess_id, menu_id, avgRating, commentOverview);
		try {
			menuReviewDAO.save(newMenuReview);
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Transactional
	@Override
	public Boolean update(int mess_id, int menu_id, float avgRating, String commentOverview) {
		//check for mess_id in controller
		Boolean result = false;
		if(menuReviewDAO.findById(menu_id)  != null) {
			MenuReview newMenuReview = toMenuReview(mess_id, menu_id, avgRating, commentOverview);
			try {
				menuReviewDAO.save(newMenuReview);
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Transactional
	@Override
	public List<MenuReview> get(int mess_id) {
		List<MenuReview> allMenuReviewList = null;
		try {
			 allMenuReviewList = menuReviewDAO.findByMessid(mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allMenuReviewList;
	}

	@Transactional
	@Override
	public Boolean delete(int mess_id, int menu_id) {
		Boolean result = false;
		List<MenuReview> menuReviews = menuReviewDAO.findByMessid(mess_id);
		if(menuReviews != null) {
			try {
				for(MenuReview menuReview:menuReviews) {
					if(menuReview.getMenuid() == menu_id)
						menuReviewDAO.delete(menuReview);
				}
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			result = true;
		}
		return result;
		
	}
	
	private MenuReview toMenuReview(int mess_id, int menu_id, float avgRating, String commentOverview) {
		MenuReview newMenuReview = new MenuReview();
		newMenuReview.setMessid(mess_id);
		newMenuReview.setMenuid(menu_id);
		newMenuReview.setAvgrating(avgRating);
		newMenuReview.setCommentoverview(commentOverview);
		return newMenuReview;
	}
	
}
