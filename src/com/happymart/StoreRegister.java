package com.happymart;

import java.util.HashMap;
import java.util.Map;

public class StoreRegister extends StoreTerminal {
	private int moneyInDrawer;
	private Map<ItemType,Integer> runningSale;
	private Map<ItemType,Integer> runningReturn;
	
	public StoreRegister (Store storeInfo, String serverIP) {
		super (storeInfo,serverIP);
		this.moneyInDrawer = 0;
		this.runningSale = new HashMap<ItemType,Integer>();
		this.runningReturn = new HashMap<ItemType,Integer>();
	}

	@Override
	public void run() {
		int optLevel = 0;
		String[] opts0 = {"EXIT","log in"};
		int opt0 = 0;
		String[] opts1 = {"log out","check inventory","add item to sale","remove item from sale","add item to return","clear","manage drawer"};
		int opt1 = 0;
		do {
			switch (optLevel) {
			case 0: //base
				opt0 = getInputFromOptions("Welcome to the Happy Mart Store Manager!\nWhat would you like to do?", opts0);
				switch (opt0) {
				case 0: //exit
					break;
				case 1: //log in
					this.loginLoop();
					optLevel = 1;
					break;
				default:
					System.out.println("Invalid response.");
				}
				break;
			case 1: //logged in
				opt1 = getInputFromOptions("Hello, " + this.openSession.getEmployee() + ". What would you like to do?", opts1);
				switch (opt1) {
				case 0: //log out
					this.sendCommand(new Message<Session>(MessageType.CloseSession,this.openSession));
					optLevel = 0;
					break;
				case 1: //check inventory
					System.out.println(this.sendCommand(new Message<String>(MessageType.GetInventory,"")));
					break;
				case 2: //add item to sale
					System.out.println("Scan item: ");
					
					break;
				case 3: //remove item from sale
					break;
				case 4: //add item to return
					break;
				case 6: //clear
					break;
				case 7: //manage drawer
					System.out.println("Money in drawer: " + this.moneyInDrawer);
					break;
				default:
					System.out.println("Invalid response.");
				}
				break;
			}
		} while (opt0 != 0);
	}	
}
