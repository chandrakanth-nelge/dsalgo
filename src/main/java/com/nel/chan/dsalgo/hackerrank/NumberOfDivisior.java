package com.nel.chan.dsalgo.hackerrank;

import java.util.Scanner;

public class NumberOfDivisior {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int k=0; k<testCases; k++) {
			long num1 = in.nextLong();
			
			findDivisior(num1);
		}
		
		in.close();
	}
	
	private static void findDivisior(long num) {
		int count = 0;
		for (int i=1; i<=Math.sqrt(num); i++) {
            if (num % i == 0) {
            	if(num / i == i){
            		count++;
            	}else{
            		count = count + 2;
            	}
            }
        }
		
		System.out.println(count);
	}
}
