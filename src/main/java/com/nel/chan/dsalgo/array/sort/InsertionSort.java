package com.nel.chan.dsalgo.array.sort;

import java.util.Scanner;

/**
 * Implement Insertion Sort and print the index at which the ith element gets
 * inserted [i>=1].
 * 
 * @author Chandrakanth Nelge
 *
 */
public class InsertionSort {
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
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
			System.out.print(j + 1 + " ");
		}
	}
}