package com.nel.chan.dsalgo.hackerrank;

import java.util.Scanner;

/**
 * Count the number of trailing 0s in factorial of a given number
 * 
 * @author Chandrakanth Nelge
 */
public class TrailingZeros {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			long num = in.nextLong();
			double result = fact(num);
			System.out.println(result);
			findZeros(result);
			System.out.println("=========");
			solve(num);
		}

		in.close();
	}

	private static void solve(long n) {
		long count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
		System.out.println(count);
	}

	private static double fact(double num) {
		if (num == 0) {
			return 1;
		} else {
			return num * fact(num - 1);
		}
	}

	private static void findZeros(double num) {
		int zerosCount = 0;
		while (num != 0) {
			double reminder = num % 10;
			if (reminder == 0) {
				++zerosCount;
			} else {
				break;
			}
			num = num / 10;
		}

		System.out.println(zerosCount);
	}
}