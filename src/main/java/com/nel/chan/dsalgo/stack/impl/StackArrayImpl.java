package com.nel.chan.dsalgo.stack.impl;

import com.nel.chan.dsalgo.stack.Stack;

/**
 * @author Chandrakanth Nelge
 */
public class StackArrayImpl<T> implements Stack<T> {
	private static final String STACK_IS_EMPTY = "Stack is empty !";
	
	private static final int SIZE = 10;
	private int top = -1;
	private T[] container = null;

	@SuppressWarnings("unchecked")
	public StackArrayImpl() {
		container = (T[]) new Object[SIZE];
	}

	@SuppressWarnings("unchecked")
	public StackArrayImpl(int size) {
		container = (T[]) new Object[size];
	}

	public void push(T t) {
		if (null == t) {
			System.out.println("data is mandatory");
			return;
		}
		
		if (top == container.length - 1) {
			resize(2 * container.length);
		}
		
		top = top + 1;
		container[top] = t;
	}

	public T peek() {
		if (isEmpty()) {
			System.out.println(STACK_IS_EMPTY);
			return null;
		}
		
		return container[top];
	}

	public T pop() {
		if (isEmpty()) {
			System.out.println(STACK_IS_EMPTY);
			return null;
		}
		
		T item = container[top];
		container[top] = null;
		top = top - 1;

		if (top > 0 && top == container.length / 4) {
			resize(container.length / 2);
		}

		return item;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println(STACK_IS_EMPTY);
			return;
		}

		for (int i = 0; i < top + 1; i++) {
			System.out.println(container[i]);
		}
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return top + 1;
	}

	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		T[] temp = (T[]) new Object[newSize];
		for (int i = 0; i < top; i++) {
			temp[i] = container[i];
		}

		container = temp;
	}

	@Override
	public void printReverse() {
		if (isEmpty()) {
			System.out.println(STACK_IS_EMPTY);
			return;
		}

		for (int i = top + 1; i > 0; i--) {
			System.out.println(container[i]);
		}
	}
}