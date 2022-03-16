package com.nel.chan.dsalgo.array.sort;

/**
 * @author Chandrakanth Nelge
 * https://www.programiz.com/dsa/insertion-sort
 */
public class InsertionSort {

	public int[] sort(int[] arr) {
		int size = arr.length;
		for (int i = 1; i < size; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				--j;
			}

			arr[j + 1] = key;
		}

		return arr;
	}
}