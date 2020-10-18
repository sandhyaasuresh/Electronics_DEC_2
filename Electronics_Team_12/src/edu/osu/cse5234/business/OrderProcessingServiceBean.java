package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	private InventoryService inventoryService;

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
    	inventoryService = ServiceLocator.getInventoryService();
    }
    
    public String processOrder(Order order) {	
    	return "";
    }
    
    public boolean validateItemAvailability(Order order) {
    	return inventoryService.validateQuantity(order.getItems());
    }

}
