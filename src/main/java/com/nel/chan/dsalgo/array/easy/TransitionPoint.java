package com.nel.chan.dsalgo.array.easy;

public class TransitionPoint {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		arr = new int[] { 0, 1, 1, 1, 1, 1, 1, 1, 1 };
		int size = transitionPoint(arr);
		System.out.println(size);
	}

	private static int transitionPoint(int[] arr) {
		if (arr[0] == 1) {
			return 0;
		}

		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == 0) {
				low = mid + 1;
			} else if (arr[mid] == 1) {
				if (arr[mid - 1] == 0) {
					return mid;
				}
				high = mid - 1;
			}
		}

		return -1;
	}
}
