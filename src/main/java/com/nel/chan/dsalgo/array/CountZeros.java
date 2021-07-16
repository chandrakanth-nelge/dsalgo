package com.nel.chan.dsalgo.array;

import java.util.Random;

public class CountZeros {
	
	public static void main(String[] args) {
		int size = 100;
		int[] in = testCase1(size);
		long start = System.currentTimeMillis();
		System.out.println(count1(in));
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end - start) / 1000.0 + "secs");
	}
	
	public static int[] testCase1(int size) {
		int[] in = new int[size];
		
		Random r = new Random(0);
		int p = r.nextInt(size);
		for (int i = 0; i <= p; ++i) {
			in[i] = 0;
		}
		
		for (int i = p + 1; i < size; ++i) {
			in[i] = r.nextInt(10) + 1;
		}
		
		return in;
	}
	
	public static int count1(int[] in) {
		int idx = 0;
		for (int i = 0; i < in.length; ++i) {
			if (in[i] != 0) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	public static int count2(int[] in) {
		int left = 0;
		int right = in.length - 1;
		while (right - left > 1) {
			int mid = (left + right) / 2;
			if (in[mid] == 0) {
				left = mid;
			}
			else {
				right = mid - 1;
			}
		}
		
		if (in[right] == 0) {
			return right + 1;
		}
		
		return left + 1;
	}
}