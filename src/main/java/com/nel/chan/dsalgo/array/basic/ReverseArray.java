package com.nel.chan.dsalgo.array.basic;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 3, 4, 51, 23 };

		int[] res = new ReverseArray().reverse(arr);
		
		System.out.println(Arrays.toString(res));
	}

	public int[] reverse(int[] arr) {
		int p1 = 0;
		int p2 = arr.length-1;
		
		while(p1< p2) {
			int temp = arr[p1];
			arr[p1] = arr[p2];
			arr[p2] = temp;
			
			p1++;
			--p2;
		}
		
		return arr;
	}
}
