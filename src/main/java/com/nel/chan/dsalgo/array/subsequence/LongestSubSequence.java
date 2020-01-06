package com.nel.chan.dsalgo.array.subsequence;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			findLongestConseqSubseq(arr);
		}

		in.close();
	}

	private static void findLongestConseqSubseq(int[] arr) {
		int n = arr.length;
		HashSet<Integer> set = new HashSet<>();
		int ans = 0;

		for (int i = 0; i < n; ++i) {
			set.add(arr[i]);
		}

		for (int i = 0; i < n; ++i) {
			if (!set.contains(arr[i] - 1)) {
				int j = arr[i];
				while (set.contains(j)) {
					j++;
				}

				if (ans < j - arr[i]) {
					ans = j - arr[i];
				}
			}
		}

		System.out.println(ans);
	}
}