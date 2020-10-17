package edu.osu.cse5234.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Item> items;
	
	public Order() {
		items = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public List<Item> addItem(Item item) {
		this.items.add(item);
		
		return this.items;
	}
	
	public List<Item> removeItem(int index) {
		this.items.remove(index);
		
		return this.items;
	}
}