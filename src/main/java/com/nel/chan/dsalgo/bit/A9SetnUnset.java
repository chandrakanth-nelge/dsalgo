package com.nel.chan.dsalgo.bit;

public class A9SetnUnset {

	public static void main(String[] args) {
		int pos = 4;
		long num = 16;
		setBitAt(num, pos);
		unSetBitAt(num, pos);
		toggle(num, pos);
		isSetOrUnset(num, pos);
		setBitAtGivenPositions(3, 3);
		create(3, 5);
	}

	/**
	 * Set a bit at n’th position in the number
	 */
	private static void setBitAt(long num, int pos) {
		long temp = 1l << pos;
		long result = num | temp;
		System.out.println(result);
	}

	/**
	 * Unset/Clear a bit at n’th position in the number
	 */
	private static void unSetBitAt(long num, int pos) {
		long temp = 1l << pos;
		temp = ~temp;
		long result = num & temp;
		System.out.println(result);
	}

	/**
	 * Toggling means to turn bit 1 if it was 0 and vice-versa
	 */
	private static void toggle(long num, int pos) {
		long temp = 1l << pos;
		long result = num ^ temp;
		System.out.println(result);
	}

	/**
	 * Check if bit at nth position is set or un-set:
	 */
	private static void isSetOrUnset(long num, int pos) {
		long temp = 1l << pos;
		long result = num & temp;
		if (temp == result) {
			System.out.println("Bit is set");
		} else {
			System.out.println("Bit is unset");
		}
	}
	
	/**
	 * set bit at given positions
	 */
	private static void setBitAtGivenPositions(int pos1, int pos2) {
		long temp1 = 1l << pos1;
		long temp2 = 1l << pos2;
		long result = temp1 | temp2;
		System.out.println(result);
	}
	
	/**
	 * set bit at given positions
	 */
	private static void create(int num1, int num2) {
		long result = (~(~0<<num1)) << num2;
		System.out.println(result);
	}
}