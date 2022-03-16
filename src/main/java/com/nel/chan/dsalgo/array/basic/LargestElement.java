package com.nel.chan.dsalgo.array.basic;

public class LargestElement {

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 22, 4, 6, 11 };
		int large = new LargestElement().largest(arr);
		System.out.println(large);
	}

	public int largest(int[] arr) {
		int large = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > large) {
				large = arr[i];
			}
		}

		return large;
	}
}
