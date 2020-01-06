package com.nel.chan.dsalgo.hackerrank;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][n];
		for (int a_i = 0; a_i < n; a_i++) {
			for (int a_j = 0; a_j < n; a_j++) {
				arr[a_i][a_j] = in.nextInt();
			}
		}
		in.close();
		
		int result = diagonalDifference(arr);
		System.out.println(result);
	}

	static int diagonalDifference(int[][] a) {
		int d1 = 0;
		int d2 = 0;
		int size = a.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// finding sum of primary diagonal
				if (i == j) {
					d1 += a[i][j];
				}

				// finding sum of secondary diagonal
				if (i == (size - j - 1)) {
					d2 += a[i][j];
				}
			}
		}

		// Absolute difference of the sums
		return Math.abs(d1 - d2);
	}
}