package com.happymart.tests;

import static org.junit.Assert.*;

import com.happymart.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemTypeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		assertEquals(test.getName(),"bread");
	}

	@Test
	public void testSetName() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		String name="name";
		test.setName("name");
		assertEquals(test.getName(),name);
	}


	@Test
	public void testGetUnitName() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		assertEquals(test.getUnitName(),"unit");
	}

	@Test
	public void testSetUnitName() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		String unit="unit";
		test.setName("unit");
		assertEquals(test.getUnitName(),unit);
	}

	@Test
	public void testGetOriginalManufacturerOrSupplierName() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		assertEquals(test.getOriginalManufacturerOrSupplierName(),"general mills");
	}

	@Test
	public void testSetOriginalManufacturerOrSupplierName() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		String sName="originalManufacturerOrSupplierName";
		test.setOriginalManufacturerOrSupplierName("originalManufacturerOrSupplierName");
		assertEquals(test.getOriginalManufacturerOrSupplierName(),sName);
	}

	@Test
	public void testGetDescription() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		assertEquals(test.getDescription(),"food");
	}

	@Test
	public void testSetDescription() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		String des="description";
		test.setDescription("description");
		assertEquals(test.getDescription(),des);
	}

	@Test
	public void testGetPricePerUnitInUSCents() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		assertEquals(test.getPricePerUnitInUSCents(),122);
	}

	@Test
	public void testSetPricePerUnitInUSCents() {
		ItemType test=new ItemType("bread","unit","general mills","food",122);
		int price=111;
		test.setPricePerUnitInUSCents(111);
		assertEquals(test.getPricePerUnitInUSCents(),price);
	}

}
