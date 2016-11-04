package com.happymart;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class Session implements Serializable {
	private static long uniqueIDs = 0;
	private long id;
	private Date sessionOpenTimestamp;
	private long storeID;
	private long registerID;
	private String employee;
	private boolean sessionOpen;
	private Vector<Activity> activity;
	private Date sessionCloseTimestamp;
	
	public Session (long storeID, long registerID, String employee) {
		this.id = uniqueIDs++;
		this.sessionOpenTimestamp = new Date();
		this.storeID = storeID;
		this.registerID = registerID;
		this.employee = employee;
		this.sessionOpen = true;
		this.activity = new Vector<Activity>();
	}
	public long getID() {
		return this.id;
	}
	public Date getSessionOpenTimestamp() {
		return this.sessionOpenTimestamp;
	}
	public long getStoreID() {
		return this.storeID;
	}
	public long getRegisterID() {
		return this.registerID;
	}
	public String getEmployee() {
		return this.employee;
	}
	public Vector<Activity> getActivity() {
		return this.activity;
	}
	public void addActivity(Activity activity) throws IllegalAccessException {
		if (this.sessionOpen) {
			this.activity.add(activity);
		}
		else {
			throw new IllegalAccessException("Cannot modify closed session!");
		}
	}
	public void closeSession() {
		this.sessionOpen = false;
		this.sessionCloseTimestamp = new Date();
	}
	public Date getSessionCloseTimestamp() {
		return this.sessionCloseTimestamp;
	}
	public String toString() {
		//TODO: printout
		return null;
	}
}
