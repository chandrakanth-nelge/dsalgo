package com.nel.chan.dsalgo.array.sort;

/**
 * @author Chandrakanth Nelge
 */
public class BubbleSort {

	/**
	 * Bubbling smallest element
	 */
	public int[] bubbleSmallestElement(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;
	}

	/**
	 * Bubbling largest element
	 * Optimized solution
	 */
	public int[] bubbleLargestElement(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			boolean isSwapped = false;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
				}
			}

			if (!isSwapped) {
				break;
			}
		}

		return arr;
	}

	/**
	 * Bubbling largest element Reverse
	 * Optimized solution
	 */
	public int[] bubbleLargestElementReverse(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			boolean isSwapped = false;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
				}
			}

			if (!isSwapped) {
				break;
			}
		}

		return arr;
	}

	public void noOfSwaps(int[] arr) {
		int swapCount = 0;
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			boolean isSwapped = false;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
					swapCount++;
				}
			}
			if (!isSwapped) {
				break;
			}
		}

		System.out.println(swapCount);
	}
}