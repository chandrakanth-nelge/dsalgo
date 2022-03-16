package com.nel.chan.dsalgo.array.basic;

public class IsArraySorted {

	public boolean isSorted(int[] arr) {
		if (arr.length == 1 || arr.length == 0) {
			return true;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}

		return true;
	}
}