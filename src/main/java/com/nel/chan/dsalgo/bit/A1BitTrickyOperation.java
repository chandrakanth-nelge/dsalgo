package com.nel.chan.dsalgo.bit;

import java.util.Scanner;

public class A1BitTrickyOperation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		
		doOperWithSameNum(num);
		System.out.println("==============");
		doOperWithZero(num);
		System.out.println("==============");
		doOperWithOne(num);
	}
	
	/**
	 * num & num = num
	 * num | num = num
	 * num ^ num = 0
	 */
	private static void doOperWithSameNum(int num) {
		System.out.println(num + " & " + num + " => " + (num & num));
		System.out.println(num + " | " + num + " => " + (num | num));
		System.out.println(num + " ^ " + num + " => " + (num ^ num));
	}

	/**
	 * num & 0 = 0
	 * num | 0 = num
	 * num ^ 0 = num
	 */
	private static void doOperWithZero(int num) {
		System.out.println(num + " & " + "0 => " + (num & 0));
		System.out.println(num + " | " + "0 => " + (num | 0));
		System.out.println(num + " ^ " + "0 => " + (num ^ 0));
	}
	
	/**
	 * num & 1 = 0
	 * num | 1 = num
	 * num ^ 1 = num
	 */
	private static void doOperWithOne(int num) {
		System.out.println(num + " & " + "1 => " + (num & 1));
		System.out.println(num + " | " + "1 => " + (num | 1));
		System.out.println(num + " ^ " + "1 => " + (num ^ 1));
	}
}
