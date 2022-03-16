package com.nel.chan.dsalgo.array.easy;

public class CountZeroes {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		arr = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 };
		int size = countZeroes(arr);
		System.out.println(size);
	}

	private static int countZeroes(int[] arr) {
		if (arr[0] == 0) {
			return arr.length;
		}

		int low = 0;
		int high = arr.length;
		int size = 0;
		while (low < high) {
			int mid = (low + high) / 2;
			if (arr[mid] == 0) {
				if (arr[mid - 1] == 1) {
					size = arr.length - mid;
					break;
				}
				high = mid - 1;
			} else if (arr[mid] == 1) {
				if (mid + 1 < arr.length && arr[mid + 1] == 0) {
					size = arr.length - mid - 1;
					break;
				}
				low = mid + 1;
			}
		}

		return size;
	}
}