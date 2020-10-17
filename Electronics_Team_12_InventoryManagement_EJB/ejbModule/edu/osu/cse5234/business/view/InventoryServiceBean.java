package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import edu.osu.cse5234.model.Item;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		Inventory inventory = new Inventory();
		Item item1 = new Item("OnePlus 7T", "699.99", "0");
		Item item2 = new Item("Dell xps 13in", "1349.99", "0");
		Item item3 = new Item("Samsung s20", "999.99", "0");
		Item item4 = new Item("Pixel 5", "729.99", "0");
		Item item5 = new Item("Lenovo Thinkpad", "1499.99", "0");
		
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		
		inventory.setItems(items);
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}
