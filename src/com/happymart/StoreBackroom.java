package com.happymart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoreBackroom {
	private Map<Long,ItemStock> inventory;
	private Map<Long,Integer> orders;
	
	public StoreBackroom (HashMap<Long,ItemStock> inventory) {
		this.inventory = inventory;
		this.orders = new HashMap<Long,Integer>();
	}
	public Map<ItemType,Integer> getItemTypeAndQuantityList () {
		Map<ItemType,Integer> itemTypeAndQuantityList = new HashMap<ItemType,Integer>();
		Set<Long> keys = this.inventory.keySet();
		for (Long key : keys) {
			ItemStock item = this.inventory.get(key);
			itemTypeAndQuantityList.put(item.getType(), item.getQuantity());
		}
		return itemTypeAndQuantityList;
	}
	public int checkQuantityOf (ItemType type) {
		if (this.inventory.containsKey(type.getID())) {
			return this.inventory.get(type).getQuantity();
		}
		else {
			return 0;
		}
	}
	public void add (ItemType type, int quantity) {
		if (this.inventory.containsKey(type.getID())) {
			this.inventory.get(type.getID()).addQuantity(quantity);
		}
		else {
			this.inventory.put(type.getID(), new ItemStock(type,quantity,Integer.MAX_VALUE));
		}
	}
	public void remove (ItemType type, int quantity) {
		this.inventory.get(type.getID()).removeQuantity(quantity);
	}
	public void setMinimumThreshold (ItemType type, int quantity) {
		this.inventory.get(type.getID()).setMinimumQuantity(quantity);
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
