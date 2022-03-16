package com.nel.chan.dsalgo.basic;

public class ReverseNumber {

	public static void main(String[] args) {
		int num = 7504;
		System.out.println("Original Number ==> " + num);
		reverse(num);
	}

	private static void reverse(int num) {
		int rev = 0;
		int count = CountNoOfDigits.count(num);
		while(count != 0) {
			int last = num % 10;
			rev = rev + (int)Math.pow(10, count-1)  * last;
			num = num / 10;
			--count;
		}
		
		System.out.println("Reversed Number ==> " + rev);
	}
}
