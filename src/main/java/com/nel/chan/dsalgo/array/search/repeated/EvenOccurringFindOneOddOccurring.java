package com.nel.chan.dsalgo.array.search.repeated;

/**
 * Given an array where all elements appear EVEN number of times except ONE,
 * print the ONE ODD occurring elements. It may be assumed that the size of
 * array is at-least two.
 * 
 * @author Chandrakanth Nelge
 */
public class EvenOccurringFindOneOddOccurring {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 2, 3, 5, 4, 4, 1, 5 };
		//arr = new int[] {10,10,8};

		int duplicate = iterative(arr);
		System.out.println(duplicate);
		System.out.println("====");
		duplicate = xor(arr);
		System.out.println(duplicate);
	}

	// O(N^2)
	private static int iterative(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					++count;
					if (count == 2) {
						break;
					}
				}
			}

			if (count != 2) {
				return arr[i];
			}
		}

		return -1;
	}

	// O(N)
	private static int xor(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result = result ^ arr[i];
		}

		return result;
	}
}