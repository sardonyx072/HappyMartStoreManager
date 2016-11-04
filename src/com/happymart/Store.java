package com.happymart;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Store implements Serializable {
	private static long uniqueIDs = 0;
	private long id;
	private String address;
	private String phone;
	private Map<Long,Employee> employees;
	
	public Store (String address, String phone) {
		this.id = uniqueIDs++;
		this.address = address;
		this.phone = phone;
		this.employees = new HashMap<Long,Employee>();
		Employee e1 = new Employee("Jiashu","Li");
		Employee e2 = new Employee("Mitchell","Jeffrey","Hoffmann");
		Employee e3 = new Employee("Chetan","Vasuvedan");
		Employee e4 = new Employee("Sohana","Badhon");
		this.employees.put(e1.getId(), e1);
		this.employees.put(e2.getId(), e2);
		this.employees.put(e3.getId(), e3);
		this.employees.put(e4.getId(), e4);
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
	public Collection<Employee> getEmployees () {
		return this.employees.values();
	}
	public String toString() {
		return this.getStoreInfo();
	}
}
