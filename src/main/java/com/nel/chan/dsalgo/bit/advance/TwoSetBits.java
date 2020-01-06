package com.nel.chan.dsalgo.bit.advance;

/**
 * Look at the following sequence: 3, 5, 6, 9, 10, 12, 17, 18, 20....
 * All the numbers in the series has exactly 2 bits set in their binary representation.
 * Your task is simple, you have to find the Nth number of this sequence.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class TwoSetBits {

	public static void main(String[] args) {
		System.out.println(solve(100));
	}

	static long solve(long n) {
		long r = 0;
		long a = 1;
		while ((r = a * (a + 1) / 2) < n) {
			a++;
		}
		long b = a - (r - n) - 1;
		//System.out.println(a + "-" + b);
		long n1 = power(2, a);
		long n2 = power(2, b);
		return (n1 + n2) % 1000000007;
	}

	static long power(long a, long b) {
		long res = 1;
		while (b != 0) {
			if (b % 2 != 0) {
				res = (res * a) % 1000000007;
			}
			a = (a * a) % 1000000007;
			b = b >> 1;
		}
		return res;
	}
}