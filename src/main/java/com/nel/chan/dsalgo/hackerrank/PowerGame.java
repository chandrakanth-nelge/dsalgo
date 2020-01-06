package com.nel.chan.dsalgo.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class PowerGame {

	public static int solve(int[] a, int[] b, int n) {
		Arrays.sort(a);
		Arrays.sort(b);
		int i; 
		int j;
		int k = 0;
		int count = 0;
		if (a[n - 1] > b[0]) {
			for (i = 0; i < n; i++) {
				for (j = k; j < n; j++) {
					if (a[i] > b[j]) {
						count++;
						k = j + 1;
						break;
					} else if (a[i] < b[n - 1]) {
						break;
					}
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		/*int n = 2;
		int[] a = new int[] { 3,7,10 };
		int[] b = new int[] { 5,20,15};
		System.out.println(solve(a, b, n));*/
		
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int size = in.nextInt();
			int[] arr1 = new int[size];
			for (int i = 0; i < size; i++) {
				arr1[i] = in.nextInt();
			}
			
			int[] arr2 = new int[size];
			for (int i = 0; i < size; i++) {
				arr2[i] = in.nextInt();
			}

			int count = solve(arr1, arr2, arr1.length);
			System.out.println(count);
		}

		in.close();
	}

}
