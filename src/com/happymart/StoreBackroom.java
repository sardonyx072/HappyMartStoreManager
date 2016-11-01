package com.happymart;

import java.util.HashMap;
import java.util.Map;

public class StoreBackroom {
	private Map<Long,int[]> inventory;
	private Map<Long,Integer> orders;
	
	public StoreBackroom (HashMap<Long,int[]> inventory) {
		this.inventory = inventory;
		this.orders = new HashMap<Long,Integer>();
	}
	public void add (ItemType type, int quantity) {
		if (this.inventory.containsKey(type.getID())) {
			this.inventory.get(type.getID())[0] += quantity;
		}
		else {
			this.inventory.put(type.getID(), new int[] {0, Integer.MAX_VALUE});
		}
	}
	public void remove (ItemType type, int quantity) {
		this.inventory.get(type.getID())[0] -= quantity;
		if (this.inventory.get(type.getID())[0] < this.inventory.get(type.getID())[1]) {
			if (!this.orders.containsKey(type.getID())) {
				this.orders.put(type.getID(), this.inventory.get(type.getID())[1]);
			}
		}
	}
	public void setMinimumThreshold (ItemType type, int quantity) {
		this.inventory.get(type.getID())[1] = quantity;
	}
	public void addToOrder (ItemType type, int quantity) {
		if (this.orders.containsKey(type.getID())) {
			this.orders.put(type.getID(), this.orders.get(type.getID()).intValue()+quantity);
		}
		else {
			this.orders.put(type.getID(), quantity);
		}
	}
	public void removeFromOrder (ItemType type, int quantity) {
		this.orders.put(type.getID(), this.orders.get(type.getID()).intValue()-quantity);
	}
	public Map<Long,Integer> getNightlyOrder () {
		return this.orders;
	}
}
