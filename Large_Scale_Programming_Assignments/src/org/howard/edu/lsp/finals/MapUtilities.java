package org.howard.edu.lsp.finals;

import java.util.HashMap;

public class MapUtilities {
	public static int commonKeyValuePairs(
			HashMap<String, String> map1,
			HashMap<String, String> map2) throws NullMapException {
		if ((map1 == null) || (map2 == null)) {
			throw new NullMapException("Either or both hashmaps is null.");
		}
		else if (map1.isEmpty() || map2.isEmpty()) {
			return 0;
		}
		else {
			int amount = 0;
			for (String key: map1.keySet()) {
				if ((map1.containsKey(key)) && (map1.get(key).equals(map2.get(key)))) {
					amount ++;
				}
			}
			return amount;
		}
	}
}
