package com.nel.chan.dsalgo.array.search.duplicate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OneDuplicate {

	private static final String SPACE = "==========";
	private static final String NO_DUPLICATES_FOUND = "No Duplicates found !!!";

	// N, (0-N-1)
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 3 };
		iterative(arr);
		System.out.println(SPACE);
		map(arr);
		System.out.println(SPACE);
		set(arr);
		System.out.println(SPACE);
		optimized(arr);
	}

	// O(N^2),1
	private static void iterative(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					System.out.println(arr[i]);
				}
			}
		}

		System.out.println(NO_DUPLICATES_FOUND);
	}

	// O(N),N
	private static void map(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
				break;
			} else {
				map.put(arr[i], 1);
			}
		}

		// Print duplicate elements from array in Java
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey());
				return;
			}
		}

		System.out.println(NO_DUPLICATES_FOUND);
	}

	// O(N),N
	private static void set(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (!set.add(arr[i])) {
				System.out.println(arr[i]);
				return;
			}
		}

		System.out.println(NO_DUPLICATES_FOUND);
	}

	// O(N^2),1
	private static void optimized(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			arr[arr[i] % 10] = arr[arr[i] % 10] + 10;
		}

		for (int i = 0; i < size; i++) {
			if (arr[i] > 19) {
				System.out.println(i + " ");
				return;
			}
		}

		System.out.println(NO_DUPLICATES_FOUND);
	}
}