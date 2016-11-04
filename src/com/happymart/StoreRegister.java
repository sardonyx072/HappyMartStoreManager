package com.happymart;

public class StoreRegister extends StoreTerminal {
	int moneyInDrawer;
	
	public StoreRegister (Store storeInfo, String serverIP) {
		super (storeInfo,serverIP);
		this.moneyInDrawer = 0;
	}

	@Override
	public void run() {
		int optLevel = 0;
		String[] opts0 = {"EXIT","log in"};
		int opt0 = 0;
		String[] opts1 = {"log out","check inventory","add item to checkout","remove item from checkout","add item to return","clear","manage drawer"};
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
