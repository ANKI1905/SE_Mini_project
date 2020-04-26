package com.mealon.MEAL_ON.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealon.MEAL_ON.dao.InventoryDAO;
import com.mealon.MEAL_ON.model.Inventory;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDAO inventoryDAO;
	
	@Transactional
    @Override
    public List<Inventory> get(int mess_id) {
		List<Inventory> allInventoryList = null;
		try {
			allInventoryList = inventoryDAO.findByMessid(mess_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allInventoryList;
    }

	@Transactional
    @Override
    public Inventory getInfo(int mess_id, String name) {
    	Inventory inventory = null;
		try {
			Inventory item = inventoryDAO.findByName(name);
			if(item.getMessid() == mess_id) {
				inventory = item;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return inventory;
    }
 
	@Transactional
    @Override
    public String add(String name, int stock, int avg_price, int mess_id) {
		Inventory inventory = toInventory(name, stock, avg_price, mess_id);
		String result = null;
		try {
			inventoryDAO.save(inventory);
			result = "Successfully updated";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }

	@Transactional
    @Override
    public String update(int inventoryid, String name, int stock, int avg_price, int mess_id) {
		String result = null;
		Optional<Inventory> optional = inventoryDAO.findById(inventoryid);
		
		if(optional.isPresent()) {
			Inventory oldInventory = (Inventory) optionalToList(optional);
			int messId = oldInventory.getMessid();
			if(messId == mess_id) {
				Inventory inventory = toInventory(inventoryid, name, stock, avg_price, mess_id);
				inventoryDAO.save(inventory);
				result = "Successfully updated";
			}
		}
		
		return result;
    }

	@Transactional
    @Override
    public String updateStock(String name, int stock, int mess_id) {
		String result = null;
		Inventory oldInventory = null;
		oldInventory = inventoryDAO.findByName(name);
		
		if(oldInventory != null) {
			int messId = oldInventory.getMessid();
			if(messId == mess_id) {
				oldInventory.setStock(stock);
				inventoryDAO.save(oldInventory);
				result = "Successfully updated";
			}
		}
		
		return result;
    }
	
	@Transactional
    @Override
    public String delete(int mess_id, String name) {
		String result = null;
		Inventory inventory = null;
		inventory = inventoryDAO.findByName(name);
		if(inventory != null && inventory.getMessid() == (mess_id)) {
			int id = inventory.getInventoryid();
			inventoryDAO.deleteById(id);
			result = "Successfully deleted";
		}
		return result;
    }	
	
	private Inventory toInventory(Integer inventoryid, String name, int stock, int avgprice, int messid) {
		Inventory inventory = new Inventory();
		inventory.setInventoryid(inventoryid);
		inventory.setName(name);
		inventory.setStock(stock);
		inventory.setAvgprice(avgprice);
		inventory.setMessid(messid);
		return inventory;
	}
	
	private Inventory toInventory(String name, int stock, int avgprice, int messid) {
		Inventory inventory = new Inventory();
		inventory.setName(name);
		inventory.setStock(stock);
		inventory.setAvgprice(avgprice);
		inventory.setMessid(messid);
		return inventory;
	}
	/*
	private List<Inventory> iterableToList(Iterable<Inventory> iterator) { 
		List<Inventory> list = new ArrayList<>(); 
		iterator.forEach(list::add); 
		 return list; 
	}
	*/
	
	private List<Inventory> optionalToList(Optional<Inventory> optional) {
		List<Inventory> list = new ArrayList<>(); 
		optional.ifPresent(list::add); 
		return list; 
	}
}
