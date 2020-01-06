package com.nel.chan.dsalgo.hackerrank;

import java.util.Scanner;

/**
 * Print hollow diamond pattern using '*'.
 * @author Chandrakanth Nelge
 * 
 * Sample Input
 * 2
 * 3
 * 7
 * Sample Output
 * 		*
 *	   * *
 *      *

 *      *
 * 	   * *
 *    *   *
 *   *     *
 *    *   *
 *     * *
 *      *
 */
public class PrintHollowDiamondPattern {

	public static void main(String[] args) {
		int[] patternArr = getInputArray();
		drawHollowDiamondPattern(patternArr);
	}

	private static void drawHollowDiamondPattern(final int[] patternArr) {
		for (int k = 0; k < patternArr.length; k++) {
			System.out.println("Case #" + (k + 1) + ":");
			int patternSize = patternArr[k];
			int mid = patternSize / 2;
			for (int i = 0; i < patternSize; i++) {
				for (int j = 0; j < patternSize; j++) {
					if (i <= mid) {
						if (j == (mid - i)) {
							System.out.print("*");
						} else if (j == (mid + i)) {
							System.out.print("*");
							break;
						} else {
							System.out.print(" ");
						}
					} else {
						if (j == (i - mid)) {
							System.out.print("*");
						} else if (j == (patternSize - (i - mid) - 1)) {
							System.out.print("*");
							break;
						} else {
							System.out.print(" ");
						}
					}
				}
				
				System.out.println();
			}
		}
	}

	public static int[] getInputArray() {
		Scanner input = new Scanner(System.in);
		int arrSize = input.nextInt();
		int[] inArray = new int[arrSize];
		int size = 0;
		while (size != arrSize) {
			int num = input.nextInt();
			if (num % 2 != 0) {
				inArray[size] = num;
				size++;
			}
		}
		input.close();

		return inArray;
	}

}
