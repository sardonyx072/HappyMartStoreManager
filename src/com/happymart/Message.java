package com.happymart;

import java.io.Serializable;

public class Message<T> implements Serializable {
	private MessageType type;
	private T content;
	
	public Message (MessageType type, T content) {
		this.type = type;
		this.content = content;
	}
	public MessageType getType() {
		return this.type;
	}
	public T getMessage () {
		return this.content;
	}
	public String toString() {
		return this.type + "\n" + this.content;
	}
}
