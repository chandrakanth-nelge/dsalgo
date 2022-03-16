package com.nel.chan.dsalgo.array.sort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[] { -8, 5, 3, 10, -2, -2, -8, -8, -2, 3, -8, 10, 7, 10, -8 };
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		sort(arr, -10, 10);
	}

	public static void twoLoop(int[] arr) {
		int max = 0;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			int noOfoccurence = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					noOfoccurence++;
				}

			}

			if (noOfoccurence > max) {
				max = noOfoccurence;
				index = i;
			}
		}

		System.out.println(arr[index] + " = " + (max + 1));
	}

	public static void countArrayAndMax(int[] arr, int noOfCandidates) {
		int[] count = new int[noOfCandidates + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		Arrays.stream(count).forEach(System.out::print);
		System.out.println();

		int pos = 0;
		for (int i = 1; i < count.length; i++) {
			if (count[i] > count[pos]) {
				pos = i;
			}
		}

		System.out.println(pos);
	}

	public static void countArraySort(int[] arr, int noOfCandidates) {
		int[] count = new int[noOfCandidates + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		Arrays.stream(count).forEach(System.out::print);
		System.out.println();

		int pos = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				for(int j=0; j<count[i]; j++) {
					arr[pos] = i;
					++pos;
				}
			}
		}

		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
	}
	
	public static void sort(int[] arr, int left, int right) {

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
		
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();

	}

}
