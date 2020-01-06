package com.nel.chan.dsalgo.bit.advance;

import java.util.Scanner;

public class GenerateTwoSetBitNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long num = in.nextLong();
		in.close();

		generateNumbers(num);
	}

	private static void generateNumbers(long num) {
		int count = 0;
		for (int i=1; i<=num; i++) {
			int result = getAdditionOfPowerOfTwo(i, (i - 1));
			System.out.println(result);
			count++;
		}
		
		System.out.println(count);
	}

	// Don't use addition
	private static int getAdditionOfPowerOfTwo(int num1, int num2) {
		return getPowerOfTwo(num1) | getPowerOfTwo(num2);
	}
	
	private static int getPowerOfTwo(int num) {
		return 1 << num;
	}
}