package com.nel.chan.dsalgo.array.matrix;

import java.util.Scanner;

/**
 * Given a 2D square matrix, print the matrix in a spiral order. Refer examples
 * for more details. From interviews point of view, after you scan the matrix in
 * a 2D array, try to print the matrix in a spiral order without using any extra
 * space.
 * 
 * @author Chandrakanth Nelge
 */
public class SprialMatrix {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[][] matrix = null;
		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int size = in.nextInt();
			matrix = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					matrix[i][j] = in.nextInt();
				}
			}

			spiralPrint(size, size, matrix);
			System.out.println();
		}

		in.close();
	}

	static void spiralPrint(int rowE, int colE, int[][] a) {
		int i = 0;
		int rowS = 0;
		int colS = 0;
		while (rowS < rowE && colS < colE) {
			// Print the first row from the remaining rows
			for (i = colS; i < colE; ++i) {
				System.out.print(a[rowS][i] + " ");
			}
			rowS++;

			// Print the last column from the remaining columns
			for (i = rowS; i < rowE; ++i) {
				System.out.print(a[i][colE - 1] + " ");
			}
			colE--;

			// Print the last row from the remaining rows */
			if (rowS < rowE) {
				for (i = colE - 1; i >= colS; --i) {
					System.out.print(a[rowE - 1][i] + " ");
				}
				rowE--;
			}

			// Print the first column from the remaining columns */
			if (colS < colE) {
				for (i = rowE - 1; i >= rowS; --i) {
					System.out.print(a[i][colS] + " ");
				}
				colS++;
			}
		}
	}
}