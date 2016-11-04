package com.happymart.tests;

import static org.junit.Assert.*;

import com.happymart.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StoreBackroomTest {
     StoreBackroom test=new StoreBackroom(null);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetItemTypeAndQuantityList() {
		
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock stock=new ItemStock(type, 1, 0);
		HashMap<Long,ItemStock> inventory=new HashMap<Long,ItemStock>();
		inventory.put(type.getID(), stock);
		StoreBackroom test=new StoreBackroom(inventory);
		HashMap<Long, ItemStock> item = new HashMap<Long,ItemStock>();
		item.put( (long) 2,stock);
		StoreBackroom expected=new StoreBackroom(item);
		
		assertEquals(test.getItemTypeAndQuantityList(),expected.getItemTypeAndQuantityList());
	}

	@Test
	public void testAdd() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock stock=new ItemStock(type, 1, 0);
		HashMap<Long,ItemStock> inventory=new HashMap<Long,ItemStock>();
		inventory.put(type.getID(), stock);
		StoreBackroom test=new StoreBackroom(inventory);
		test.add(type,2);
		assertEquals(stock.getQuantity(),3);
	}

	@Test
	public void testRemove() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock stock=new ItemStock(type, 2, 0);
		HashMap<Long,ItemStock> inventory=new HashMap<Long,ItemStock>();
		inventory.put(type.getID(), stock);
		StoreBackroom test=new StoreBackroom(inventory);
		test.remove(type, 1);
		assertEquals(stock.getQuantity(),1);
	}

	@Test
	public void testSetMinimumThreshold() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock stock=new ItemStock(type, 2, 0);
		HashMap<Long,ItemStock> inventory=new HashMap<Long,ItemStock>();
		inventory.put(type.getID(), stock);
		StoreBackroom test=new StoreBackroom(inventory);
		test.setMinimumThreshold(type, 5);
		assertEquals(stock.getMinimumQuantity(),5);
	}

	@Test
	public void testAddToOrder() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock stock=new ItemStock(type, 5, 6);
		HashMap<Long,ItemStock> inventory=new HashMap<>();
		inventory.put(type.getID(), stock);
		//boolean expected=inventory.containsKey(type.getID());
		boolean actual=inventory.containsKey(type.getID());
		assertEquals(true,actual);
				
	}

}
