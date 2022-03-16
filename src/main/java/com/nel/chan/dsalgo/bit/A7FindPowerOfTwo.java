package com.nel.chan.dsalgo.bit;

/**
 * @author Chandrakanth Nelge
 */
public class A7FindPowerOfTwo {

	public static void main(String[] args) {
		int num = 5;
		System.out.println(findPowerOfTwo(num));

		System.out.println("=======>>");
		System.out.println(findPowerOfTwoMath(num));
	}

	private static long findPowerOfTwoMath(int num) {
		long ans = 1;
		for (int i = 0; i < num; i++) {
			ans = ans * 2;
		}

		return ans;
	}

	/**
	 * BasicBitOperation::doLeftShift
	 */
	private static long findPowerOfTwo(int num) {
		return 1l << num;
	}
}