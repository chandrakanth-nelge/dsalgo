package com.nel.chan.dsalgo.bit;

/**
 * @author Chandrakanth Nelge
 */
public class CheckGivenBitIsSet {

	public static void main(String[] args) {
		int num = 12;
		int index = 0;

		System.out.println(isBitSetAtGivenIndexRightShift(num, index));
		System.out.println(isBitSetAtGivenIndexLeftShift(num, index));
	}

	/**
	 * Right shift number to index's time and check LSB
	 */
	private static boolean isBitSetAtGivenIndexRightShift(int num, int index) {
		return ((num >> index) & 1) == 1;
	}

	/**
	 * The binary form of 2i contains only ith bit as set (or 1), else every bit is
	 * 0 there. When we will AND it with N, and if the ith bit of N is set, then it
	 * will return a non zero number (2i to be specific), else 0 will be returned.
	 */
	private static boolean isBitSetAtGivenIndexLeftShift(int num, int index) {
		return ((num & (1 << index)) != 0);
	}
}