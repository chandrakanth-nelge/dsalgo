package com.nel.chan.dsalgo.bit.advance;

import java.util.Scanner;

public class CounterGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			String result = counterGame(n);
			System.out.println(result);
		}
		in.close();
	}

	static String counterGame(long n) {
		boolean richard = true;
		while (n > 1) {
			if ((n & (n - 1)) == 0) {
				n = n >> 1;
			} else {
				n = n - largestPowerOf2(n);
			}
			
			richard = !richard;
		}

		return richard ? "Richard" : "Louise";
	}

	static boolean isPowerOfTwoBit(long num) {
		long result = num & (num - 1);
		return (result == 0);
	}

	static long largestPowerOf2(long n) {
		long p = 2;
		while (p <= n) {
			p = 2 * p;
		}
		p = p / 2;

		return p;
	}
}