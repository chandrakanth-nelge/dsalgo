package com.nel.chan.dsalgo.util;

import java.util.Arrays;
import java.util.Objects;

public class ArrayUtility {

	private ArrayUtility() {

	}

	public static int[] getInputArray(int arrSize) {
		int[] arr = new int[arrSize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		return arr;
	}

	public static void displayArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static boolean isEmpty(int[] arr) {
		return (Objects.isNull(arr) || arr.length == 0);
	}
}