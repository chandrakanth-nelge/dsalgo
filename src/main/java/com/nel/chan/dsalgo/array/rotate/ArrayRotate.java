package com.nel.chan.dsalgo.array.rotate;

import java.util.Arrays;

public class ArrayRotate {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		printArray(arr);

		/*
		 * int[] rotArrRight = rotate_Array_Right_Temp(arr, 2);
		 * _print_Array(rotArrRight); int[] rotArrLeft = rotate_Array_Left_Temp(arr, 2);
		 * _print_Array(rotArrLeft);
		 */

		/*
		 * int[] rotArrRight = rotate_array_right_shift(arr, 2);
		 * _print_Array(rotArrRight);
		 * 
		 * int[] rotArrLeft = rotate_array_left_shift(arr, 2); _print_Array(rotArrLeft);
		 */
	}

	private static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	/***
	 * O(n) : Time Complexity O(d) : Space Complexity
	 */
	@SuppressWarnings("unused")
	private static int[] rotateArrayRightTemp(int[] arr, int rotate) {
		int[] temp = new int[arr.length];

		int j = rotate;
		for (int i = 0; i < arr.length - rotate; i++) {
			temp[j++] = arr[i];
		}

		j = 0;
		int index = arr.length - rotate;
		for (int i = index; i < arr.length; i++) {
			temp[j++] = arr[i];
		}

		return temp;
	}

	/***
	 * O(n) : Time Complexity O(d) : Space Complexity
	 */
	@SuppressWarnings("unused")
	private static int[] rotateArrayLeftTemp(int[] arr, int rotate) {
		int[] temp = new int[arr.length];

		int j = 0;
		for (int i = rotate; i < arr.length; i++) {
			temp[j++] = arr[i];
		}

		j = arr.length - rotate;
		for (int i = 0; i < rotate; i++) {
			temp[j++] = arr[i];
		}

		return temp;
	}

	/***
	 * O(n) : Time Complexity O(d) : Space Complexity
	 */
	@SuppressWarnings("unused")
	private static int[] rotateArrayRightShift(int[] arr, int rotate) {
		for (int i = 0; i < rotate; i++) {
			rotateRightByOne(arr);
		}
		return arr;
	}

	private static void rotateRightByOne(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[i - 1];
			arr[i - 1] = temp;
		}
	}

	/***
	 * O(n) : Time Complexity O(d) : Space Complexity
	 */
	@SuppressWarnings("unused")
	private static int[] rotateArrayLeftShift(int[] arr, int rotate) {
		for (int i = 0; i < rotate; i++) {
			rotateLeftByOne(arr);
		}
		return arr;
	}

	private static void rotateLeftByOne(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[i - 1];
			arr[i - 1] = temp;
		}
	}
}