package com.nel.chan.dsalgo.array.subset;

import java.util.Scanner;

public class SubSetElemSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			
			int elem = in.nextInt();
			System.out.println(findSubsetsSum(arr, elem));
		}

		in.close();
	}

	private static boolean findSubsetsSum(int[] arr, int elem) {
		int size = arr.length;
		for (int i = 0; i < (1 << size); i++) {
			int sum = 0;
			for (int j = 0; j < size; j++) {
				if ((i & (1 << j)) > 0) {
					sum = sum + arr[j];
				}
			}
			
			if(sum == elem) {
				return true;
			}
		}
		
		return false;
	}
}