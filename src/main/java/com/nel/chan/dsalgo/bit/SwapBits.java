package com.nel.chan.dsalgo.bit;

import java.util.Scanner;

/**
 * Given a number, swap the adjacent bits in the binary representation of the
 * number, and print the new number formed after swapping.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class SwapBits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int num = in.nextInt();
			swapBits(num);
		}

		in.close();
	}

	private static void swapBits(int num) {
		int evenBits = num & 0xAAAAAAAA;
		int oddBits = num & 0x55555555;

		evenBits = evenBits >> 1;
		oddBits = oddBits << 1;

		System.out.println((evenBits | oddBits));
	}

	@SuppressWarnings("unused")
	private static long solve(int n) {
		return ((n & 715827882) >> 1) | ((n & 1431655765) << 1);
	}
}