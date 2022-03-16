package com.nel.chan.dsalgo.array.easy;

import java.util.Arrays;

public class WaveArray {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		waveArray(arr);
	}
	
	private static void waveArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length-1; i=i+2) {
			int temp = arr[i+1];
			arr[i+1] = arr[i];
			arr[i] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
