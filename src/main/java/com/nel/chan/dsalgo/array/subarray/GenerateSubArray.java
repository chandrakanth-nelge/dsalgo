package com.nel.chan.dsalgo.array.subarray;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4 };
		print(arr);
	}

	private static void print(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = i; j < size; j++) {
				builder.append(arr[j] + " ");
				System.out.println(builder.toString());
			}
		}
	}

	@SuppressWarnings("unused")
	private static void generate(int[] arr) {
		int size = arr.length;
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				List<Integer> innerList = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					innerList.add(arr[k]);
				}
				list.add(innerList);
			}
		}

		for (List<Integer> li : list) {
			for (Integer num : li) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	@SuppressWarnings("unused")
	private static void generateSubString(String strArr) {
		for (int i = 0; i < strArr.length(); i++) {
			for (int j = i; j < strArr.length(); j++) {
				System.out.println(strArr.substring(i, j + 1));
			}
		}
	}
}