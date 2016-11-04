package com.happymart.tests;

import static org.junit.Assert.*;

import com.happymart.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemStockTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetType() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock test=new ItemStock(type, 1, 0);
		assertEquals(test.getType(),type);
		
	}

	@Test
	public void testGetQuantity() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock test=new ItemStock(type, 1, 0);
		assertEquals(test.getQuantity(),1);
	}

	@Test
	public void testAddQuantity() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock test=new ItemStock(type, 1, 0);
		test.addQuantity(2);
		assertEquals(test.getQuantity(),2+1);
	}

	@Test
	public void testRemoveQuantity() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock test=new ItemStock(type, 1, 0);
		test.removeQuantity(1);
		assertEquals(test.getQuantity(),0);
	}

	@Test
	public void testGetMinimumQuantity() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock test=new ItemStock(type, 1, 0);
		assertEquals(test.getMinimumQuantity(),0);
	}

	@Test
	public void testSetMinimumQuantity() {
		ItemType type=new ItemType("bread","unit","general mills","food",122);
		ItemStock test=new ItemStock(type, 10, 1);
		test.setMinimumQuantity(5);
		assertEquals(test.getMinimumQuantity(),5);
	}

}
