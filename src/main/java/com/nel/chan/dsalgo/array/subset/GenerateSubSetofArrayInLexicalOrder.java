package com.nel.chan.dsalgo.array.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of unique integer elements, print all the subsets of the given
 * array in lexicographical order.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class GenerateSubSetofArrayInLexicalOrder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			
			possibleSubsets(arr);
			
			System.out.println();
		}

		in.close();
	}

	private static void possibleSubsets(int[] arr) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			List<Integer> subList = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				if ((i & (1 << j)) > 0) {
					subList.add(arr[j]);
				}
			}

			if (!subList.isEmpty()) {
				list.add(subList);
			}
		}

		sortInLexicalOrder(list);
	}

	private static void sortInLexicalOrder(List<List<Integer>> list) {
		Collections.sort(list, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> listOne, List<Integer> listTwo) {
				Collections.sort(listOne);
				Collections.sort(listTwo);
				for (int i = 0; i < listOne.size(); i++) {
					if (listOne.size() > i && listTwo.size() > i) {
						int result = Integer.compare(listOne.get(i), listTwo.get(i));
						if (result != 0) {
							return result;
						}
					} else if (listOne.size() > i && listTwo.size() < i) {
						return 1;
					} else if (listOne.size() < i && listTwo.size() > i) {
						return -1;
					}
				}

				return 0;

			}
		});

		for (List<Integer> subList : list) {
			for (Integer val : subList) {
				System.out.print(val + " ");
			}

			System.out.println();
		}
	}

}