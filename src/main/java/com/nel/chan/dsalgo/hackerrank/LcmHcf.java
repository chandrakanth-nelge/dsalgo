package com.nel.chan.dsalgo.hackerrank;

import java.util.Scanner;

/**
 * Given 2 numbers, find their LCM and HCF.
 * 
 * @author Chandrakanth Nelge
 */
public class LcmHcf {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			long num1 = in.nextLong();
			long num2 = in.nextLong();
			lcmAndHcf(num1, num2);
			System.out.println();
		}

		in.close();
	}

	private static void lcmAndHcf(long num1, long num2) {
		long temp1 = num1;
		long temp2 = num2;
		while (temp2 != 0) {
			long temp = temp2;
			temp2 = temp1 % temp2;
			temp1 = temp;
		}

		long hcf = temp1;
		long lcm = (num1 * num2) / hcf;
		System.out.print(lcm + " " + hcf);
	}
}