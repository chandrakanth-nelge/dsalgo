package com.nel.chan.dsalgo.recursion;

public class NaturalSum {

	public static void main(String[] args) {
		int num = 5;
		System.out.println(findNaturalSum(num));
		System.out.println(findNaturalSumRecursion(num, 0));
		System.out.println(findNaturalSumRecursionBacktracking(num));

		System.out.println("Fact == " + factorial(num));
	}

	private static int factorial(int num) {
		if (num == 1) {
			return 1;
		}

		return factorial(num - 1) * num;
	}

	private static int findNaturalSum(int num) {
		int sum = 0;
		for (int i = 0; i <= num; i++) {
			sum += i;
		}

		return sum;
	}

	private static int findNaturalSumRecursion(int num, int sum) {
		if (num == 0)
			return sum;
		return findNaturalSumRecursion(num - 1, sum + num);
	}

	private static int findNaturalSumRecursionBacktracking(int num) {
		if (num == 0)
			return 0;
		return num + findNaturalSumRecursionBacktracking(num - 1);
	}

}