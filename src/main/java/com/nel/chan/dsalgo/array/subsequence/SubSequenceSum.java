package com.nel.chan.dsalgo.array.subsequence;

public class SubSequenceSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 }; 
        System.out.print(findSum(arr)); 
	}
	
	//2^N-1
	static int findSum(int[] arr) {
        int sum = 0; 
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i]; 
        }
  
        // Result is sum * 2^(n-1)
        return sum * (1 << (arr.length - 1)); 
    }
}
