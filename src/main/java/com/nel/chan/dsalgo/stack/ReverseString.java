package com.nel.chan.dsalgo.stack;

import com.nel.chan.dsalgo.stack.impl.StackLinkedlistImpl;

public class ReverseString {
	
	public static void main(String[] args) {
		String input = "reverse the line";
		System.out.println(input);
		System.out.println(reverseStringStack(input));
		System.out.println(reverse(input));
	}
	
	private static String reverseStringStack(String input) {
		Stack<Character> stack = new StackLinkedlistImpl<>();
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}

		StringBuilder reverse = new StringBuilder("");
		while (!stack.isEmpty()) {
			reverse.append(stack.pop());
		}
		
		return reverse.toString();
	}
	
	private static String reverse(String input) {
		StringBuilder reverse = new StringBuilder("");
		for (int i = input.length()-1; i >= 0; i--) {
			reverse.append(input.charAt(i));
		}
		
		return reverse.toString();
	}
}