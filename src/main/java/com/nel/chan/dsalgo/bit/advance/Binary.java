package com.nel.chan.dsalgo.bit.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a positive integer, print its binary representation.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class Binary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int num = in.nextInt();
			if (num == 0) {
				System.out.print("0");
			} else {
				binaryRecursion(num);
				binaryIterative(num);
			}

			System.out.println();
		}

		in.close();
	}

	private static void binaryRecursion(int num) {
		if (num == 0) {
			return;
		}

		binaryRecursion(num / 2);
		System.out.print(num % 2);
	}

	private static void binaryIterative(int n) {
		StringBuilder builder = new StringBuilder("");
		while (n != 0) {
			if ((n & 1) == 1) {
				builder.append(1);
			} else {
				builder.append(0);
			}
			n = n >> 1;
		}

		System.out.println(builder.toString());
	}

	/**
	 * (/) --> Gives Quotient (%) --> Gives Reminder O(logN), O(N)
	 */
	@SuppressWarnings("unused")
	private static void binary(int num) {
		List<Integer> binList = new ArrayList<>(14);
		while (num != 0) {
			binList.add(num % 2);
			num = num / 2;
		}
		for (int i = 0; i < (14 - binList.size() - 1); i++) {
			System.out.print("0");

		}
		for (int i = binList.size() - 1; i >= 0; i--) {
			System.out.print(binList.get(i));
		}
	}

	@SuppressWarnings("unused")
	private static void binaryBit(int num) {
		List<Integer> binList = new ArrayList<>(14);
		while (num != 0) {
			binList.add(num & 1);
			num = num >> 1;
		}

		for (int i = 0; i < (14 - binList.size() - 1); i++) {
			System.out.print("0");

		}
		for (int i = binList.size() - 1; i >= 0; i--) {
			System.out.print(binList.get(i));
		}
	}
}