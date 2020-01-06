package com.nel.chan.dsalgo.recursion;

import java.util.Scanner;

public class ReverseDigitsOfNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long num = in.nextLong();
		System.out.println(reverseDigitOfNumber(num));
		System.out.println(reverseDigitOfNumberRecusrsion(num, 0));
		in.close();
	}

	private static long reverseDigitOfNumber(long num) {
		long reversed = 0;
		while (num != 0) {
			long digit = num % 10;
			reversed = reversed * 10 + digit;
			num = num / 10;
		}

		return reversed;
	}

	private static long reverseDigitOfNumberRecusrsion(long num, long reversed) {
		if (num == 0) {
			return reversed;
		}

		long digit = num % 10;
		reversed = reversed * 10 + digit;
		num = num / 10;

		return reverseDigitOfNumberRecusrsion(num, reversed);
	}
}