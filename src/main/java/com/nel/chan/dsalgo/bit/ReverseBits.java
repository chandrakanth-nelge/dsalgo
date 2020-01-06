package com.nel.chan.dsalgo.bit;

import java.util.Scanner;

/**
 * Given a number, reverse the bits in the binary representation (consider
 * 32-bit unsigned data) of the number, and print the new number formed.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class ReverseBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int num = in.nextInt();
			reverseBits(num);
		}

		in.close();
	}

	private static void reverseBits(int num) {
		long sum = 0;

		int index = 31;
		while (num != 0) {
			if ((num & 1) == 1) {
				sum = sum + (1l << index);
			}
			num = num >> 1;
			index--;
		}

		System.out.println(sum);
	}
}