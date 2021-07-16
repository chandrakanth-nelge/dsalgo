package com.nel.chan.dsalgo.bit.advance;

import java.util.Scanner;

public class SumVsXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long num = in.nextLong();
		sumVsXor(num);
		in.close();
	}
	
	private static void sumVsXor(long num) {
		int count = 0;
		for (long i=1; i<num; i++) {
			long sum = num + i;
			long xor = num ^ i;
			
			if(sum == xor) {
				System.out.println("i = " + i + " sum = "+ sum);
				++count;
			}
		}
		
		System.out.println(count);
	}

}
