package com.nel.chan.dsalgo.array.search.binary;

import com.nel.chan.dsalgo.util.ArrayUtility;

public class FirstNLastOccurence {

	public static void main(String[] args) {
		int[] arr = { 10, 10, 10, 10, 10, 10, 10, 10 };
		int elem = 10;
		search(arr, elem);
	}

	private static void search(int[] arr, int elem) {
		if (ArrayUtility.isEmpty(arr)) {
			return;
		}
		
		int p1 = -1;
		int p2 = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (elem < arr[mid]) {
				high = mid - 1;
			} else if (elem > arr[mid]) {
				low = mid + 1;
			} else {
				p1 = mid;
				p2 = mid;
				while(p1 >=0 || p2 < arr.length) {
					if(arr[p1] == elem && p1>0) {
						--p1;
					}
					if(arr[p2] == elem && p2<= arr.length) {
						p2++;
					}
					
					if((arr[p1] != elem && arr[p2] != elem)) {
						++p1;
						--p2;
						break;
					}
				}
				
				break;
			}
		}

		System.out.println(p1 + " ===> " + p2);
	}
}
