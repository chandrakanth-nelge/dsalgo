package com.nel.chan.dsalgo.stack;

import com.nel.chan.dsalgo.stack.impl.StackLinkedlistImpl;

public class ReverseSentenceWordByWord {

	public static void main(String[] args) {
		String input = "reverse the line";
		System.out.println(input);
		
		reverseStack(input);
		reverse(input);
	}
	
	private static void reverseStack(String input) {
		String[] words = input.split(" ");
		Stack<String> stack = new StackLinkedlistImpl<>();
		for (String word : words) {
			stack.push(word);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
		System.out.println();
	}
	
	private static void reverse(String input) {
		char[] arr = input.toCharArray();
		
		reverseWord(arr, 0, arr.length-1);
		
		int p1 = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ') {
				reverseWord(arr, p1, i-1);
				p1 = i+1;
			}
		}
		
		reverseWord(arr, p1, arr.length-1);
		
		System.out.println(arr);
	}
	
	private  static void reverseWord(char[] arr, int p1, int p2) {
		while(p1 <= p2) {
			char temp = arr[p1];
			arr[p1] = arr[p2];
			arr[p2] = temp;
			p1 = p1 + 1;
			p2 = p2 - 1;
		}
	}
}