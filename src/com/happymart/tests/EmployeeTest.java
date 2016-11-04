package com.happymart.tests;

import static org.junit.Assert.*;

import com.happymart.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
     
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetId() {
		Employee test=new Employee("Tom","Elva","Edison");
	    assertEquals(test.getId(),1);
	}

	@Test
	public void testGetFirstName() {
		Employee test=new Employee("Tom","Elva","Edison");
		assertEquals("Tom",test.getFirstName());
	}

	@Test
	public void testGetMiddleName() {
		Employee test=new Employee("Tom","Elva","Edison");
		assertEquals("Elva",test.getMiddleName());
	}

	@Test
	public void testGetLastName() {
		Employee test=new Employee("Tom","Elva","Edison");
		assertEquals("Edison",test.getLastName());
	}

	@Test
	public void testGetUsername() {
		Employee test=new Employee("Tom","Elva","Edison");
		String excepted=test.getLastName().substring(0, 4) + test.getId();
		assertEquals(test.getUsername(),excepted);
	}

	@Test
	public void testGetPassword() {
		Employee test=new Employee("Tom","Elva","Edison");
	     
		assertEquals(test.getPassword(),"password");
	}
	@Test
	public void setPassword() {
		Employee test=new Employee("Tom","Elva","Edison");
		String passWord="passWord";
		test.setPassword("passWord");
		assertEquals(test.getPassword(),passWord);
	}


}
