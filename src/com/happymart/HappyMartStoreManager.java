package com.happymart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HappyMartStoreManager {
	
	public static void main (String[] args) {
		ObjectInputStream inStoreStream;
		try {
			inStoreStream = new ObjectInputStream(new FileInputStream("C:\\HappyMart\\store.hmsi"));
			Store storeInfo = (Store)inStoreStream.readObject();
			
			boolean validIPEntered = false;
			while (!validIPEntered) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter server IP or press [Enter] to start server: ");
				String inIP = scan.nextLine();
				if (inIP.length() == 0) {
					new Thread(new StoreServer(storeInfo)).start();
					validIPEntered = true;
				}
				else {
					try {
						Socket connection = new Socket(inIP,9876);
						ObjectOutputStream outStream = new ObjectOutputStream(connection.getOutputStream());
						ObjectInputStream inStream = new ObjectInputStream(connection.getInputStream());
						outStream.writeObject(new Message<String>(MessageType.Ping,"Hello"));
						Message<?> response = (Message<?>)inStream.readObject();
						if (response.getType() == MessageType.OkResponse) {
							boolean validAnswer = false;
							while (!validAnswer) {
								System.out.println("Terminal(0) or Register(1)?");
								try {
									int i = Integer.parseInt(scan.nextLine());
									if (i == 0) {
										new Thread(new StoreTerminal(storeInfo,inIP)).start();
										validAnswer = true;
									}
									else if (i == 1) {
										new Thread(new StoreRegister(storeInfo,inIP)).start();
										validAnswer = true;
									}
									else {
										System.out.println("invalid response");
									}
								}
								catch (Exception e) {
									System.out.println("invalid response");
								}
							}
						}
					}
					catch (IOException e) {
						System.out.println("invalid ip");
					}
					catch (ClassNotFoundException e) {
						System.out.println("error with install");
					}
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public static void main (String[] args) {
		Store store = new Store("1234 Sunny Lane\nAnywhere BH, 12345","012-345-6789");
		StoreBackroom back = new StoreBackroom(new HashMap<Long,ItemStock>());
		try {
			File f1 = new File("C:\\HappyMart\\store.hmsi");
			File f2 = new File("C:\\HappyMart\\back.hmsb");
			f1.createNewFile();
			f2.createNewFile();
			ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(f1));
			oos1.writeObject(store);
			oos1.close();
			ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(f2));
			oos2.writeObject(back);
			oos2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
