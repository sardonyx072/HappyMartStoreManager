package com.happymart;

public class Message {
	private MessageType type;
	private String contents;
	
	public Message (MessageType type, String contents) {
		this.type = type;
		this.contents = contents;
	}
	public MessageType getType() {
		return this.type;
	}
	public String getMessage () {
		return this.contents;
	}
	public String toString() {
		return this.type + ":" + this.contents;
	}
}
