package com.nel.chan.dsalgo.hackerrank;

import java.util.Scanner;

/**
 * Print mirror image of right-angled triangle using '*'.
 * @author Chandrakanth Nelge
 * 
 * Sample Input 0
 * 2
 * 2
 * 5
 * Sample Output 0
 * Case #1:
 *	 *
 *	**
 *	Case #3:
 *      *
 *     **
 *    ***
 *   ****
 *  *****
 */
public class PrintRightAngledTrianglePattern {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		int[] patternArr = new int[noOfTestCases];
		for(int i = 0; i <noOfTestCases; i++) {
			patternArr[i] = in.nextInt();
		}
		in.close();
		
		for(int i = 0; i <noOfTestCases; i++) {
			drawRightAngledTrianglePatternReverseBetter(patternArr[i]);
		}
	}
	
	@SuppressWarnings("unused")
	private static void drawRightAngledTrianglePattern(final int patternSize) {
		for(int i = 0; i < patternSize; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
	
	@SuppressWarnings("unused")
	private static void drawRightAngledTrianglePatternReverse(final int patternSize) {
		int colEnd = patternSize - 1;
		for(int i = 0; i < patternSize; i++) {
			for(int j = 0; j < patternSize; j++) {
				if(j < colEnd) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			
			System.out.println();
			colEnd = colEnd - 1;
		}
	}
	
	private static void drawRightAngledTrianglePatternReverseBetter(final int patternSize) {
		for(int i = 0; i < patternSize; i++) {
			for(int j = 0; j < (patternSize -(i+1)); j++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j <=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public static void printTriagle(int n) {
        for (int i=0; i<n; i++) {
            for (int j=n-i; j>1; j--) {
                System.out.print(" "); 
            } 
   
            for (int j=0; j<=i; j++ ) {
                System.out.print("* "); 
            } 
   
            System.out.println(); 
        } 
    }
	
	//RE-LOOK
	@SuppressWarnings("unused")
	private static void staircase(int n) {
		for (int i = 0; i < n; i++) {
			int spaceCount = n - (i + 1);
			for (int j = 0; j < spaceCount; j++) {
				System.out.print(" ");
			}

			int hashCount = n - spaceCount;
			for (int k = 0; k < hashCount; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}