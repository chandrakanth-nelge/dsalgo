package com.nel.chan.dsalgo.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {

	public static void main(String[] args) {
		List<Integer> alice = new ArrayList<>();
		alice.add(5);
		alice.add(6);
		alice.add(7);

		List<Integer> bob = new ArrayList<>();
		bob.add(3);
		bob.add(6);
		bob.add(10);

		List<Integer> result = compareTriplets(alice, bob);
		for (int point : result) {
			System.out.print(point + " ");
		}
	}

	static List<Integer> compareTriplets(List<Integer> alice, List<Integer> bob) {
		List<Integer> result = new ArrayList<>(2);
		result.add(0, 0);
		result.add(1, 0);

		int size = alice.size();
		for (int i = 0; i < size; i++) {
			if (alice.get(i) > bob.get(i)) {
				int val = result.get(0);
				result.set(0, val +1);
			} else if (alice.get(i) < bob.get(i)) {
				int val = result.get(1);
				result.set(1, val +1);
			} else {
				// NOTHING
			}
		}
		return result;
	}

}
