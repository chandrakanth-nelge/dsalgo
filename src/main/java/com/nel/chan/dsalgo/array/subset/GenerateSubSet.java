package com.nel.chan.dsalgo.array.subset;

public class GenerateSubSet {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 5, 7 };
		iterative(arr);
	}

	private static void iterative(int[] arr) {
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

	static void recurssive(String str, int index, String curr) {
		int n = str.length();

		if (index == n) {
			return;
		}

		System.out.println(curr);
		for (int i = index + 1; i < n; i++) {
			curr += str.charAt(i);
			recurssive(str, i, curr);
			curr = curr.substring(0, curr.length() - 1);
		}
	}
}