package com.nel.chan.dsalgo.array.search.duplicate;

import java.util.HashMap;
import java.util.Map;

public class DoubleOccurence {

	public static void main(String[] args) {
		int[] arr = new int[] {4, 2, 4, 5, 2, 3, 1};
		//Iterative
		int[] repeated = doubleOccurenceIterative(arr);
		System.out.println(repeated[0] + " " + repeated[1]);
		
		// BIT-MAP
		//repeated = doubleOccurenceHashing(arr);
		//System.out.println(repeated[0] + " " + repeated[1]);
		
		// XOR
		doubleOccurenceXOR(arr);
		
		printDuplicates(arr);
	}
	
	private static void printDuplicates(int[] arr) {
		int n = arr.length;
	    int fl = 0;
	    for (int i = 0; i < n; i++) {
	        if ( (arr[arr[i] % n] >= n) && (arr[arr[i] % n] < 2*n)) {
	        	System.out.print( arr[i] % n + " ");
                fl = 1;
	        } 
	        arr[arr[i] % n] = arr[arr[i] % n] + n;
	    } 
	  
	    if (fl <= 0) {
	        System.out.println("-1");
	    }
	}
	
	private static void doubleOccurenceXOR(int[] arr) {
		int xor = arr[0];
		for (int i = 1; i < arr.length; i++) {
			xor = xor ^ arr[i];
		}

		int rightSetBitNo = xor ^ (xor & (xor - 1));

		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & rightSetBitNo) == rightSetBitNo) {
				num1 = num1 ^ arr[i];
			} else {
				num2 = num2 ^ arr[i];
			}
		}
		
		if(num1 < num2) {
			System.out.println(num1 + " " + num2);
		} else {
			System.out.println(num2 + " " + num1);
		}
	}
	private static int[] doubleOccurenceIterative(int[] arr) {
		int[] repeated = new int[2];
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					count++;
					if(count == 2) break; 
				}
			}
			if(count == 2) {
				if(repeated[0] == 0) {
					repeated [0] = arr[i];
				} else {
					repeated [1] = arr[i];
				}
			}
		}
		
		return repeated;
	}
	
	//O(N), O(N)
	@SuppressWarnings("unused")
	private static int[] doubleOccurenceHashing(int[] arr) {
		int size = arr.length;
		Map<Integer, Integer> map = new HashMap<>(size);
		for (int i=0; i<size; i++) {
			int elem = arr[i];
			if (map.containsKey(elem)) {
				int count = map.get(elem);
				map.put(elem, ++count);
			} else {
				map.put(elem, 1);
			}
		}
		
		int[] repeated = new int[2];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 2) {
				repeated[index++] =  entry.getKey();
			}
		}

		return repeated;
	}
}