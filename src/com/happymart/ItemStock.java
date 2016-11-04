package com.happymart;

public class ItemStock {
	private ItemType type;
	private int quantity;
	private int minimumQuantity;
	
	public ItemStock(ItemType type, int quantity, int minimumQuantity) {
		this.type = type;
		this.quantity = quantity;
		this.minimumQuantity = minimumQuantity;
	}
	public ItemType getType() {
		return type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	public boolean removeQuantity(int quantity) {
		this.quantity -= quantity;
		return this.quantity < this.minimumQuantity;
	}
	public int getMinimumQuantity() {
		return this.minimumQuantity;
	}
	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}
}
