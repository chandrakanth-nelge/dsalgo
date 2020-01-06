package com.nel.chan.dsalgo.recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		
		System.out.println(fact(num));
		System.out.println(natural(num));

		star(num);
		System.out.println("=================");
		star2(num);

		fac(num);
	}

	private static void fac(int num) {
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		System.out.println("Factorial of " + num + " is: " + fact);
	}

	private static int fact(int num) {
		if (num <= 0) {
			return 1;
		} else {
			return num * fact(num - 1);
		}
	}

	private static int natural(int num) {
		if (num == 0) {
			return 0;
		} else {
			return num + natural(num - 1);
		}
	}

	private static void star(int num) {
		int i = 0;
		if (num > 1) {
			star(num - 1);
		}
		for (i = 0; i < num; i++) {
			System.out.print(" * ");
		}
		System.out.println();
	}

	private static void star2(int num) {
		int i = 0;
		for (i = 0; i < num; i++) {
			System.out.print(" * ");
		}
		System.out.println();

		if (num > 1) {
			star2(num - 1);
		}
	}
}