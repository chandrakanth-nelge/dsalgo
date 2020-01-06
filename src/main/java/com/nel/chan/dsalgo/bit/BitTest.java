package com.nel.chan.dsalgo.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BitTest {

	public static void main(String[] args) {
		System.out.println("");
		int res = recursion(1, 1, 32);
		System.out.println(res+1);
	}

	private static int recursion(int num, int low, int high) {
		if(low <=high) {
			return 1;
		}
		
		int mid = (low + high) / 2;
		
		int result = mid * mid;
		if(result == num) {
			return mid;
		} else if(result > num) {
			high = mid-1;
		} else {
			low = mid+1;
		}
		
		return recursion(num, low, high);
	}
	@SuppressWarnings("unused")
	private static void countNumOfOnesBitInput() throws IOException {
		List<String> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			list = br.lines().collect(Collectors.toList());
		}
		
		for(String number : list) {
			countNumOfOnesBitOptimized(Long.parseLong(number));
		}
	}
	
	public static int countNumOfOnesBitOptimized(Long num) {
		int count = 0;
		while (num != 0) {
			++count;
			num = num & (num - 1);
		}

		return count;
	}
}