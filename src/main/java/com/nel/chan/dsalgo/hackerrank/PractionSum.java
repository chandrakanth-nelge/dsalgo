package com.nel.chan.dsalgo.hackerrank;

import java.text.DecimalFormat;

public class PractionSum {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.000000");

		int[] arr = new int[] { -4, 3, -9, 0, 4, 1 };
		double[] result = getFraction(arr, arr.length);
		System.out.println(df.format(result[0]));
		System.out.println(df.format(result[1]));
		System.out.println(df.format(result[2]));
	}

	public static double[] getFraction(int[] arr, int n) {
		int[] fractionSum = new int[3];
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				fractionSum[0] = fractionSum[0] + 1;
			} else if (arr[i] < 0) {
				fractionSum[1] = fractionSum[1] + 1;
			} else {
				fractionSum[2] = fractionSum[2] + 1;
			}
		}

		double[] fractionResult = new double[3];
		fractionResult[0] = (float) fractionSum[0] / n;
		fractionResult[1] = (float) fractionSum[1] / n;
		fractionResult[2] = (float) fractionSum[2] / n;

		return fractionResult;
	}
}