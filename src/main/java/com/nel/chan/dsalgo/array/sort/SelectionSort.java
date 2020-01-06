package com.nel.chan.dsalgo.array.sort;

import java.util.Scanner;

/**
 * Implement Selection Sort and print the index which gets swapped at each step.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class SelectionSort {

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
			System.out.println();
		}

		in.close();
	}

	private static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - i - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < n - i; j++) {
				if (arr[maxIdx] >= arr[j]) {
					maxIdx = j;
				}
			}

			System.out.print(maxIdx + " ");
			int temp = arr[maxIdx];
			arr[maxIdx] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;

		}

		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}