package com.nel.chan.dsalgo.bit;

/**
 * @author Chandrakanth Nelge
 */
public class FindPowerOfTwo {

	public static void main(String[] args) {
		int num = 5;
		System.out.println(getPowerOfTwo(num));

		int num1 = 5;
		int num2 = 5;
		System.out.println(getAdditionOfPowerOfTwo(num1, num2));
	}

	/**
	 * BasicBitOperation::doLeftShift
	 */
	private static int getPowerOfTwo(int num) {
		return 1 << num;
	}

	// Don't use addition
	private static int getAdditionOfPowerOfTwo(int num1, int num2) {
		return getPowerOfTwo(num1) | getPowerOfTwo(num2);
	}
}