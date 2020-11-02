package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.business.view.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	@PersistenceContext
	EntityManager entityManager;
	
	private InventoryService inventoryService;

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
    	inventoryService = ServiceLocator.getInventoryService();
    }
    
    public String processOrder(Order order) {
    	entityManager.persist(order);
    	entityManager.flush();
    	
    	return "";
    }
    
    public boolean validateItemAvailability(Order order) {
    	Inventory inventory = inventoryService.getAvailableInventory();
    	boolean isAvailable = true;
    	for (LineItem item : order.getItems()) {
    		Item inventoryItem = inventory.getItems().stream().filter(i -> item.getId() == i.getID()).findFirst().get();
    		if (inventoryItem.getQuantity() < item.getQuantity()) {
    			isAvailable = false;
    			break;
    		}
    	}
    	
    	return isAvailable;
    }

}
