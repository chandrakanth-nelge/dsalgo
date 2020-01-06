package com.nel.chan.dsalgo.array.matrix;

import java.util.Scanner;

/**
 * Given 2 matrices, find the product.
 * 
 * @author Chandrakanth Nelge
 * 
 *         Sample input 2 2 2 1 2
 * 
 *         3 -1 2 3
 * 
 *         Sample Output 5 4 1 1 -9 10
 *
 */
public class ProductMatrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[][] matrix1 = null;
		int[][] matrix2 = null;
		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int row1 = in.nextInt();
			int col1 = in.nextInt();
			matrix1 = new int[row1][col1];
			for (int i = 0; i < row1; i++) {
				for (int j = 0; j < col1; j++) {
					matrix1[i][j] = in.nextInt();
				}
			}

			int row2 = in.nextInt();
			int col2 = in.nextInt();
			matrix2 = new int[row2][col2];
			for (int i = 0; i < row2; i++) {
				for (int j = 0; j < col2; j++) {
					matrix2[i][j] = in.nextInt();
				}
			}

			findProductMatrix(matrix1, row1, col1, matrix2, row2, col2);
		}

		in.close();
	}

	private static void findProductMatrix(int[][] matrix1, int r1, int c1, int[][] matrix2, int r2, int c2) {
		for (int i = 0; i < r1; i++) {
			for (int j = 0; j < c2; j++) {
				int sum = 0;
				for (int k = 0; k < c1; k++) {
					sum = sum + (matrix1[i][k] * matrix2[k][j]);
				}
				System.out.print(sum + " ");
			}
			System.out.println();
		}
	}
}