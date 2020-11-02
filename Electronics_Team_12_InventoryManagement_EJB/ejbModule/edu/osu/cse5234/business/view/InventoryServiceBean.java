package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
public class InventoryServiceBean implements InventoryService {
	@PersistenceContext
	EntityManager entityManager;
	
	private String MY_QUERY = "Select i from Item i";		

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		Inventory inventory = new Inventory();
		List<Item> items = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		inventory.setItems(items);
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<LineItem> items) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}
