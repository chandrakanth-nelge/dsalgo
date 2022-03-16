package com.nel.chan.dsalgo.array.easy;

import java.util.Arrays;

public class Segregate0and1 {
	
	public static void main(String[] args) {
		int[] arr = new int[] {0,0,1,1,0};
		System.out.println(Arrays.toString(arr));
		
		segregate0and1(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void segregate0and1(int[] arr) {
        int p1= 0;
        int p2 = arr.length - 1;
        while(p1<p2) {
            if(arr[p1] == 0) {
                ++p1;
            } else if(arr[p2] == 1) {
                --p2;
            } else {
                arr[p1] = 0;
                arr[p2] = 1;
                ++p1;
                --p2;
            }
        }
    }
}
