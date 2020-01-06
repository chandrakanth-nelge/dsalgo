package com.nel.chan.dsalgo.recursion;

public class RecTest1 {

	public static void print(int number) {
		if (number == 0) {
			return;
		}

		System.out.println(number);
		print(--number);
	}

	public static void main(String[] args) {
		print(5);
		System.out.println("=======");
		printHallowTriangle(5, 5);
	}
	
	private static void printHallowTriangle(int num, int index) {
		if(num > 1) {
			printHallowTriangle(num-1, index);
		}
		
		for(int i=0; i<index-num; i++) {
			System.out.print(" ");
		}
		
		for(int i=0; i<num; i++) {
			System.out.print("*");
		}
		
		System.out.println();
	}
}