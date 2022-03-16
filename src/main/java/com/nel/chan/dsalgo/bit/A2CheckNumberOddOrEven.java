package com.nel.chan.dsalgo.bit;

/**
 * @author Chandrakanth Nelge
 */
public class A2CheckNumberOddOrEven {

	public static void main(String[] args) {
		int num = 11;
		isNumEvenOrOdd(num);
	}

	/***
	 * The value of expression (number & 1) would be non-zero only if number is odd,
	 * otherwise the value would be zero.
	 */
	private static void isNumEvenOrOdd(int num) {
		if ((num & 1) == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}
}