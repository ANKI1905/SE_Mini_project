package com.mealon.MEAL_ON.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mealon.MEAL_ON.dao.MenuRepository;
import com.mealon.MEAL_ON.model.Menu;

@Component
public class MenuServicee  implements MenuService{
	
	@Autowired
	MenuRepository menurepo;
	
	public List<Menu> get(int Mess_id){
		return (List<Menu>) menurepo.findAll();
	
	}
	
	public Menu get(int Menu_id, int Mess_id) {
		 Optional<Menu> menu = menurepo.findById(Menu_id);
		  return menu.orElseThrow(IllegalStateException::new);
		 
	}
	
	public void add(Menu menu) {
		menurepo.save(toEntity(menu));
	
	}
	
	public void delete(int Menu_id, int Mess_id) {
		menurepo.deleteById(Menu_id);
		
	
	}
	
	private Menu toEntity(Menu menu) {
		Menu entity = new Menu();
		entity.setMenu_id(menu.getMenu_id());
		entity.setName(menu.getName());
		entity.setMess_id(menu.getMess_id());
		return entity;
		
	}
	

}





 

  