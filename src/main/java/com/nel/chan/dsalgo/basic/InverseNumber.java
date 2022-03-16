package com.nel.chan.dsalgo.basic;

public class InverseNumber {

	public static void main(String[] args) {
		int num = 21453;
		System.out.println("Original Number ==> " + num);
		inverse(num);
	}

	private static void inverse(int num) {
		int count = CountNoOfDigits.count(num);
		int pos = 1;
		int rev = 0;
		while(count != 0) {
			int last = num % 10;
			rev = rev + ((int) Math.pow(10, last-1) * pos);
			num = num / 10;
			--count;
			++pos;
		}
		
		System.out.println("Inversal Number ==> " + rev);
	}
}
