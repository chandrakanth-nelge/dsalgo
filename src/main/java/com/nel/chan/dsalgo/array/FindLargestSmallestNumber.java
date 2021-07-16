package com.nel.chan.dsalgo.array;

public class FindLargestSmallestNumber {

	public static void main(String[] args) {

		int[] arr = new int[] { 12, 56, 76, 89, 100, 343, 21, 234 };
		findLargestSmallestNumber(arr);
	}

	private static void findLargestSmallestNumber(int[] arr) {
		int smallest = arr[0];
		int largest = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
			} else if (arr[i] < smallest) {
				smallest = arr[i];
			}

		}
		System.out.println("Smallest Number is : " + smallest);
		System.out.println("Largest Number is : " + largest);
	}
}