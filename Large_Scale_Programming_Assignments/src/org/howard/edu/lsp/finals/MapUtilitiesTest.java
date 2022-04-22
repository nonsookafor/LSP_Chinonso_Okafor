package org.howard.edu.lsp.finals;

import java.util.HashMap;

public class MapUtilitiesTest {
	@Test
	@DisplayName("MapUtilitiesTest.commonKeyValuePairs test cases")
	public void testCommonKeyValuePairs() throws NullMapException {
		HashMap<String, String> hashmap1 = null;
		HashMap<String, String> hashmap2 = null;
		HashMap<String, String> hashmap3 = new HashMap<String, String>();
		HashMap<String, String> hashmap4 = new HashMap<String, String>();
		HashMap<String, String> hashmap5 = new HashMap<String, String>();
		HashMap<String, String> hashmap6 = new HashMap<String, String>();
		HashMap<String, String> hashmap7 = new HashMap<String, String>();
		hashmap3.put("Cane", "Geeks");
	    hashmap3.put("Rice", "4");
	    hashmap3.put("Beans", "Geeks");
	    
	    hashmap4.put("Sugar", "Welcomes");
	    hashmap4.put("Cane", "Geeks");
	    hashmap4.put("Rice", "4");
	    
	    hashmap5.put("Cane", "Dogood");
	    hashmap5.put("Radio", "Geeks");
	    
	    MapUtilities class1 = new MapUtilities();
	    //testing the two empty values
	    int output3 = class1.commonKeyValuePairs(hashmap6, hashmap7);
	    assertEquals(String.valueOf(output3), String.valueOf(0));
	    assertNotEquals(String.valueOf(output3), String.valueOf(3));
	    
	    
	    //testing an empty and not empty hashmap
	    int output4 = class1.commonKeyValuePairs(hashmap6, hashmap4);
	    int output5 = class1.commonKeyValuePairs(hashmap3, hashmap7);
	    assertEquals(String.valueOf(output4), String.valueOf(0));
	    assertNotEquals(String.valueOf(output4), String.valueOf(5));
	    assertEquals(String.valueOf(output5), String.valueOf(0));
	    assertNotEquals(String.valueOf(output5), String.valueOf(5));
	    
	    
	    //testing two null values
	    Exception exception = assertThrows(IntegerSetException.class, () ->  {
	    	class1.commonKeyValuePairs(hashmap1, hashmap2);
		});
		String expectedMessage = "Either or both hashmaps is null.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		
		
		//testing when just one hasmap is null
		Exception exception1 = assertThrows(IntegerSetException.class, () ->  {
			class1.commonKeyValuePairs(hashmap1, hashmap5);
		});
		String expectedMessage1 = "Either or both hashmaps is null.";
		String actualMessage1 = exception.getMessage();
		assertTrue(actualMessage1.contains(expectedMessage1));
		
		Exception exception2 = assertThrows(IntegerSetException.class, () ->  {
			class1.commonKeyValuePairs(hashmap5, hashmap2);
		});
		String expectedMessage2 = "Either or both hashmaps is null.";
		String actualMessage2 = exception.getMessage();
		assertTrue(actualMessage2.contains(expectedMessage2));
	    
	    
	    //other test case
	    int output1 = class1.commonKeyValuePairs(hashmap3, hashmap4);
	    int output2 = class1.commonKeyValuePairs(hashmap3, hashmap5);
	    assertEquals(String.valueOf(output1), String.valueOf(2));
	    assertNotEquals(String.valueOf(output1), String.valueOf(5));
	    assertEquals(String.valueOf(output2), String.valueOf(0));
	    assertNotEquals(String.valueOf(output2), String.valueOf(5));
	    
	}

}
