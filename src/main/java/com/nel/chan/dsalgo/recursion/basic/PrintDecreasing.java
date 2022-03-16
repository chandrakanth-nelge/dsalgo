package com.nel.chan.dsalgo.recursion.basic;

public class PrintDecreasing {

	public static void main(String[] args) {
		int num = 5;
		printDecreasing(num);
		System.out.println("============");
		printDecreasingRecur(num);
	}

	private static void printDecreasing(int num) {
		while(num > 0) {
			System.out.println(num);
			--num;
		}
	}
	
	private static void printDecreasingRecur(int num) {
		if(num == 0) {
			return;
		}
		System.out.println(num);
		printDecreasing(num-1);
	}
}
