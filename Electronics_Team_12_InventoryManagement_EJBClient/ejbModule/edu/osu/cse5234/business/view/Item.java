package edu.osu.cse5234.model;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String price;
	private String quantity;
	
	public Item() {
		this.name = "";
		this.price = "";
		this.quantity = "";
	}
	
	public Item(String name, String price, String quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}