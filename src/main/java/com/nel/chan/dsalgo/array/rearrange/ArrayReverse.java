package com.nel.chan.dsalgo.array.rearrange;

import java.util.Scanner;

public class ArrayReverse {

	public static void main(String[] args) {
		int[] inArr = readOneDimensionalArray();
		printOneDimensionalArray(inArr);
		int[] revArr = reverseOneDimensionalArray(inArr);
		printOneDimensionalArray(revArr);
	}

	private static int[] readOneDimensionalArray() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enetr size of the array");
		int size = in.nextInt();
		System.out.println("Enter array elements");
		int[] oneDimenArr = new int[size];
		for (int i = 0; i < size; i++) {
			oneDimenArr[i] = in.nextInt();
		}
		in.close();

		return oneDimenArr;
	}

	private static void printOneDimensionalArray(int[] oneDimenArr) {
		System.out.println("Printing array elements");
		System.out.print("[");
		for (int i = 0; i < oneDimenArr.length; i++) {
			if (i == oneDimenArr.length - 1) {
				System.out.print(oneDimenArr[i]);
			} else {
				System.out.print(oneDimenArr[i] + ", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}

	private static int[] reverseOneDimensionalArray(int[] inArr) {
		int[] revArr = new int[inArr.length];
		System.out.println("=========Reversing array elements========");
		int j = 0;
		for (int i = inArr.length - 1; i >= 0; i--) {
			revArr[j++] = inArr[i];
		}

		return revArr;
	}
}