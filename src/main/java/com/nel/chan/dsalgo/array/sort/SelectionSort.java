package com.nel.chan.dsalgo.array.sort;

/**
 * @author Chandrakanth Nelge
 */
public class SelectionSort {

	public int[] sort(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[maxIdx] > arr[j]) {
					maxIdx = j;
				}
			}

			int temp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = temp;
		}

		return arr;
	}
	
	public int[] sortReverse(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[maxIdx] < arr[j]) {
					maxIdx = j;
				}
			}

			int temp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = temp;
		}

		return arr;
	}
}