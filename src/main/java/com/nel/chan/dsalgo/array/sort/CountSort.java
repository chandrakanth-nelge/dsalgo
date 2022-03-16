package com.nel.chan.dsalgo.array.sort;

/**
 * @author Chandrakanth Nelge
 */
public class CountSort {

	public int[] sort(int[] arr) {

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int[] count = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		int pos = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				arr[pos] = i;
				++pos;
			}
		}

		return arr;
	}
	
	public int[] sort(int[] arr, int left, int right) {

		int range = right - left + 1;

		int[] count = new int[range];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]-left]++;
		}

		int pos = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				arr[pos] = i+left;
				++pos;
			}
		}

		return arr;
	}
}
