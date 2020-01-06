package com.nel.chan.dsalgo.recursion;

public class RecusionTest {
	
	public static void main(String[] args) {
		int factNum = 5;
		int result = factRecursion(1, factNum);
		System.out.println("Fact(" + factNum + ") = "+ result);
		result = factRecursionBackTracking(factNum);
		System.out.println("Fact(" + factNum + ") = "+ result);
		
		System.out.println("================================================");
		fun1(factNum);
	}
	
	public static int factRecursion(int fact, int n) {
		if (n <= 1) {
			return fact;
		} else {
			return factRecursion(fact * n, n - 1);
		}
	}
	
	public static int factRecursionBackTracking(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factRecursionBackTracking(n - 1);
		}
	}
	
	private static void fun1(int n) {
	   if (n > 1) {
	     fun1(n-1);
	   }
	  
	   for (int i = 0; i < n; i++) {
		   System.out.print(" * ");
	   }
	   
	   System.out.println();
	}
}