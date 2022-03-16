package com.nel.chan.dsalgo.array.search.binary;

import com.nel.chan.dsalgo.util.ArrayUtility;

public class OrderAgnosticSearch {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 8, 9, 10, 12, 13, 14, 15, 17, 20 };
		int[] arr1 = { 20, 17, 15, 14, 13, 12, 10, 9, 8, 4, 2 };
		int elem = 13;
		int result = search(arr, elem);
		System.out.println(result);
		result = search(arr1, elem);
		System.out.println(result);
	}

	private static int search(int[] arr, int elem) {
		int ans = -1;
		if (ArrayUtility.isEmpty(arr)) {
			return ans;
		}

		if (arr.length == 1) {
			if(arr[0] == elem)
				return 1;
			else
				return ans;
		}

		String oper = "";
		if (arr[0] < arr[1]) {
			oper = "asc";
		} else {
			oper = "desc";
		}
		
		System.out.println(oper);

		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (elem < arr[mid]) {
				if (oper.equals("asc"))
					high = mid - 1;
				else
					low = mid + 1;
			} else if (elem > arr[mid]) {
				if (oper.equals("asc"))
					low = mid + 1;
				else
					high = mid - 1;

			} else {
				ans = mid;
				break;
			}
		}

		return ans;
	}
}
