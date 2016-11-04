package com.happymart;

import java.io.Serializable;

public class Employee implements Serializable {
	private static long uniqueIDs = 0;
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String username;
	private String password;
	
	public Employee(String firstName, String middleName, String lastName){
		this.id = uniqueIDs++;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.username = lastName.substring(0, Math.min(4, lastName.length())) + this.id;
		this.password = "password";
	}
    public Employee(String firstName, String lastName){
    	this(firstName, "", lastName);
	}
	public long getId() {
		return id;
	}
    public String getFirstName(){
    	return firstName;
    }
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passWord) {
			this.password = passWord;
	}
    public String toString (){
		return this.firstName + " " + this.middleName + " " + this.lastName;
    }
}
