package com.nel.chan.dsalgo.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Given 2 strings A and B, print all the interleavings of the 2 strings. An
 * interleaved string of given two strings preserves the order of characters in
 * individual strings and uses all the characters of both the strings. For
 * simplicity, you can assume that the strings have unique characters.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class Interleavings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			String s1 = in.next();
			String s2 = in.next();

			List<String> result = interleave(s1, s2);
			Collections.sort(result);
			System.out.println("Case #" + (k + 1) + ":");
			for (String str : result) {
				System.out.println(str);
			}
		}

		in.close();
	}

	public static List<String> interleave(String s, String t) {
		List<String> result = new ArrayList<>();
		if (t.isEmpty()) {
			result.add(s);
		} else if (s.isEmpty()) {
			result.add(t);
		} else {
			for (int i = 0; i <= s.length(); i++) {
				char c = t.charAt(0);
				String left = s.substring(0, i);
				String right = s.substring(i);
				for (String u : interleave(right, t.substring(1))) {
					result.add(left + c + u);
				}
			}
		}

		return result;
	}
}