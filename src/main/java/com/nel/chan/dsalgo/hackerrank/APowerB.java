package com.nel.chan.dsalgo.hackerrank;

/**
 * Given 2 numbers - a and b, evaluate a^b.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class APowerB {

	public static void main(String[] args) {
		pow(1000000000, 3);
	}

	private static void pow(int baseNum, int powerValue) {
		int m = (int) (1e9 + 7);
		int result = 1;
		for (int i = 0; i < powerValue; i++) {
			result = (result * baseNum) % m;
		}

		System.out.println(result);
	}

	@SuppressWarnings("unused")
	private static void findPower(long num1, long num2) {
		long ans = 1;
		while (num2 > 0) {
			if ((num2 & 1) == 1) {
				ans = ans * num1;
				num2--;
			} else {
				num1 = num1 * num1;
				num2 = num2 >> 1;
			}
		}

		System.out.println(ans);
	}

	@SuppressWarnings("unused")
	private static long power(int a, int b) {
		long x = 1;
		int y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = (x * y) % 1000000007;
			}
			y = (y * y) % 1000000007;
			b /= 2;
		}
		return x % 1000000007;
	}

	@SuppressWarnings("unused")
	private static long powerRec(int a, int b) {
		if (b == 0) {
			return 1;
		}
		long temp = powerRec(a, b / 2);
		temp = (temp * temp) % 1000000007;
		if (b % 2 == 0) {
			return temp;
		} else {
			return (a * temp) % 1000000007;
		}
	}
}