package com.nel.chan.dsalgo.bit.advance;

import java.util.Scanner;

public class XorSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			long left = in.nextLong();
			long right = in.nextLong();
			long res = computeXOR(left - 1) ^ computeXOR(right);
			System.out.println(res);
		}

		in.close();
	}

	static long computeXOR(long num) {
		long mod = num % 8;
	    if(mod == 0 || mod == 1) return num;
	    if(mod == 2 || mod == 3) return 2;
	    if(mod == 4 || mod == 5) return num+2;
	    if(mod == 6 || mod == 7) return 0;
	    return 0;
    } 
}