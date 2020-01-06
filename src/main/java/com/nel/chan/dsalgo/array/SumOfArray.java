package com.nel.chan.dsalgo.array;

import java.util.Scanner;

/**
 * Given an array of integers, find the sum of its elements.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class SumOfArray {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int noOfTestCases = scanner.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			long[] arr = getInputArray();
			long result = simpleArraySum(arr);
			System.out.println(result);
		}

		scanner.close();
	}

	static long simpleArraySum(long[] arr) {
		long sum = 0;
		for (long num : arr) {
			sum += num;
		}

		return sum;
	}

	public static long[] getInputArray() {
		int arrSize = scanner.nextInt();
		long[] inArray = new long[arrSize];
		int size = 0;
		while (size != arrSize) {
			inArray[size++] = scanner.nextLong();
		}

		return inArray;
	}

}