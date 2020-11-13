package edu.osu.cse5234.business;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class)
public class OrderProcessingServiceBean {
	@PersistenceContext
	EntityManager entityManager;
	
	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;

	@Resource(lookup="jms/emailQ")
	private Queue queue;

	
	private InventoryService inventoryService;
	private String customerEmail = "xyz@gmail.com";

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
    	inventoryService = ServiceLocator.getInventoryService();
    }
    
    public String processOrder(Order order) {
    	this.customerEmail = order.getEmailAddress();
    	notifyUser();
    	entityManager.persist(order);
    	entityManager.flush();
    	
    	return "AAOO12F67";
    }
    
    public boolean validateItemAvailability(Order order) {
    	System.out.print("Hi");
    	Inventory inventory = inventoryService.getAvailableInventory();
    	boolean isAvailable = true;
    	for (LineItem item : order.getItems()) {
    		Item inventoryItem = inventory.getItems().stream().filter(i -> item.getItemNumber() == i.getItemNumber()).findFirst().get();
    		if (inventoryItem.getQuantity() < item.getQuantity()) {
    			isAvailable = false;
    			break;
    		}
    	}
    	
    	return isAvailable;
    }
    
    private void notifyUser() {

    	String message = customerEmail + ":" +
    	       "Your order was successfully submitted. " + 
    	     	"You will hear from us when items are shipped. " + 
    	      	new Date();

    	System.out.println("Sending message: " + message);
    	jmsContext.createProducer().send(queue, message);
    	System.out.println("Message Sent!");
    	}


}
