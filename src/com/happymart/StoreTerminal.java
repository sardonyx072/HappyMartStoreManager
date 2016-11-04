package com.happymart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class StoreTerminal {
	private String serverIP;
	
	public Message sendCommand (Message message) {
		Message response = new Message(MessageType.FailResponse,"Socket Connection Failure");
		try {
			Socket connection = new Socket(serverIP,9876);
			BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			BufferedReader inStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			outStream.write(message.toString());
			StringBuilder inBuilder = new StringBuilder();
			while (inStream.ready()) {
				inBuilder.append('\n' + inStream.readLine());
			}
			String inMessage = inBuilder.toString();
			MessageType type = MessageType.valueOf(MessageType.class, inMessage.substring(0,inMessage.indexOf(':')));
			String contents = inMessage.substring(inMessage.indexOf(':')+1);
			response = new Message(type,contents);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}
