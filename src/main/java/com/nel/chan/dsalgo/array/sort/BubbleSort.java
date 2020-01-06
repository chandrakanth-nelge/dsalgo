package com.nel.chan.dsalgo.array.sort;

import java.util.Scanner;

/**
 * Implement Bubble Sort and print the total number of swaps involved to sort
 * the array.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			sort(arr);
		}

		in.close();
	}

	private static void sort(int[] arr) {
		int i = 0;
		int j = 0;
		int temp = 0;
		int swapCount = 0;
		boolean swapped = false;
		for (i = 0; i < arr.length - 1; i++) {
			swapped = false;
			for (j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
					swapCount++;
				}
			}
			if (!swapped) {
				break;
			}
		}

		System.out.println(swapCount);
	}
}