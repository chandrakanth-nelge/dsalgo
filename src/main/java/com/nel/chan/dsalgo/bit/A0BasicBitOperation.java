package com.nel.chan.dsalgo.bit;

import java.util.Scanner;

/**
 * @author Chandrakanth Nelge
 */
public class A0BasicBitOperation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		scanner.close();
		
		doAnd(num1, num2);
		doOr(num1, num2);
		doXor(num1, num2);
		doNot(num1);
		doLeftShift(num1, 1);
		doRightShift(num1, 1);

		doDivisionQuotient(num1, num2);
		doDivisionReminder(num1, num2);
	}

	/**
	 * If both bits in the compared position of the bit patterns are 1,
	 * the bit in the resulting bit pattern is 1, otherwise 0.
	 */
	private static void doAnd(int num1, int num2) {
		int result = num1 & num2;
		System.out.println(num1 + " & " + num2 + " = " + result);
	}

	/**
	 * If both bits in the compared position of the bit patterns are 0,
	 * the bit in the resulting bit pattern is 0, otherwise 1.
	 */
	private static void doOr(int num1, int num2) {
		int result = num1 | num2;
		System.out.println(num1 + " | " + num2 + " = " + result);
	}

	/**
	 * If both bits in the compared position of the bit patterns are 0 or 1,
	 * the bit in the resulting bit pattern is 0, otherwise 1.
	 */
	private static void doXor(int num1, int num2) {
		int result = num1 ^ num2;
		System.out.println(num1 + " ^ " + num2 + " = " + result);
	}

	/**
	 * If the ith bit is 0, it will change it to 1 and vice versa.
	 * Bitwise NOT is nothing but simply the one’s complement of a number.
	 */
	private static void doNot(int num) {
		int result = ~num;
		System.out.println("~" + num + " = " + result);
	}

	/**
	 * Left shift is equivalent to multiplying the bit pattern with
	 * (if we are shifting k bits ).
	 */
	private static void doLeftShift(int num, int numOfShift) {
		int result = num << numOfShift;
		System.out.println(num + " << " + numOfShift + " = " + result);
	}

	/**
	 * Right shift is equivalent to dividing the bit pattern with 2k
	 * (if we are shifting k bits ).
	 */
	private static void doRightShift(int num, int numOfShift) {
		int result = num >> numOfShift;
		System.out.println(num + " >> " + numOfShift + " = " + result);
	}

	/**
	 * It returns Quotient of the division
	 */
	private static void doDivisionQuotient(int num1, int num2) {
		int quotient = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + quotient);
	}

	/**
	 * It returns Reminder of the division
	 */
	private static void doDivisionReminder(int num1, int num2) {
		int reminder = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + reminder);
	}
}