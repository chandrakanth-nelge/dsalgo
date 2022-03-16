package com.nel.chan.dsalgo.array.subset;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 5, 10 };

		List<List<Integer>> subsetList = subsets(arr);
		
		for(List<Integer> list : subsetList) {
			System.out.println(list);
		}
	}

	private static List<List<Integer>> subsets(int[] arr) {
		List<List<Integer>> subsetList = new ArrayList<>();
		for (int i = 0; i < (1 << arr.length); i++) {
			List<Integer> innerList = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				if (isBitSetAtGivenIndex(i, j)) {
					innerList.add(arr[j]);
				}
			}
			
			if(!innerList.isEmpty())
				subsetList.add(innerList);
		}

		return subsetList;
	}
	
	@SuppressWarnings("unused")
	private static void subsetsLoop(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
	}

	/**
	 * Right shift number to index's time and check LSB
	 */
	private static boolean isBitSetAtGivenIndex(int num, int index) {
		return ((num >> index) & 1) == 1;
	}
}
