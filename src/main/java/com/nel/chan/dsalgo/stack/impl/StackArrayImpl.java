package com.nel.chan.dsalgo.stack.impl;

import com.nel.chan.dsalgo.stack.Stack;

/**
 * @author Chandrakanth Nelge
 */
public class StackArrayImpl<T> implements Stack<T> {
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
		if (top == container.length - 1) {
			resize(2 * container.length);
		}

		container[++top] = t;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty. Can not remove element.");
		}
		return container[top];
	}

	public T peek() {
		if (isEmpty()) {
			return null;
		}
		T item = container[top];
		container[top--] = null;

		if (top > 0 && top == container.length / 4) {
			resize(container.length / 2);
		}

		return item;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("null");
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
}