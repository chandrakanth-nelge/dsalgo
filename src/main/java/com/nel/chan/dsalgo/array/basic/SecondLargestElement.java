package com.nel.chan.dsalgo.array.basic;

public class SecondLargestElement {

	public int secondLargest(int[] arr) {
		int max1 = -1;
		int max2 = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2 && arr[i] != max1) {
				max2 = arr[i];
			}
		}

		return max2;
	}
}