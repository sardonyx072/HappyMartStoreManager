package com.happymart.tests;

import static org.junit.Assert.*;

import com.happymart.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StoreTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetID() {
		
		Store test=new Store("summit ave", "123456");
	
		assertEquals(test.getID(),3);
	}

	@Test
	public void testGetAddress() {
		Store test=new Store("summit ave", "123456");
		assertEquals(test.getAddress(),"summit ave");
	}

	@Test
	public void testGetPhone() {
		Store test=new Store("summit ave", "123456");
		assertEquals(test.getPhone(),"123456");
	}

	@Test
	public void testGetStoreInfo() {
		Store test=new Store("summit ave", "123456");
		String excepted= "summit ave"+"\n"+"123456";
		assertEquals(test.getStoreInfo(),excepted);
	}

	@Test
	public void testGetEmployee() {
		Map<Long,Employee> employees = new HashMap<>();
		
		Employee employee=new Employee("Tom","Elva","Edison");
		
		employees.get(employee);

		
		
		Store test=new Store("summit ave", "123456");
		
		
	}


	@Test
	public void testGetEmployees() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Store test=new Store("summit ave", "123456");
		
		
		

		
		
	}

}
