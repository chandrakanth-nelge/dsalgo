package com.nel.chan.dsalgo.array.matrix;

import java.util.Scanner;

/**
 * Given a 2D square matrix, rotate the matrix by 90 degrees in clockwise
 * manner. Note: Try to solve it by first scanning the matrix, then do an
 * in-place rotation and then print the rotated matrix.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class RotationOfMatrix {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int noOfTestCases = scanner.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int[][] arr = getInputArray();
			rotate(arr);
		}

		scanner.close();
	}

	private static void rotate(int[][] matrix) {
		for (int j = 0; j < matrix.length; j++) {
			for (int i = matrix.length - 1; i >= 0; --i) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] getInputArray() {
		int arrSize = scanner.nextInt();
		int[][] inArray = new int[arrSize][arrSize];

		for (int i = 0; i < arrSize; i++) {
			for (int j = 0; j < arrSize; j++) {
				inArray[i][j] = scanner.nextInt();
			}
		}

		return inArray;
	}

}