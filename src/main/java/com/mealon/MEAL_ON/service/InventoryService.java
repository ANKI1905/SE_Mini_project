package com.mealon.MEAL_ON.service;

import java.util.List;

import com.mealon.MEAL_ON.model.Inventory;
import com.mealon.MEAL_ON.model.MessStaff;

public interface InventoryService {
    Inventory get(int inventory_id);
    List<Inventory> getAllInventory(int mess_id);
    Inventory getInfo(int mess_id, String name);
    String add(String name, int stock, int avg_price, int mess_id);
    String update(int inventoryid, String name, int stock, int avg_price, int mess_id);
    String updateStock(String name, int stock, int mess_id);
    String delete(int mess_id, String name);
    Boolean delete (int inventory_id);

}
