package com.nel.chan.dsalgo.array.search.missing;

/**
 * Given an array of n unique integers where each element in the array is in
 * range [1, n]. The array has all distinct elements and size of array is (n-2).
 * Hence Two numbers from the range are missing from this array. Find the two
 * missing numbers.
 * 
 * @author Chandrakanth Nelge
 */
public class FindTwoMissingNumber {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = 2 + arr.length;

		findTwoMissingNumbers(arr, n);
		findTwoMissingNumbersByNaturalNumberSum(arr, n);
		findTwoMissingNumbersXOR(arr, n);
	}

	private static void findTwoMissingNumbersXOR(int[] arr, int n) {
		int xor = arr[0];
		for (int i = 1; i < n - 2; i++) {
			xor = xor ^ arr[i];
		}
		
		for (int i = 1; i <= n; i++) {
			xor = xor ^ i;
		}

		//Now XOR has XOR of two missing elements. Any set bit in it must be set in one missing
		//and unset in other missing number Get a set bit of XOR (We get the rightmost set bit)
		int setBitNo = xor & ~(xor - 1);

		//Now divide elements in two sets by comparing rightmost set bit of XOR with bit at same position in each element.
		int x = 0;
		int y = 0;
		for (int i = 0; i < n - 2; i++) {
			if ((arr[i] & setBitNo) > 0) {
				x = x ^ arr[i];
			} else {
				y = y ^ arr[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			if ((i & setBitNo) > 0) {
				x = x ^ i;
			}
			else {
				y = y ^ i;
			}
		}

		System.out.println("Two Missing Numbers are ");
		System.out.println(x + " " + y);
	}

	private static void findTwoMissingNumbersByNaturalNumberSum(int[] arr, int n) {
		// Sum of 2 Missing Numbers
		int sum = (n*(n+1)) / 2 - getSum(arr, n - 2);

		// Find average of two elements
		int avg = (sum / 2);

		// Find sum of elements smaller than average (avg) and sum of elements greater
		// than average (avg)
		int sumSmallerHalf = 0;
		int sumGreaterHalf = 0;
		for (int i = 0; i < n - 2; i++) {
			if (arr[i] <= avg) {
				sumSmallerHalf += arr[i];
			} else {
				sumGreaterHalf += arr[i];
			}
		}

		System.out.println("Two Missing " + "Numbers are");

		// The first (smaller) element = (sum of natural numbers upto avg) - (sum of
		// array elements smaller than or equal to avg)
		int totalSmallerHalf = (avg * (avg + 1)) / 2;
		System.out.println(totalSmallerHalf - sumSmallerHalf);

		// The first (smaller) element = (sum of natural numbers from avg+1 to n) - (sum
		// of array elements greater than avg)
		System.out.println(((n*(n+1)) / 2 - totalSmallerHalf) - sumGreaterHalf);
	}

	private static int getSum(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	/**
	 * O(N), O(N)
	 */
	private static void findTwoMissingNumbers(int[] arr, int n) {
		boolean[] mark = new boolean[n+1];
		for (int i = 0; i < n - 2; i++) {
			mark[arr[i]] = true;
		}

		// Print two unmarked elements
		System.out.println("Two Missing Numbers are");
		for (int i = 1; i <= n; i++) {
			if (!mark[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}