package com.happymart;

import java.io.Serializable;

public enum MessageType implements Serializable {
	Ping, //String(test string)
	CheckCredentials, //String(user::pass)
	OpenSession, //String(employee name)
	GetItemQuantity, //Long(id)
	GetInventory, //String(search)
	Purchase, //Map<ItemType,Integer>(list)
	Return, //Map<ItemType,Integer>(list)
	UpdateSession, //Activity
	GenerateReport, //?
	CloseSession, //String(employee name)
	OkResponse, 
	FailResponse;
}
