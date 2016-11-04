package com.happymart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class StoreServer implements Runnable {
	private StoreBackroom backroom;
	
	public StoreServer (long storeID) {
		//load store from file by storeID and build backroom
		//display own local ip
	}
	
	public void run () {
		try {
			ServerSocket server = new ServerSocket(9876);
			while (true) {
				Socket connection = server.accept();
				BufferedReader inStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
				StringBuilder inBuilder = new StringBuilder();
				while (inStream.ready()) {
					inBuilder.append('\n' + inStream.readLine());
				}
				String inMessage = inBuilder.toString();
				MessageType type = MessageType.valueOf(MessageType.class, inMessage.substring(0,inMessage.indexOf(':')));
				String contents = inMessage.substring(inMessage.indexOf(':')+1);
				Message outMessage = this.handle(type, contents);
				outStream.write(outMessage.toString());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Message handle(MessageType inType, String inContents) {
		MessageType outType = null;
		String outContents = null;
		//process
		return new Message(outType, outContents);
	}
}
