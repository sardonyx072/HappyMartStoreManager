package com.happymart;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class StoreTerminal implements Runnable {
	private static long uniqueIDs = 0;
	protected long id;
	protected Store storeInfo;
	protected String serverIP;
	protected Session openSession;
	protected Scanner scan;
	
	public StoreTerminal (Store storeInfo, String serverIP) {
		this.id = uniqueIDs++;
		this.storeInfo = storeInfo;
		this.serverIP = serverIP;
		this.scan = new Scanner(System.in);
	}
	
	protected boolean openSession (String employee) {
		if (this.openSession == null) {
			this.openSession = new Session(this.storeInfo.getID(),this.id,employee);
			return true;
		}
		else {
			return false;
		}
	}
	protected Message<?> sendCommand (Message<?> message) {
		try {
			Socket connection = new Socket(serverIP,9874);
			ObjectOutputStream outStream = new ObjectOutputStream(connection.getOutputStream());
			ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream());
			outStream.writeObject(message);
			Message<?> response = (Message<?>)inStream.readObject();
			return response;
		}
		catch (IOException e) {
			return new Message<String>(MessageType.FailResponse,"Socket Connection Failure");
		}
		catch (ClassNotFoundException e) {
			return new Message<String>(MessageType.FailResponse,"Socket Connection Failure");
		}
	}
	protected int getInputFromOptions (String prompt, String[] opts) {
		System.out.println(prompt);
		for (int i = 0; i < opts.length; i++) {
			System.out.println(i + ": " + opts[i]);
		}
		try {
			return Integer.parseInt(scan.nextLine());
		}
		catch (Exception e) {
			return -1;
		}
	}
	protected boolean loginLoop() {
		boolean found = false;
		int lockoutCounter = 0;
		final int lockoutThreshold = 5;
		while (!found) {
			System.out.println("Please enter username: ");
			String user = scan.nextLine();
			System.out.println("Please enter password: ");
			String pass = scan.nextLine();
			Message<?> message = this.sendCommand(new Message<String>(MessageType.CheckCredentials,user+"::"+pass));
			if (message.getType() == MessageType.OkResponse) {
				this.openSession = new Session(this.storeInfo.getID(),this.id,user);
				this.sendCommand(new Message<Session>(MessageType.OpenSession,this.openSession));
				lockoutCounter = 0;
			}
			else {
				lockoutCounter++;
				if (lockoutCounter == lockoutThreshold) {
					System.out.println("Maximum login attempts reached. Please see system administrator.");
					while(true); //TODO: actual lockout
				}
			}
		}
		return true; //TODO: allow quitting
	}

	@Override
	public void run() {
		int optLevel = 0;
		String[] opts0 = {"EXIT","log in"};
		int opt0 = 0;
		String[] opts1 = {"log out","check inventory"};
		int opt1 = 0;
		do {
			switch (optLevel) {
			case 0:
				opt0 = getInputFromOptions("Welcome to the Happy Mart Store Manager!\nWhat would you like to do?", opts0);
				switch (opt0) {
				case 0:
					break;
				case 1:
					this.loginLoop();
					optLevel = 1;
					break;
				default:
					System.out.println("Invalid response.");
				}
				break;
			case 1:
				opt1 = getInputFromOptions("Hello, " + this.openSession.getEmployee() + ". What would you like to do?", opts1);
				switch (opt1) {
				case 0:
					this.sendCommand(new Message<Session>(MessageType.CloseSession,this.openSession));
					break;
				case 1:
					System.out.println(this.sendCommand(new Message<String>(MessageType.GetInventory,"")));
					break;
				}
				break;
			}
		} while (opt0 != 0);
	}
}
