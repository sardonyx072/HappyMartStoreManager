package com.happymart;

import java.util.Vector;

public class RegisterReport extends Report {
	private Vector<Session> sessions;
	
	public RegisterReport (Vector<Session> sessions) throws IllegalArgumentException {
		this.sessions = sessions;
		
		long storeID = this.sessions.get(0).getStoreID();
		long registerID = this.sessions.get(0).getRegisterID();
		
		for (Session i : sessions) {
			if (storeID != i.getStoreID() || registerID != i.getRegisterID()) {
				throw new IllegalArgumentException("Mismatched store or register IDs in Register report generation!");
			}
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("Report for");
		builder.append(" store " + storeID);
		builder.append(" register " + registerID);
		builder.append('\n');
		builder.append("Generated on " + this.timestamp);
		builder.append('\n');
		for (Session i : this.sessions) {
			builder.append("\n" + i);
		}
		this.generatedReport = builder.toString();
	}
}
