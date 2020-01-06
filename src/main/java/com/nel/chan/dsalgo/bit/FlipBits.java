package com.nel.chan.dsalgo.bit;

import java.util.Scanner;

/**
 * You are given two numbers A and B. Write a program to count the number of
 * bits to be flipped to change the number A to the number B.
 * 
 * @author Chandrakanth Nelge
 */
public class FlipBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int num1 = in.nextInt();
			int num2 = in.nextInt();

			int count = findFlipBits(num1, num2);
			System.out.println(count);
		}

		in.close();
	}

	private static int findFlipBits(int num1, int num2) {
		int result = num1 ^ num2;
		return countNumOfOnes(result);
	}

	private static int countNumOfOnes(int num) {
		int onesCount = 0;
		while (num != 0) {
			++onesCount;
			num = num & (num - 1);
		}

		return onesCount;
	}
}