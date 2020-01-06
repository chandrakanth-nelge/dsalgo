package com.nel.chan.dsalgo.array.matrix;

import java.util.Scanner;

/**
 * Given a 2D matrix of size NxN, print the sum of the elements of all its
 * diagonals.
 * 
 * @author Chandrakanth Nelge
 */
public class SumOfDaignol {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();

		for (int k = 0; k < testCases; k++) {
			int size = in.nextInt();
			int[] sumOfDaignol = new int[size * 2 - 1];
			int mid = sumOfDaignol.length / 2;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (i == j) {
						sumOfDaignol[mid] = sumOfDaignol[mid] + in.nextInt();
					} else if (i > j) {
						int num = in.nextInt();
						sumOfDaignol[mid - (j - i)] = sumOfDaignol[mid - (j - i)] + num;
					} else {
						int num = in.nextInt();
						sumOfDaignol[mid + (i - j)] = sumOfDaignol[mid + (i - j)] + num;
					}
				}
			}

			for (int i = 0; i < sumOfDaignol.length; i++) {
				System.out.print(sumOfDaignol[i] + " ");
			}
			System.out.println();
		}

		in.close();
	}
}
