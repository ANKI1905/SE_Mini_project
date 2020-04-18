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
import com.mealon.MEAL_ON.model.MenuReview;


@Service
public class MenuReviewServiceImpl implements MenuReviewService {

	@Autowired
	private MenuReviewDAO menuReviewDAO;
	
	

	@Transactional
	@Override
	public Boolean add(Integer menu_id, Integer avgRating, String commentOverview) {
		//check for mess_id in controller
		Boolean result = false;
		MenuReview newMenuReview = toMenuReview(menu_id, avgRating, commentOverview);
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
	public Boolean update(Integer menu_id, Integer avgRating, String commentOverview) {
		//check for mess_id in controller
		Boolean result = false;
		if(menuReviewDAO.findById(menu_id)  != null) {
			MenuReview newMenuReview = toMenuReview(menu_id, avgRating, commentOverview);
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
	public Boolean delete(Integer menu_id) {
		//check for mess_id in controller
		Boolean result = false;
		if(menuReviewDAO.findById(menu_id) != null) {
			try {
				menuReviewDAO.deleteById(menu_id);
				result = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	private MenuReview toMenuReview(int menu_id, int avgRating, String commentOverview) {
		MenuReview newMenuReview = new MenuReview();
		newMenuReview.setMenuid(menu_id);
		newMenuReview.setAvgrating(avgRating);
		newMenuReview.setCommentoverview(commentOverview);
		return newMenuReview;
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