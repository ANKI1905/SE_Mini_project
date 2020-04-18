package com.mealon.MEAL_ON.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.MenuReviewDAO;
import com.mealon.MEAL_ON.dao.ReviewRatingDAO;
import com.mealon.MEAL_ON.model.MenuReview;
import com.mealon.MEAL_ON.model.ReviewRating;


@Service
public class ReviewRatingServiceImpl implements ReviewRatingService {

	@Autowired
	private ReviewRatingDAO reviewRatingDAO;
	
	

	@Transactional
	@Override
	public Boolean add(int mis, int menu_id, int rating, String comments) {
		Boolean result = false;
		ReviewRating newReviewRating = toReviewRating(mis, menu_id, rating, comments);
		try {
			reviewRatingDAO.save(newReviewRating);
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	
	
	@Transactional
	@Override
	public List<MenuReview> get(Integer[] menu_ids) {
		List<MenuReview> allMenuReviewList = null;
		Iterator<Integer> iterator = Arrays.asList(menu_ids).iterator(); 
		Iterable<Integer> iterable = getIterableFromIterator(iterator); 
		try {
			 Iterable<MenuReview> iteratorIds = menuReviewDAO.findAllById(iterable);
			 allMenuReviewList = iterableToList(iteratorIds);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allMenuReviewList;
	}

	@Transactional
	@Override
	public Boolean delete(int menu_id) {
		//check for mess_id in controller
		Boolean result = false;
		List<ReviewRating> list= reviewRatingDAO.findByMenuid(menu_id);
		if(list != null) {
			try {
				for(Revie..list..list.)
				reviewRatingDAO.delete(reviewRating);
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	private ReviewRating toReviewRating(int mis, int menu_id, int rating, String comments) {
		ReviewRating newReviewRating = new ReviewRating();
		//review_id wil be generated automatically
		newReviewRating.setMis(mis);
		newReviewRating.setMenuid(menu_id);
		newReviewRating.setRating(rating);
		newReviewRating.setComments(comments);
		return newReviewRating;
	}
	
	
	private List<MenuReview> iterableToList(Iterable<MenuReview> iterator) { 
		List<MenuReview> list = new ArrayList<>(); 
		iterator.forEach(list::add); 
		return list; 
	}
	
	
	private Iterable<Integer> getIterableFromIterator(Iterator<Integer> iterator) { 
        return new Iterable<Integer>() { 
            @Override
            public Iterator<Integer> iterator() 
            { 
                return iterator; 
            } 
        }; 
    }
	/*
	 * 
	 * 
	 * private List<Menu> optionalToList(Optional<Menu> iterator) { List<Menu> list
	 * = new ArrayList<>(); iterator.ifPresent(list::add); return list; }
	 */
}
