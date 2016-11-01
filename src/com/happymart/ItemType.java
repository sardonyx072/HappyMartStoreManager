package com.happymart;

public class ItemType {
	private static long uniqueItems;
	private long id;
	private String name;
	private String unitName;
	private String originalManufacturerOrSupplierName;
	private String description;
	private int pricePerUnitInUSCents;
	
	public ItemType (String name, String unitName, String originalManufacturerOrSupplierName, String description, int pricePerUnitInUSCents) {
		this.id = uniqueItems++;
		this.name = name;
		this.unitName = unitName;
		this.originalManufacturerOrSupplierName = originalManufacturerOrSupplierName;
		this.description = description;
		this.pricePerUnitInUSCents = pricePerUnitInUSCents;
	}
	public long getID () {
		return this.id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getOriginalManufacturerOrSupplierName() {
		return originalManufacturerOrSupplierName;
	}
	public void setOriginalManufacturerOrSupplierName(String originalManufacturerOrSupplierName) {
		this.originalManufacturerOrSupplierName = originalManufacturerOrSupplierName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPricePerUnitInUSCents() {
		return pricePerUnitInUSCents;
	}
	public void setPricePerUnitInUSCents(int pricePerUnitInUSCents) {
		this.pricePerUnitInUSCents = pricePerUnitInUSCents;
	}
	
}
