package com.nel.chan.dsalgo.array.subarray;

/**
 * Given an integer array of size n, find sum of all sub-arrays of given array.
 * 
 * @author Chandrakanth Nelge
 */
public class SubArraySum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4};
		System.out.println("Sum of SubArray : " + subArraySum(arr));
	}

	// O(N^3)
	private static long subArraySum(int[] arr) {
		int size = arr.length;
		long result = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				for (int k = i; k <= j; k++) {
					result += arr[k];
				}
			}
		}
		return result;
	}

	// O(N)
	public static long subArraySumOptimized(int[] arr) {
		int size = arr.length;
		long result = 0;
		for (int i = 0; i < size; i++) {
			result = result + (arr[i] * (i + 1) * (size - i));
		}

		return result;
	}
}