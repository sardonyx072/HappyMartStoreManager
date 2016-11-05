package com.happymart.tests;

import static org.junit.Assert.*;

import com.happymart.*;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransactionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetReferencedIDs() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployee() {
		//Employee emp=new Employee("Tom","Elva","Edison");
		//Store store=new Store("summit ave", "123456");
		//Transaction test=new Transaction(store.getID(), store.getStoreInfo(), 0, emp.toString(), null, null, null, null);
		Transaction test=new Transaction(null, null, 0, null, null, null, null, null);
		
		assertEquals(test.getID(),null); 
		
	}

	@Test
	public void testGetPurchasedItems() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPurchasedSubtotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReturnedItems() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReturnedSubtotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPaymentType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPaymentString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDateTimestamp() {
		fail("Not yet implemented");
	}

}
