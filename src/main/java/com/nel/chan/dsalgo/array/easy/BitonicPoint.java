package com.nel.chan.dsalgo.array.easy;

/***
 * 
 * @author Chandrakanth 
 * Given an array of n elements which is first increasing and then may be decreasing
 * find the maximum element in the array.
 */
public class BitonicPoint {
	public static void main(String[] args) {
		int[] arr = new int[] { 1,15,25,45,42,21,17,12,11 };
		int result = findMaximum(arr);
		System.out.println(result);
	}
	
	private static int findMaximum(int[] arr) {
        int result = arr[0];
        
        boolean isFound = false;
        for(int i=1; i<arr.length; i++) {
        	if(arr[i-1] < arr[i]) {
        		
        	} else {
        		isFound = true;
        		result = arr[i-1];
        		break;
        	}
        }
        
        if(isFound) {
        	return result;
        }
        return arr[arr.length - 1];
    }

}
