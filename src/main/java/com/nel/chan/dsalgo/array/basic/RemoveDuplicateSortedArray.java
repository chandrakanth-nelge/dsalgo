package com.nel.chan.dsalgo.array.basic;

public class RemoveDuplicateSortedArray {

	public int[] remove(int[] arr) {
		int p1 = 0;
		int p2 = 1;

		while (p2 < arr.length) {
			if (arr[p1] == arr[p2]) {
				p2++;
			} else {
				p1++;
				arr[p1] = arr[p2];
			}
		}

		p1++;
		while (p1 < arr.length) {
			arr[p1] = 0;
			p1++;
		}

		return arr;
	}
}
