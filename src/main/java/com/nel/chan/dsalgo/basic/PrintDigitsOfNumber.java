package com.nel.chan.dsalgo.basic;

public class PrintDigitsOfNumber {

	public static void main(String[] args) {
		int num = 7542;
		print(num);
		System.out.println("=================");
		printReverse(num);
	}

	private static void print(int num) {
		int count = CountNoOfDigits.count(num);
		while (count != 0) {
			int denom = (int) Math.pow(10, count-1);
			int digit = num / denom;
			System.out.println(digit);
			num = num % (denom);
			--count;
		}
	}
	
	private static void printReverse(int num) {
		while (num != 0) {
			System.out.println(num % 10);
			num = num / 10;
		}
	}
}
