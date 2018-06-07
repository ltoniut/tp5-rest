package com.esq.models.test;

import org.junit.Before;
import org.junit.Test;

import com.esq.models.Cabin;

import junit.framework.TestCase;

public class CabinTest extends TestCase {

	Cabin cabin;
	Cabin otherCabin;

	@Before
	public void setUp() {
		this.cabin = new Cabin(1, "Económico");
		this.otherCabin = new Cabin(2, "VIP");
	}

	@Test
	public void testToStringOK() {
		String value = this.cabin.toString();
		assertEquals("Checking toString", value, "Económico");
	}

	@Test
	public void testToStringNull() {
		this.cabin.setName(null);
		String value = this.cabin.toString();

		assertEquals("Checking toString", value, null);
	}

	@Test
	public void testEqualsNull() {
		boolean value = this.cabin.equals(null);
		assertEquals("Checking equals", value, false);
	}

	@Test
	public void testEqualsOtherObject() {
		boolean value = this.cabin.equals("String");
		assertEquals("Checking equals", value, false);
	}

	@Test
	public void testEqualsNullAttributes() {
		this.otherCabin.setId(0);
		this.otherCabin.setName(null);

		boolean value = this.cabin.equals(otherCabin);
		assertEquals("Checking equals", value, false);
	}

	@Test
	public void testEqualsDifferentAttributes() {
		boolean value = this.cabin.equals(this.otherCabin);
		assertEquals("Checking equals", value, false);
	}

	@Test
	public void testEqualsOK() {
		this.otherCabin = this.cabin;

		boolean value = this.cabin.equals(otherCabin);
		assertEquals("Checking equals", value, true);
	}

}