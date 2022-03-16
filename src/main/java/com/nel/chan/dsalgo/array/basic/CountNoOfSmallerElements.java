package com.nel.chan.dsalgo.array.basic;

/***
 * @author Chandrakanth 
 * Given an sorted array A of size N. Find number of
 * elements which are less than or equal to given element X.
 */
public class CountNoOfSmallerElements {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 4, 5, 8, 10};
		int elem = 1;
		
		int result = countOfElements(arr, elem);
		System.out.println(result);
	}
	
	public static int countOfElements(int[] arr, int elem) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] <= elem) {
				++counter;
			}
		}
		
		return counter;
	}
	
}
