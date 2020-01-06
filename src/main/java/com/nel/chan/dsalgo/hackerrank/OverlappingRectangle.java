package com.nel.chan.dsalgo.hackerrank;

import java.util.Scanner;

/**
 * Given 2 rectangles parallel to coordinate axes, find the area covered by
 * them. First line of input contains T - number of test cases. Its followed by
 * 2T lines. First line of each test case contains 4 integers - xbl, ybl, xtr,
 * ytr - the bottom-left and top-right coordinates of rectangle-1. The second
 * line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the
 * bottom-left and top-right coordinates of rectangle-2.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class OverlappingRectangle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			long a = in.nextInt();
			long b = in.nextInt();
			long c = in.nextInt();
			long d = in.nextInt();
			long e = in.nextInt();
			long f = in.nextInt();
			long g = in.nextInt();
			long h = in.nextInt();

			System.out.println(computeArea(a, b, c, d, e, f, g, h));
		}

		in.close();
	}

	public static long computeArea(long a, long b, long c, long d, long e, long f, long g, long h) {
		if (c < e || g < a) {
			return (g - e) * (h - f) + (c - a) * (d - b);
		}

		if (d < f || h < b) {
			return (g - e) * (h - f) + (c - a) * (d - b);
		}

		long right = Math.min(c, g);
		long left = Math.max(a, e);
		long top = Math.min(h, d);
		long bottom = Math.max(f, b);

		return (g - e) * (h - f) + (c - a) * (d - b) - (right - left) * (top - bottom);
	}
}