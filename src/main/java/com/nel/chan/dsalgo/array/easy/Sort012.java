package com.nel.chan.dsalgo.array.easy;

import java.util.Arrays;

public class Sort012 {

	public static void main(String[] args) {
		int[] arr = {0, 2, 1, 2, 0};

		sort012Binary(arr);
		
		System.out.println(Arrays.toString(arr));
	}

	private static void sort012(int[] arr) {
		System.out.println(Arrays.toString(arr));

		int[] count = new int[3];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] = count[arr[i]] + 1;
		}

		int index = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				arr[index] = i;
				++index;
			}
		}
	}

	public static void sort012Binary(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (mid <= high) {
			if (arr[mid] == 0) {
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}
	}
}
