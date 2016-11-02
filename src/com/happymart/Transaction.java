package com.happymart;

import java.util.Date;
import java.util.Map;

public class Transaction {
	private static long uniqueIDs = 0;
	private long id;
	private long[] referencedIDs;
	private String employee;
	private Map <ItemType,Integer> purchasedItems;
	private int purchasedSubtotal;
	private Map <ItemType,Integer> returnedItems;
	private int returnedSubtotal;
	private int total;
	private PaymentType paymentType;
	private String paymentString;
	private Date timestamp;
	
	public Transaction (long[] referencedIDs, String employee, Map<ItemType,Integer> purchasedItems, Map<ItemType,Integer> returnedItems, PaymentType type, String paymentString) {
		this.id = this.uniqueIDs++;
		this.referencedIDs = referencedIDs;
		this.employee = employee;
		this.purchasedItems = purchasedItems;
		this.purchasedSubtotal = 0;
		for (ItemType key : purchasedItems.keySet()) {
			this.purchasedSubtotal += purchasedItems.get(key).intValue();
		}
		this.returnedItems = returnedItems;
		for (ItemType key : returnedItems.keySet()) {
			this.returnedSubtotal += returnedItems.get(key).intValue();
		}
		this.total = this.purchasedSubtotal - this.returnedSubtotal;
		this.paymentType = type;
		this.paymentString = paymentString;
		this.timestamp = new Date();
	}
	public long getID() {
		return this.id;
	}
	public long[] getReferencedIDs() {
		return this.referencedIDs;
	}
	public String getEmployee() {
		return this.employee;
	}
	public Map<ItemType,Integer> getPurchasedItems() {
		return this.purchasedItems;
	}
	public int getPurchasedSubtotal() {
		return this.purchasedSubtotal;
	}
	public Map<ItemType,Integer> getReturnedItems() {
		return this.returnedItems;
	}
	public int getReturnedSubtotal() {
		return this.returnedSubtotal;
	}
	public int getTotal() {
		return this.total;
	}
	public PaymentType getPaymentType() {
		return this.paymentType;
	}
	public String getPaymentString() {
		return this.paymentString;
	}
	public Date getDateTimestamp() {
		return this.timestamp;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction completed: " + this.getDateTimestamp());
		builder.append('\n');
		builder.append(" Cashier: " + this.employee);
		builder.append('\n');
		if (this.getReferencedIDs().length > 0) {
			builder.append(" Referenced receipt numbers:");
			for (long x : this.getReferencedIDs()) {
				builder.append('\n');
				builder.append(x);
			}
		}
		builder.append('\n');
		builder.append("--------");
		builder.append('\n');
		builder.append(" Purchased:");
		for (ItemType key : this.getPurchasedItems().keySet()) {
			builder.append('\n');
			builder.append("  " + (this.getPurchasedItems().get(key).intValue() * key.getPricePerUnitInUSCents()) + " = " + this.getPurchasedItems().get(key).intValue() + " x " + key);
		}
		if (!this.getReturnedItems().keySet().isEmpty()) {
			builder.append('\n');
			builder.append(" " + this.getPurchasedSubtotal());
			builder.append('\n');
			builder.append("--------");
			builder.append('\n');
			for (ItemType key : this.getReturnedItems().keySet()) {
				builder.append('\n');
				builder.append("  " + (this.getReturnedItems().get(key).intValue() * key.getPricePerUnitInUSCents()) + " = " + this.getReturnedItems().get(key).intValue() + " x " + key);
			}
			builder.append('\n');
			builder.append(" " + this.getReturnedSubtotal());
			builder.append('\n');
			builder.append("--------");
		}
		builder.append('\n');
		builder.append(" " + this.getTotal() + " TOTAL");
		builder.append('\n');
		builder.append("Paid with " + this.getPaymentType() + ": " + this.getPaymentString());
		return builder.toString();
	}
}
