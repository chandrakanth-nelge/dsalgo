package com.nel.chan.dsalgo.array.search.duplicate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoDuplicate {

	private static final String SPACE = "===";
	private static final String NO_DUPLICATES_FOUND = "No Duplicates found !!!";

	// Given N, in the range [0,N-1]
	public static void main(String[] args) {
		int[] arr = new int[] { 4, 2, 4, 5, 2, 3, 1, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
		iterative(arr);
		System.out.println(SPACE);
		map(arr);
		System.out.println(SPACE);
		set(arr);
		System.out.println(SPACE);
		optimized(arr);

		arr = new int[] { 4, 2, 4, 5, 2, 3, 1, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
		System.out.println(SPACE);
		countArray(arr);
	}

	// O(N^2),1
	private static void iterative(int[] arr) {
		boolean isDuplicateFound = false;
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					isDuplicateFound = true;
					System.out.print(arr[i] + " ");
				}
			}
		}

		if (!isDuplicateFound) {
			System.out.println(NO_DUPLICATES_FOUND);
		} else {
			System.out.println();
		}
	}

	// O(N+N),N
	private static void map(int[] arr) {
		boolean isDuplicateFound = false;
		Map<Integer, Integer> map = new HashMap<>();
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		// Print duplicate elements from array in Java
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				isDuplicateFound = true;
				System.out.print(entry.getKey() + " ");
			}
		}

		if (!isDuplicateFound) {
			System.out.println(NO_DUPLICATES_FOUND);
		} else {
			System.out.println();
		}
	}

	// O(N),N
	private static void set(int[] arr) {
		boolean isDuplicateFound = false;
		Set<Integer> set = new HashSet<>();
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (!set.add(arr[i])) {
				isDuplicateFound = true;
				System.out.print(arr[i] + " ");
			}
		}

		if (!isDuplicateFound) {
			System.out.println(NO_DUPLICATES_FOUND);
		} else {
			System.out.println();
		}
	}

	// O(N),N
	private static void countArray(int[] arr) {
		int size = arr.length;
		int[] count = new int[size];
		for (int i = 0; i < size; i++) {
			if (count[arr[i]] == 1) {
				System.out.print(arr[i] + " ");
			} else {
				count[arr[i]]++;
			}
		}
	}

	// O(N^2),1
	private static void optimized(int[] arr) {
		boolean isDuplicateFound = false;
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			arr[arr[i] % size] = arr[arr[i] % size] + size;
		}

		for (int i = 0; i < size; i++) {
			if (arr[i] > (2 * size - 1)) {
				isDuplicateFound = true;
				System.out.print(i + " ");
			}
		}

		if (!isDuplicateFound) {
			System.out.println(NO_DUPLICATES_FOUND);
		} else {
			System.out.println();
		}
	}
}