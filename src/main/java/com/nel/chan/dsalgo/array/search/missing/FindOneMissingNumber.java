package com.nel.chan.dsalgo.array.search.missing;

/**
 * Given a list of (n-1) integers and these integers are in the range of [1,n].
 * There are no duplicates in the list. One of the integer is missing in
 * the list. Write an efficient code to find the missing integer.
 * 
 * @author Chandrakanth Nelge
 */
public class FindOneMissingNumber {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,6,7,8,9};
		System.out.println(missingNumberByNaturalSumFormula(arr));
		System.out.println(missingNumberByXOR(arr));
	}

	/**
	 * Get the sum of numbers which is total = n*(n+1)/2 Subtract all the numbers
	 * from sum and you will get the missing number There can be overflow if n is
	 * large. In order to avoid Integer Overflow, we can pick one number from known
	 * numbers and subtract one number from given numbers. This way we won’t have
	 * Integer Overflow eve
	 */
	private static int missingNumberByNaturalSumFormula(int[] arr) {
		int arrSize = arr.length;
		int expectedSum = (arrSize + 1) * (arrSize + 2) / 2;
		for (int i = 0; i < arr.length; i++) {
			expectedSum = expectedSum - arr[i]; // to avoid overflow
		}

		return expectedSum;
	}

	/**
	 * XOR all the array elements, let the result of XOR be X1. XOR all numbers from
	 * 1 to n, let XOR be X2. XOR of X1 and X2 gives the missing number.
	 */
	private static int missingNumberByXOR(int[] arr) {
		int xor1 = 0;
		for (int i = 0; i < arr.length; i++) {
			xor1 ^= arr[i];
		}

		int xor2 = 0;
		for (int i = 0; i <= arr.length + 1; i++) {
			xor2 ^= i;
		}

		return (xor1 ^ xor2);
	}
}