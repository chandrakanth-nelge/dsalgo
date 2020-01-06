package com.nel.chan.dsalgo.array.subsequence;

/**
 * For an array print all the possible sub subsequences. As we all know there
 * are 2^N possible subsets of any given set with N elements. What if we
 * represent each element in a subset with a bit. A bit can be either 0 or 1. 1
 * represent that the corresponding element is present in the subset, whereas 0
 * represent the corresponding element is not in the subset.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class GenerateSubSequences {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4 };
		generate(arr);
	}

	private static void generate(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < (1 << size); i++) {
			for (int j = 0; j < size; j++) {
				if (((1 << j) & i) > 0) {
					System.out.print(arr[j] + " ");
				}
			}

			if (i > 0) {
				System.out.println();
			}
		}
	}
}