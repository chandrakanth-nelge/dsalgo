package com.nel.chan.dsalgo.basic;

public class BasicTest {

	public static void main(String[] args) {
		int num = 7;
		print1(num);
	}
	
	private static void print1(int num) {
		int st = 1;
		int sp =0;
		for (int i = 0; i < num; i++) {
			for(int j=0; j<sp; j++) {
				System.out.print(" " + " ");
			}
			
			for (int j = 0; j < st; j++) {
				System.out.print("*" + " ");
			}
			
			System.out.println();
			sp++;
		}
	}

	private static void print(int num) {
		int mid = num / 2;
		int st = mid + 1;
		int sp = (num + 2) - st * 2;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < st; j++) {
				System.out.print("*" + " ");
			}
			for (int j = 0; j < sp; j++) {
				System.out.print(" " + " ");
			}
			for (int j = 0; j < st; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();

			if (i < mid) {
				--st;
				sp += 2;
			} else {
				++st;
				sp -= 2;
			}
		}
	}

}
