package com.nel.chan.dsalgo.array.basic;

public class MovesZero {
	public int[] move(int[] arr) {
		int p1 = -1;
		int p2 = 0;
		while (p2 < arr.length) {
			if (arr[p2] != 0) {
				p1++;
				arr[p1] = arr[p2];
			}

			p2++;
		}

		++p1;
		while (p1 < arr.length) {
			arr[p1] = 0;
			++p1;
		}

		return arr;
	}
}
