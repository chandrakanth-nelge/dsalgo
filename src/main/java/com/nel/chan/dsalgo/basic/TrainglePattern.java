package com.nel.chan.dsalgo.basic;

public class TrainglePattern {

	public static void main(String[] args) {
		int num = 5;
		printPattern(num);
		System.out.println("=============================");
		printPatternReverse(num);
		System.out.println("=============================");
		printPatternRever(num);
	}

	private static void printPattern(int num) {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}

	private static void printPatternReverse(int num) {
		for (int i = 0; i < num; i++) {
			int space = num - 1 - i;
			int star = num - space;
			for (int j = 1; j <= space; j++) {
				System.out.print(" " + " ");
			}

			for (int j = 1; j <= star; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}
	
	private static void printPatternRever(int num) {
		for (int i = num-1; i > 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}
}
