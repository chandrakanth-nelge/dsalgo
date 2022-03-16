package com.nel.chan.dsalgo.array.basic;

import java.util.Arrays;

/***
 * @author techmojo
 * 
 * Given an unsorted array arr[] of size N, rotate it by D elements (Anti - clockwise). 
 */
public class RotateLeft {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 8, 10, 13 };
		int k = 3;
		
		int count = 0;
        for(int i=0; i<arr.length; i++) {
            int div = arr[i] / k;
            
            count = count + (div + 1);
            
            System.out.println("count = " + count);
        }
        
        System.out.println(count);
		/*int[] arr = new int[] { 10, 3, 4, 51, 23 };
		rotateLeft(arr, 2);*/
	}
	
	public static void rotateLeft(int[] arr, int rotate) {
		System.out.println(Arrays.toString(arr));
		rotate = rotate % arr.length;
		for(int i=0; i<rotate; i++) {
			int temp = arr[0];
			for (int j = 1; j < arr.length; j++) {
				arr[j-1] = arr[j];
			}
			arr[arr.length-1] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
