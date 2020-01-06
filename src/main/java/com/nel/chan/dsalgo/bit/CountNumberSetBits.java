package com.nel.chan.dsalgo.bit;

/**
 * @author Chandrakanth Nelge
 */
public class CountNumberSetBits {

	public static void main(String[] args) {
		int num = 6;
		System.out.println(countNumOfOnesBitShift(num));
		System.out.println(countNumOfOnesBitOptimized(num));
	}

	/**
	 * The relationship between the bits of x and x-1. So as in x-1, the rightmost 1
	 * and bits right to it are flipped, then by performing x&(x-1), and storing it
	 * in x, will reduce x to a number containing number of ones(in its binary form)
	 * less than the previous state of x, thus increasing the value of count in each
	 * iteration.
	 */
	public static int countNumOfOnesBitOptimized(int num) {
		int count = 0;
		while (num != 0) {
			++count;
			num = num & (num - 1);
		}

		return count;
	}

	/**
	 * Evaluate the binary form of a number is to traverse on it
	 * and count the number of ones.
	 */
	public static int countNumOfOnesBitShift(int num) {
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				++count;
			}
			num = num >> 1;
		}

		return count;
	}
}