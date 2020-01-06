package com.nel.chan.dsalgo.recursion;

import java.util.Scanner;

public class NaturalNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		printNaturalNumbers(num);

		in.close();
	}

	private static void printNaturalNumbers(int num) {
		if (num == 0) {
			return;
		}

		printNaturalNumbers(num - 1);
		System.out.println(num);
	}
}