package com.nel.chan.dsalgo.array.rearrange;

import java.util.Arrays;
import java.util.Scanner;

public class MultiArrayReverse {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int rowCount = getRowCount();
		int colCount = getColCount();
		int[][] mulDimenArr = readMultiDimensionalArray(rowCount, colCount);
		System.out.println();
		printMultiDimensionalArray(mulDimenArr, rowCount, colCount);
		System.out.println();
		reverseMultiDimensionalArray(mulDimenArr, rowCount, colCount);
		System.out.println();

		in.close();
	}

	private static int[][] readMultiDimensionalArray(int rowCount, int colCount) {
		System.out.println("Enter multi dimensional array elements");
		int[][] mulDimenArr = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				mulDimenArr[i][j] = in.nextInt();
			}
		}

		return mulDimenArr;
	}

	private static void printMultiDimensionalArray(int[][] mulDimenArr, int rowCount, int colCount) {
		System.out.println("Printing multi dimensional array elements");
		for (int i = 0; i < rowCount; i++) {
			System.out.print("[");
			for (int j = 0; j < colCount; j++) {
				if (j == colCount - 1) {
					System.out.print(mulDimenArr[i][j]);
				} else {
					System.out.print(mulDimenArr[i][j] + ", ");
				}
			}
			System.out.print("]");
			System.out.println();
		}
	}

	private static void reverseMultiDimensionalArray(int[][] mulDimenArr, int rowCount, int colCount) {
		System.out.println("Reversing multi dimensional array");
		for (int i = 0; i < colCount; i++) {
			System.out.print("[");
			for (int j = 0; j < rowCount; j++) {
				if (j == rowCount - 1) {
					System.out.print(mulDimenArr[j][i]);
				} else {
					System.out.print(mulDimenArr[j][i] + ", ");
				}
			}
			System.out.print("]");
			System.out.println();
		}
	}

	@SuppressWarnings("unused")
	private static void printMultiDimensionalArray(int[][] mulDimenArr) {
		System.out.println("Printing multi dimensional array elements");
		for (int[] rowArr : mulDimenArr) {
			System.out.println(Arrays.toString(rowArr));
		}
	}

	private static int getRowCount() {
		System.out.println("Enetr row count");
		return in.nextInt();
	}

	private static int getColCount() {
		System.out.println("Enetr column count");
		return in.nextInt();
	}
}