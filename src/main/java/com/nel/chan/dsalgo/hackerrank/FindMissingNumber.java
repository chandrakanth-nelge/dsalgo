package com.nel.chan.dsalgo.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FindMissingNumber {

	public static void main(String[] args) {
		int[] arr = new int[] {12, 1, 12, 3, 12, 1, 1, 5, 3, 3};
		findMissingNumberThriceXOR(arr);
		findMissingNumberThriceMap(arr);
	}
	
	/**
	 * Given an array, other than one number, remaining numbers all repeated thrice. Find the lonely number. 
	 * Using XOR Logic
	 * O(N), O(1)
	 */
	static int findMissingNumberThriceXOR(int[] arr) {
		int n = arr.length;
        int ones = 0;
        int twos = 0;
        int commonBitMask;
        for(int i=0; i<n; i++) {
        	/*one & arr[i] gives the bits that are there in both. We add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & arr[i]);
            
            /*XOR the new bits with previous 'ones' to get all bits appearing odd number of times*/
            ones = ones ^ arr[i];
            
            /*The common bits are those bits which appear third time So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can be removed from 'ones' and 'twos'*/
            commonBitMask = ~(ones & twos);
            
            /* Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= commonBitMask;
            
            /* Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= commonBitMask;
        }
        
        System.out.println(ones + " is missing from given array");
        return ones;
    }
	
	/**
	 * Given an array, other than one number, remaining numbers all repeated thrice. Find the lonely number. 
	 * Using Map Logic
	 * O(N+N), O(N)
	 */
	public static void findMissingNumberThriceMap(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}else {
				map.put(arr[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				System.out.println(entry.getKey() + " is missing from given array");
			}
		}
	}
}