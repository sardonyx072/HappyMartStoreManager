package com.happymart;

public enum MessageType {
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
