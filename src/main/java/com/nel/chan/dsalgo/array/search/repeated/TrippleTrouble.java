package com.nel.chan.dsalgo.array.search.repeated;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size 3X+1, where every element occurs three times, except
 * one element, which occurs only once. Find the element that occurs only once.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class TrippleTrouble {

	static final int INT_SIZE = 32;

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 10, 10, 20, 20, 5, 20, 10, 5, 5, 6, 6, 15 };

		// Iterative
		int duplicate = trippleTroubleIterative(arr);
		System.out.println("Iterative :: " + duplicate);

		duplicate = trippleTroubleLoop(arr);
		System.out.println("Loop-Loop :: " + duplicate);

		// BIT-MAP
		duplicate = trippleTroubleHashing(arr);
		System.out.println("MAP :: " + duplicate);

		// BIT-SMART
		duplicate = trippleTroubleBitOperationSmart(arr);
		System.out.println("SMART :: " + duplicate);
	}

	// O(N^2), 1
	private static int trippleTroubleIterative(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					++count;
					if (count == 3) {
						break;
					}
				}
			}

			if ((count % 3) != 0) {
				return arr[i];
			}
		}

		return -1;
	}

	// NLogN + N ==> O(NLogN), O(N)
	private static int trippleTroubleLoop(int[] arr) {
		Arrays.parallelSort(arr);
		
		int size = arr.length;
		int p1 = 0;
		int p2 = p1 + 2;
		while (p2 < size) {
			if (arr[p1] != arr[p2]) {
				break;
			}
			p1 = p1 + 3;
			p2 = p1 + 2;
		}

		return arr[p1];
	}

	// N + N ==> O(N), O(N)
	private static int trippleTroubleHashing(int[] arr) {
		int size = arr.length;
		Map<Integer, Integer> map = new HashMap<>(size);
		for (int i = 0; i < size; i++) {
			int elem = arr[i];
			if (map.containsKey(elem)) {
				int count = map.get(elem);
				map.put(elem, ++count);
			} else {
				map.put(elem, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if ((entry.getValue() % 3) != 0) {
				return entry.getKey();
			}
		}

		return -1;
	}

	// 32*N ==> O(N), 1
	private static int trippleTroubleBitOperationSmart(int[] arr) {
		int sum = 0;
		for (int i = 0; i < INT_SIZE; i++) {
			int mulByThree = 0;
			for (int j = 0; j < arr.length; j++) {
				if (((arr[j] >> i) & 1) == 1) {
					mulByThree++;
				}
			}
			if ((mulByThree % 3) != 0) {
				sum += 1 << i;
			}
		}

		return sum;
	}
}