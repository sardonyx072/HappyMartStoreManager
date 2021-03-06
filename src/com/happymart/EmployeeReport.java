package com.happymart;

import java.util.Vector;

public class EmployeeReport extends Report {
	private Vector<Session> sessions;
	
	public EmployeeReport (Vector<Session> sessions) {
		this.sessions = sessions;
		
		long storeID = this.sessions.get(0).getStoreID();
		String employee = this.sessions.get(0).getEmployee();

		for (Session i : sessions) {
			if (storeID != i.getStoreID() || !employee.equals(i.getEmployee())) {
				throw new IllegalArgumentException("Mismatched store or employee ID in Employee report generation!");
			}
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("Report for");
		builder.append(" store " + storeID);
		builder.append(" for " + employee);
		builder.append('\n');
		builder.append("Generated on " + this.timestamp);
		builder.append('\n');
		for (Session i : this.sessions) {
			builder.append("\n" + i);
		}
		this.generatedReport = builder.toString();
	}
}
