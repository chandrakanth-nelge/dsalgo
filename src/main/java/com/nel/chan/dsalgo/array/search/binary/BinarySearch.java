package com.nel.chan.dsalgo.array.search.binary;

import com.nel.chan.dsalgo.util.ArrayUtility;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 8, 9, 10, 12, 13, 14, 15, 17, 20 };
		int elem = 13;
		int result = search(arr, elem);
		System.out.println(result);
	}

	private static int search(int[] arr, int elem) {
		int ans = -1;
		if (ArrayUtility.isEmpty(arr)) {
			return ans;
		}

		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (elem < arr[mid]) {
				high = mid - 1;
			} else if (elem > arr[mid]) {
				low = mid + 1;
			} else {
				ans = mid;
				break;
			}
		}

		return ans;
	}
}
