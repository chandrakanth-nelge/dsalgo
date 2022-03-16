package com.nel.chan.dsalgo.bit;

import java.util.Scanner;

/**
 * @author Chandrakanth Nelge
 */
public class A6CountNumberZOfConsecutiveSetBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			long num = in.nextLong();
			System.out.println(setBits(num));
		}

		in.close();
	}

	/**
	 * The idea is based on the concept that if we AND a bit sequence with a shifted
	 * version of itself, we’re effectively removing the trailing 1 from every
	 * sequence of consecutive 1s.So the operation x = (x & (x << 1)) reduces length
	 * of every sequence of 1s by one in binary representation of x.If we keep doing
	 * this operation in a loop, we end up with x = 0. The number of iterations
	 * required to reach 0 is actually length of the longest consecutive sequence of
	 * 1's.
	 */
	private static int setBits(long num) {
		int count = 0;
		while (num != 0) {
			++count;
			num = num & (num << 1);
		}

		return count;
	}
}