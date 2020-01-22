package com.nel.chan.dsalgo.stack;

import com.nel.chan.dsalgo.stack.impl.StackLinkedlistImpl;

/**
 * @author Chandrakanth Nelge
 */
public class StackTest {
	private static final String SPACE = "========================================================";
	private static final String SIZE = "Size = ";

	public static void main(String[] args) {
		stackTestArray();
	}

	private static void stackTestArray() {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		System.out.println("==========================JAVAA=========================");
		for (Integer i : s) {
			System.out.println(i);
		}
		System.out.println("==========================JAVAA=========================");

		Stack<Integer> stack = new StackLinkedlistImpl<>();

		System.out.println(SPACE);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println(SIZE + stack.size());
		System.out.println(SPACE);

		System.out.println(SPACE);
		Integer value = stack.peek();
		System.out.println("PEEK = " + value);
		stack.display();
		System.out.println(SIZE + stack.size());
		System.out.println(SPACE);

		System.out.println(SPACE);
		stack.push(150);
		System.out.println("PUSH = " + 150);
		stack.display();
		System.out.println(SIZE + stack.size());
		System.out.println(SPACE);

		System.out.println(SPACE);
		stack.push(60);
		System.out.println("PUSH = " + 60);
		stack.display();
		System.out.println(SIZE + stack.size());
		System.out.println(SPACE);

		System.out.println(SPACE);
		value = stack.pop();
		System.out.println("POP = " + value);
		stack.display();
		System.out.println(SIZE + stack.size());
		System.out.println(SPACE);

		System.out.println(SPACE);
		value = stack.peek();
		System.out.println("PEEK = " + value);
		stack.display();
		System.out.println(SIZE + stack.size());
		System.out.println(SPACE);
	}
}