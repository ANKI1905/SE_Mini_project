package com.mealon.MEAL_ON.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.ReviewRatingDAO;
import com.mealon.MEAL_ON.model.ReviewRating;


@Service
public class ReviewRatingServiceImpl implements ReviewRatingService {

	@Autowired
	private ReviewRatingDAO reviewRatingDAO;
	
	@Autowired
	private MenuReviewService menuReviewService;
	@Autowired
	private StudentService studentService;
	

	@Transactional
	@Override
	public Boolean add(int mis, int menu_id, int rating, String comments) {
		Boolean result = false;
		int mess_id, totRating;
		float avgRating;
		String commentOverview;
		List<ReviewRating> reviewRatingList;
		ReviewRating reviewRating = reviewRatingDAO.findByMenuidAndMis(menu_id, mis);
		//If Menu_id and MIS does not exists
		if(reviewRating == null) {
			ReviewRating newReviewRating = toReviewRating(mis, menu_id, rating, comments);
			try {
				reviewRatingDAO.save(newReviewRating);
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} //If Menu_id and MIS exists
		else {
			ReviewRating newReviewRating = toReviewRating(mis, menu_id, rating, comments);
			newReviewRating.setReviewid(reviewRating.getReviewid());
			try {
				reviewRatingDAO.save(newReviewRating);
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		mess_id = studentService.getMessid(mis);
		reviewRatingList = getByMenuid(menu_id);
		totRating = 0;
		commentOverview = "";
		for(ReviewRating review : reviewRatingList) {
			totRating += review.getRating();
		}
		for(ReviewRating comment : reviewRatingList) {
			commentOverview += comment.getComments() + ", ";
		}
		avgRating = (float)totRating/(float)reviewRatingList.size();
		System.out.println(avgRating);
		result = menuReviewService.add(mess_id, menu_id, avgRating, commentOverview);
		return result;
		
	}

	

	@Transactional
	@Override
	public List<ReviewRating> getAll(Integer[] menu_ids) {
		//check for mess_id in controller
		List<ReviewRating> list = new ArrayList<ReviewRating>();
		List<ReviewRating> reviewRating = null;
		for(int menu_id:menu_ids) {
			reviewRating = getByMenuid(menu_id);
			for(ReviewRating review:reviewRating) {
				list.add(review);
			}
		}
		return list;		
	}
	

	@Transactional
	@Override
	public List<ReviewRating> getByMis(Integer[] menu_ids, int mis) {
		//check for mess_id in controller
		List<ReviewRating> list = new ArrayList<ReviewRating>();
		ReviewRating reviewRating = null;
		try {
			for(int menu_id:menu_ids) {
				reviewRating = reviewRatingDAO.findByMenuidAndMis(menu_id, mis);
				list.add(reviewRating);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	

	@Transactional
	@Override
	public List<ReviewRating> getByMenuid(int menu_id) {
		//check for mess_id in controller
		List<ReviewRating> list = null;
		try {
			list = reviewRatingDAO.findByMenuid(menu_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;		
	}
	

	@Transactional
	@Override
	public List<ReviewRating> getByRatingLessThanEqual(Integer[] menu_ids, int rating) {
		//check for mess_id in controller
		List<ReviewRating> list = new ArrayList<ReviewRating>();
		List<ReviewRating> reviewRating = null;
		for(int menu_id:menu_ids) {
			reviewRating = getByMenuid(menu_id);
			for(ReviewRating review:reviewRating) {
				if(rating >= review.getRating())
					list.add(review);
			}
		}
		return list;		
	}
	
	
	@Transactional
	@Override
	public List<ReviewRating> getByRatingGreaterThanEqual(Integer[] menu_ids, int rating) {
		//check for mess_id in controller
		List<ReviewRating> list = new ArrayList<ReviewRating>();
		List<ReviewRating> reviewRating = null;
		for(int menu_id:menu_ids) {
			reviewRating = getByMenuid(menu_id);
			for(ReviewRating review:reviewRating) {
				if(rating <= review.getRating())
					list.add(review);
			}
		}
		return list;		
	}
	
	@Transactional
	@Override
	public Boolean delete(int menu_id) {
		//check for mess_id in controller
		/*
		 * Success :: List is deleted,
		 * Success :: List does not exists
		 * Fails   :: List exists and fails to delete
		 */
		Boolean result = false;
		List<ReviewRating> list = null;
		try {
			list = reviewRatingDAO.findByMenuid(menu_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(list != null) {
			try {
				for(ReviewRating reviewRating:list) {
					reviewRatingDAO.delete(reviewRating);
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
	
	
	
	
	private ReviewRating toReviewRating(int mis, int menu_id, int rating, String comments) {
		ReviewRating newReviewRating = new ReviewRating();
		//review_id will be generated automatically
		newReviewRating.setMis(mis);
		newReviewRating.setMenuid(menu_id);
		newReviewRating.setRating(rating);
		newReviewRating.setComments(comments);
		return newReviewRating;
	}
	
}
