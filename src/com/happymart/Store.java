package com.happymart;

import java.util.Map;

public class Store {
	private static long uniqueIDs = 0;
	private long id;
	private String address;
	private String phone;
	private Map<Long,Employee> employees;
	
	public Store (String address, String phone) {
		this.id = uniqueIDs++;
		this.address = address;
		this.phone = phone;
	}
	public long getID() {
		return this.id;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getStoreInfo() {
		return this.address + "\n" + this.phone;
	}
	public Employee getEmployee (long id) {
		return this.employees.get(id);
	}
	public Employee[] getEmployees () {
		return (Employee[])this.employees.values().toArray();
	}
	public String toString() {
		return this.getStoreInfo();
	}
}
