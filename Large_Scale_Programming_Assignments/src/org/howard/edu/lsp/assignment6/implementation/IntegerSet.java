package org.howard.edu.lsp.assignment6.implementation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This is a code that performs some operations on a set/sets of numbers
 * @author chinonso
 *
 */
public class IntegerSet {
	
	/**	
	 * set is the set we would be working with in the class. It is the class variable
	 */
	private ArrayList<Integer> set = new ArrayList<Integer>();
	
	/**
	 * This is a constructor. For this assignment, we do not need an instance variable in the constructor as the class variable set is enough.
	 */
	public IntegerSet() {
		
	}
	
	/**
	 * This is a method that clears all the element in the set. It returns nothing
	 */
	public void clear() {
		set.clear();
	}
	
	/**
	 * This is a method that finds the length of a set
	 * @return: It returns the length of a set
	 */
	public int length() {
		return set.size();
	}
	
	/**
	 * This is a method that gets the class variable set from the class
	 * @return: It returns the class variable, set
	 */
	public ArrayList<Integer> getSet() {
		return set;
	}
	
	/**
	 * This is a method that checks if two sets are equal
	 * @param b: It takes a parameter, b which is an object of IntegerSet class
	 * @return: It returns True of False
	 */
	public boolean equals(IntegerSet b) {
		int amount = 0;
		for(int i = 0; i < set.size(); i = i + 1) {
			if (b.getSet().contains(set.get(i))) {
				amount ++;
			}
		}
		return (amount == set.size());
	}
	
	/**
	 * This is a method that checks in a value is in the set
	 * @param val: It takes in a parameter of integer type
	 * @return It returns True or FAlse
	 */
	public boolean contains(int val) {
		return set.contains(val);
	}
	
	/**
	 * This is a method that finds the largest number in the set
	 * @return the largest number in the set
	 * @throws IntegerSetException: It can throw the IntegerSetException
	 */
	public int largest() throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("This is an empty set");
		}
		else {
			return Collections.max(set);
		}
	}
	
	/**
	 * This is a method that finds the smallest number in the set
	 * @return the smallest number in the set
	 * @throws IntegerSetException: It can throw the IntegerSetException
	 */
	public int smallest() throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("This is an empty set");
		}
		else {
			return Collections.min(set);
		}
	}
	
	/**
	 * This is a method that adds items to a set
	 * @param item: It takes a parameter called item of integer type
	 * It returns nothing
	 */
	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);
		}
	}
	
	/**
	 * This is a method that remove items to a set
	 * @param item: It takes a parameter called item of integer type
	 * @throws IntegerSetException: It can throw the IntegerSetException
	 * It returns nothing
	 */
	public void remove(int item) throws IntegerSetException {
		ArrayList<Integer> lst = new ArrayList<Integer>();
		if (set.size() == 0) {
			throw new IntegerSetException("This is an empty set");
		}
		else {
			for(int i = 0; i < set.size(); i = i + 1) {
				if (set.get(i) != item) {
					lst.add(set.get(i));
				}
			}
			set = lst;
		}
	}
	
	/**
	 * This is a method that returns the union of two sets
	 * @param b: It takes in a parameter, b which is an object of IntegerSet class
	 * It returns nothing
	 */
	public void union(IntegerSet b) {
		ArrayList<Integer> lst = b.getSet();
		for(int i = 0; i < lst.size(); i = i + 1) {
			if (!set.contains(lst.get(i))) {
				set.add(lst.get(i));
			}
		}
	}
	
	/**
	 * This is a method that returns the intersect of two sets
	 * @param b: It takes in a parameter, b which is an object of IntegerSet class
	 * It returns nothing
	 */
	public void intersect(IntegerSet b) {
		ArrayList<Integer> lst = b.getSet();
		ArrayList<Integer> lst2 = new ArrayList<Integer>();
		for(int i = 0; i < lst.size(); i = i + 1) {
			if (set.contains(lst.get(i))) {
				lst2.add(lst.get(i));
			}
		}
		set = lst2;
	}
	
	/**
	 * This is a method that returns the difference of two sets
	 * @param b: It takes in a parameter, b which is an object of IntegerSet class
	 * @throws IntegerSetException: It can throw the IntegerSetException
	 * It returns nothing
	 */
	public void difference(IntegerSet b) throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("This is an empty set");
		}
		ArrayList<Integer> lst = b.getSet();
		ArrayList<Integer> lst2 = new ArrayList<Integer>();
		for(int i = 0; i < set.size(); i = i + 1) {
			if (!lst.contains(set.get(i))) {
				lst2.add(set.get(i));
			}
		}
		set = lst2;
	}
	
	/**
	 * This method checks if the set is empty
	 * @return: It returns True or False
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}
	
	/**
	 * This method converts the set to a string form
	 * It returns the string form of the set
	 */
	public String toString() {
		return set.toString();
	}
}
