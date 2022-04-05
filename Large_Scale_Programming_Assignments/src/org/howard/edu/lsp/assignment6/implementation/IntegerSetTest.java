package org.howard.edu.lsp.assignment6.implementation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {
	
	@Test
	@DisplayName("IntegerSet.clear test cases")
	public void testClear() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set1.clear();
		set2.clear();
		assertEquals("[]", set1.toString());
		assertEquals("[]", set2.toString());
		assertNotEquals("[3, 5]", set2.toString());
		assertNotEquals("[3, 5, 1]", set2.toString());
	}
	
	
	@Test
	@DisplayName("IntegerSet.length test cases")
	public void testLength() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		assertEquals(1, set1.length());
		assertEquals(2, set2.length());
		assertNotEquals(1, set2.length());
		assertNotEquals(0, set1.length());
	}
	
	
	@Test
	@DisplayName("IntegerSet.getSet test cases")
	public void testGetSet() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		assertEquals("[1]", set1.toString());
		assertEquals("[3, 5]", set2.toString());
		assertNotEquals("[1, 3]", set1.toString());
		assertNotEquals("[1, 3, 5]", set2.toString());
	}

	
	@Test
	@DisplayName("IntegerSet.equals test cases")
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		set3.add(1);
		set3.add(5);
		set3.add(3);
		assertTrue(set2.equals(set3));
		assertFalse(set3.equals(set1));
		assertFalse(set2.equals(set1));
	}
	
	
	@Test
	@DisplayName("IntegerSet.contains test cases")
	public void testContains() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		set3.add(1);
		set3.add(5);
		set3.add(3);
		assertTrue(set2.contains(3));
		assertTrue(set3.contains(5));
		assertFalse(set1.contains(0));
		assertFalse(set2.contains(9));
	}
	
	
	@Test
	@DisplayName("IntegerSet.largest test cases")
	public void testLargest() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		set3.add(1);
		set3.add(5);
		set3.add(3);
		assertEquals(1, set1.largest());
		assertEquals(5, set2.largest());
		assertNotEquals(1, set2.largest());
		assertNotEquals(0, set3.largest());
		
		IntegerSet set4 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () ->  {
			set4.largest();
		});
		String expectedMessage = "This is an empty set";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	@DisplayName("IntegerSet.smallest test cases")
	public void testSmallest() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		set3.add(1);
		set3.add(5);
		set3.add(3);
		assertEquals(1, set1.smallest());
		assertEquals(1, set2.smallest());
		assertNotEquals(3, set2.smallest());
		assertNotEquals(0, set3.smallest());
		
		IntegerSet set4 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () ->  {
			set4.smallest();
		});
		String expectedMessage = "This is an empty set";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	@DisplayName("IntegerSet.add test cases")
	public void testAdd() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		assertEquals("[1]", set1.toString());
		assertEquals("[3, 5]", set2.toString());
		assertNotEquals("[1, 3]", set1.toString());
		assertNotEquals("[1, 3, 5]", set2.toString());
	}
	
	
	@Test
	@DisplayName("IntegerSet.remove test cases")
	public void testRemove() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set1.remove(1);
		set2.remove(5);
		assertEquals("[]", set1.toString());
		assertEquals("[3]", set2.toString());
		assertNotEquals("[1, 3]", set1.toString());
		assertNotEquals("[1, 3, 5]", set2.toString());
		
		IntegerSet set4 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () ->  {
			set4.remove(8);
		});
		String expectedMessage = "This is an empty set";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	@DisplayName("IntegerSet.union test cases")
	public void testUnion() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		IntegerSet set4 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		set3.add(1);
		set3.add(5);
		set3.add(3);
		set4.add(8);
		set1.union(set2);
		set3.union(set4);
		assertEquals("[1, 3, 5]", set1.toString());
		assertEquals("[1, 5, 3, 8]", set3.toString());
		assertNotEquals("[1, 3]", set1.toString());
		assertNotEquals("[1, 3, 5]", set3.toString());
	}
	
	
	@Test
	@DisplayName("IntegerSet.intersect test cases")
	public void testIntersect() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		IntegerSet set4 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		set3.add(1);
		set3.add(5);
		set3.add(3);
		set4.add(3);
		set1.intersect(set2);
		set3.intersect(set4);
		assertEquals("[1]", set1.toString());
		assertEquals("[3]", set3.toString());
		assertNotEquals("[1, 3]", set1.toString());
		assertNotEquals("[1, 3, 5]", set3.toString());
	}
	
	
	@Test
	@DisplayName("IntegerSet.difference test cases")
	public void testDifference() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		IntegerSet set4 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		set3.add(1);
		set3.add(5);
		set3.add(3);
		set4.add(3);
		set1.difference(set2);
		set3.difference(set4);
		assertEquals("[]", set1.toString());
		assertEquals("[1, 5]", set3.toString());
		assertNotEquals("[1, 3]", set1.toString());
		assertNotEquals("[1, 3, 5]", set3.toString());
		
		IntegerSet set5 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () ->  {
			set5.difference(set2);
		});
		String expectedMessage = "This is an empty set";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	@DisplayName("IntegerSet.isEmpty test cases")
	public void testisEmpty() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = new IntegerSet();
		IntegerSet set4 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		assertTrue(set3.isEmpty());
		assertTrue(set4.isEmpty());
		assertFalse(set1.isEmpty());
		assertFalse(set2.isEmpty());
		
		set1.clear();
		set2.clear();
		assertTrue(set3.isEmpty());
		assertTrue(set4.isEmpty());
	}
	
	
	@Test
	@DisplayName("IntegerSet.toString test cases")
	public void testToString() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set2.add(3);
		set2.add(5);

		assertEquals("[1]", set1.toString());
		assertEquals("[3, 5]", set2.toString());
		assertNotEquals("[1, 3]", set1.toString());
		assertNotEquals("[1, 3, 5]", set2.toString());
	}
}
