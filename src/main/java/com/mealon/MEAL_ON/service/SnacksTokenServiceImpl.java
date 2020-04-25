package com.mealon.MEAL_ON.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.SnacksTokenDAO;
import com.mealon.MEAL_ON.model.SnacksToken;
import com.mealon.MEAL_ON.model.SnacksTokenID;

@Service
public class SnacksTokenServiceImpl implements SnacksTokenService {

	@Autowired
	private SnacksTokenDAO snacksTokenDAO;	

	@Transactional
	@Override
	public Boolean add(int mis, int snacks_id, int id, int price) {
		Boolean result = false;
		SnacksToken newSnacksToken = toSnacksToken(mis, snacks_id, id, price);
		try {
			snacksTokenDAO.save(newSnacksToken);
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	@Transactional
	@Override
	public List<SnacksToken> get(int mis) {
		List<SnacksToken> allSnackTokenList = null;
		try {
			allSnackTokenList = snacksTokenDAO.findByMis(mis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allSnackTokenList;
	}

	
	@Transactional
	@Override
	public Boolean delete(String datetime, int mis, int snacks_id, int id, int price) {
		Boolean result = false;
		SnacksTokenID snacksTokenID = toSnacksTokenID(datetime, mis, snacks_id, id);
		try {
			Optional<SnacksToken> optionalSnacksToken = snacksTokenDAO.findById(snacksTokenID);
			if(optionalSnacksToken.isPresent()) {
				snacksTokenDAO.delete(optionalSnacksToken.get());
				result = true;
			}
			else {
				result = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private SnacksToken toSnacksToken(int mis, int snacks_id, int id, int price) {
		SnacksToken newSnacksToken = new SnacksToken();
		newSnacksToken.setMis(mis);
		newSnacksToken.setSnacksid(snacks_id);
		newSnacksToken.setId(id);
		newSnacksToken.setPrice(price);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		newSnacksToken.setDatetime(dtf.format(now));
		return newSnacksToken;
	}
	
	private SnacksTokenID toSnacksTokenID(String datetime, int mis, int snacks_id, int id) {
		SnacksTokenID newSnacksTokenID = new SnacksTokenID();
		newSnacksTokenID.setDatetime(datetime);
		newSnacksTokenID.setMis(mis);
		newSnacksTokenID.setSnacksid(snacks_id);
		newSnacksTokenID.setId(id);
		return newSnacksTokenID;
	}
}

