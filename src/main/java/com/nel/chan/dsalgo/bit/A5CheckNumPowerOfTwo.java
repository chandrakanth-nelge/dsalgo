package com.nel.chan.dsalgo.bit;

/**
 * Properties for numbers which are powers of 2, is that they have one and only
 * one bit set in their binary representation.
 * 
 * @author Chandrakanth Nelge
 */
public class A5CheckNumPowerOfTwo {

	public static void main(String[] args) {
		int num = 1;

		System.out.println(isPowerTwoBitOptimized(num));
		System.out.println(isPowerTwoBitShift(num));
		System.out.println(isPowerTwoIterative(num));
	}

	/**
	 * (x-1) will have all the bits same as x, except for the rightmost 1 in x and
	 * all the bits to the right of the rightmost 1.
	 */
	private static boolean isPowerTwoBitOptimized(int num) {
		return (num & (num - 1)) == 0;
	}

	/**
	 * Power Of 2 number going to have only one bit set
	 * Right shift and count number of 1's
	 */
	private static boolean isPowerTwoBitShift(int num) {
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				++count;
				if (count > 1) {
					break;
				}
			}

			num = num >> 1;
		}
		
		return (count == 1);
	}

	/**
	 * Repeatedly divide N by 2, If we end up with a 1 then N is power of 2,
	 * If N = 0 then it is not a power of 2.
	 * O(logN)
	 */
	private static boolean isPowerTwoIterative(int num) {
		if (num == 0) {
			return false;
		}

		while (num % 2 == 0) {
			num /= 2;
		}

		return (num == 1);
	}
}