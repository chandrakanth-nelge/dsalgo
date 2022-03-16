package com.nel.chan.dsalgo.basic;

public class CountNoOfDigits {

	public static void main(String[] args) {
		int num = 754;

		int count = count(num);
		System.out.println(count);
	}

	public static int count(int num) {
		int count = 0;
		while (num != 0) {
			num = num / 10;
			++count;
		}

		return count;
	}
}
