package com.nel.chan.dsalgo.array.search.repeated;

import java.util.Arrays;

/**
 * Given an array where all elements appear EVEN number of times except TWO,
 * print the TWO ODD occurring elements. It may be assumed that the size of
 * array is at-least two.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class EvenOccurringFindTwoOddOccurring {

	public static void main(String[] args) {
		int[] arr = new int[] { 15, 10, 10, 50, 7, 5, 5, 50, 20, 40, 40, 20 };
		iterative(arr);
		System.out.println("===============");
		xor(arr);
	}

	private static void iterative(int[] arr) {
		Arrays.sort(arr);
		
		int count = 0;
		int index = 0;
		boolean isBreak = false;
		while (index < arr.length) {
			if (index + 1 == arr.length) {
				System.out.println(arr[index]);
				isBreak = true;
			} else if (arr[index] != arr[index + 1]) {
				System.out.println(arr[index]);
				++index;
				++count;
				if (count == 2) {
					isBreak = true;
				}
			} else {
				index = index + 2;
			}

			if (isBreak) {
				break;
			}
		}
	}

	// O(N+N), 1
	private static void xor(int[] arr) {
		int xor = arr[0];
		for (int i = 1; i < arr.length; i++) {
			xor = xor ^ arr[i];
		}

		int rightSetBitNo = xor ^ (xor & (xor - 1));

		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & rightSetBitNo) == rightSetBitNo) {
				num1 = num1 ^ arr[i];
			} else {
				num2 = num2 ^ arr[i];
			}
		}

		if (num1 < num2) {
			System.out.println(num1);
			System.out.println(num2);
		} else {
			System.out.println(num2);
			System.out.println(num1);
		}
	}
}