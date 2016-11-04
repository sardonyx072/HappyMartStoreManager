package com.happymart;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class StoreServer implements Runnable {
	private Store storeInfo;
	private StoreBackroom backroom;
	private final String fileSystemPath = "C:\\HappyMart";
	private Map<Long,Session> openSessions;
	
	public StoreServer (Store storeInfo) {
		this.storeInfo = storeInfo;
		try {
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(fileSystemPath+"\\back.hmsb"));
			this.backroom = (StoreBackroom)inStream.readObject();
			this.backroom.add(new ItemType("Book","book","Pelican Books","",1999), 16);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		openSessions = new HashMap<Long,Session>();
		System.out.println("Awaiting connections...");
	}
	
	@SuppressWarnings("unchecked")
	private Message<?> handle(Message<?> message) {
		switch (message.getType()) {
		case Ping:
			return new Message<String>(MessageType.OkResponse,new String("Hello, and welcome to Happy Mart!"));
		case CheckCredentials:
			String raw = (String)message.getMessage();
			String username = raw.substring(0, raw.indexOf("::")), password = raw.substring(raw.indexOf("::")+2);
			for (Employee employee : this.storeInfo.getEmployees()) {
				if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
					return new Message<Long>(MessageType.OkResponse,employee.getId());
				}
			}
			return new Message<String>(MessageType.FailResponse,new String("Username or password incorrect"));
		case OpenSession:
			this.openSessions.put(((Session)message.getMessage()).getID(), (Session)message.getMessage());
			return new Message<String>(MessageType.OkResponse,new String("Success"));
		case CloseSession:
			long id = ((Session)message.getMessage()).getID();
			this.openSessions.get(id).closeSession();
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileSystemPath + "\\" + id));
				writer.write(this.openSessions.get(id).toString());
				writer.close();
				this.openSessions.remove(id);
			} catch (IOException e) {
				return new Message<String>(MessageType.FailResponse,new String("Failure to write session to file"));
			}
			return new Message<String>(MessageType.OkResponse,new String("Success"));
		case GetItemQuantity:
			return new Message<Integer>(MessageType.OkResponse,this.backroom.checkQuantityOf((ItemType)message.getMessage()));
		case GetInventory:
			return new Message<Map<ItemType,Integer>>(MessageType.OkResponse,this.backroom.getItemTypeAndQuantityList());
		case Purchase:
			String notEnoughOf = "";
			Map<ItemType,Integer> purchasedItems = (HashMap<ItemType,Integer>)message.getMessage();
			for (ItemType key : purchasedItems.keySet()) {
				if (this.backroom.checkQuantityOf(key) < purchasedItems.get(key)) {
					notEnoughOf += "\nNot enough of item " + key + " (only " + this.backroom.checkQuantityOf(key) + " in stock!)";
				}
			}
			if (notEnoughOf.length() == 0) {
				for (ItemType key : purchasedItems.keySet()) {
					this.backroom.remove(key, purchasedItems.get(key).intValue());
				}
				return new Message<String>(MessageType.OkResponse,"Success");
			}
			else {
				return new Message<String>(MessageType.FailResponse,notEnoughOf);
			}
		case Return:
			Map<ItemType,Integer> returnedItems = (HashMap<ItemType,Integer>)message.getMessage();
			for (ItemType key : returnedItems.keySet()) {
				this.backroom.add(key, returnedItems.get(key));
			}
			return new Message<String>(MessageType.OkResponse,new String("Success"));
		case UpdateSession:
			Session updatedSession = (Session)message.getMessage();
			this.openSessions.put(updatedSession.getID(), updatedSession);
			return new Message<String>(MessageType.OkResponse,new String("Success"));
		case GenerateReport:
			//TODO
			return new Message<String>(MessageType.FailResponse,new String("Failure to recognize message"));
		default:
			return new Message<String>(MessageType.FailResponse,new String("Failure to recognize message"));
		}
	}
	
	@Override
	public void run () {
		try {
			ServerSocket server = new ServerSocket(9874);
			server.getReuseAddress();
			while (true) {
				Socket connection = server.accept();
				ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream());
				ObjectOutputStream outStream = new ObjectOutputStream(connection.getOutputStream());
				outStream.writeObject(this.handle((Message<?>)inStream.readObject()));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
