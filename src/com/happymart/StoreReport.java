package com.happymart;

import java.util.Vector;

public class StoreReport extends Report {
	private Vector<Session> sessions;
	
	public StoreReport (Vector<Session> sessions) {
		this.sessions = sessions;
		
		long storeID = this.sessions.get(0).getStoreID();

		for (Session i : sessions) {
			if (storeID != i.getStoreID()) {
				throw new IllegalArgumentException("Mismatched store ID in Employee report generation!");
			}
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("Report for");
		builder.append(" store " + storeID);
		builder.append('\n');
		builder.append("Generated on " + this.timestamp);
		builder.append('\n');
		for (Session i : this.sessions) {
			builder.append("\n" + i);
		}
		this.generatedReport = builder.toString();
	}
}
