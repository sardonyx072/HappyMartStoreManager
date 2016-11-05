package com.happymart.tests;

import static org.junit.Assert.*;

import com.happymart.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SessionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSessionOpenTimestamp() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Session test=new Session(1, 1, emp.toString() );
		 Date excepted=new Date();
		assertEquals(test.getSessionOpenTimestamp(),excepted);
	}

	@Test
	public void testGetStoreID() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Session test=new Session(1, 1, emp.toString() );
		assertEquals(test.getStoreID(),1);
	}

	@Test
	public void testGetRegisterID() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Session test=new Session(1, 1, emp.toString() );
		assertEquals(test.getRegisterID(),1);
	}

	@Test
	public void testGetEmployee() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Session test=new Session(1, 1, emp.toString() );
		assertEquals(test.getEmployee(),emp.toString());
	}

	@Test
	public void testGetActivity() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Session test=new Session(1, 1, emp.toString() );
		
	}

	@Test
	public void testAddActivity() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Session test=new Session(1, 1, emp.toString() );
		
		
	}

	@Test
	public void testCloseSession() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Session test=new Session(1, 1, emp.toString() );
		 
	}

	@Test
	public void testGetSessionCloseTimestamp() {
		Employee emp=new Employee("Tom","Elva","Edison");
		Session test=new Session(1, 1, emp.toString() );
		 
		 Date excepted=new Date();
		
	}

}
