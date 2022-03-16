package com.nel.chan.dsalgo.bit;

import java.util.Scanner;

public class A8CheckAllBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int num = in.nextInt();
			if (checkBits(num) && checkBitsOptimized(num)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

		in.close();
	}

	private static boolean checkBitsOptimized(int num) {
		if ((num & 1) == 0) {
			return false;
		}

		return isPowerTwoBitOptimized(num + 1);
	}

	private static boolean isPowerTwoBitOptimized(int num) {
		return (num & (num - 1)) == 0;
	}

	private static boolean checkBits(int num) {
		if ((num & 1) == 0) {
			return false;
		}

		boolean isZeroPresent = false;
		while (num != 0) {
			if (((num & 1) == 1)) {
				if (isZeroPresent) {
					return false;
				}
			} else {
				isZeroPresent = true;
			}
			num = num >> 1;
		}

		return true;
	}
}