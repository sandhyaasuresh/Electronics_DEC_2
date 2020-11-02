package edu.osu.cse5234.business.view;

public class LineItem {
	private int id;
	private int itemNumber;
	private String name;
	private double price;
	private int quantity;
	
	public LineItem() {
		this.id = 0;
		this.itemNumber = 0;
		this.name = null;
		this.price = 0;
		this.quantity = 0;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getItemNumber() {
		return itemNumber;
	}
	
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
