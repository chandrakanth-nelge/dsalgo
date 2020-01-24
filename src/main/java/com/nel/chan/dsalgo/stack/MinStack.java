package com.nel.chan.dsalgo.stack;

import com.nel.chan.dsalgo.stack.impl.StackArrayImpl;

/**
 * @author Chandrakanth Nelge
 */
public class MinStack {
	private Stack<Integer> mainStack = new StackArrayImpl<>();
	private Stack<Integer> minStack = new StackArrayImpl<>();

	public void add(Integer data) {
		if (mainStack.isEmpty()) {
			mainStack.push(data);
			minStack.push(data);
		} else {
			mainStack.push(data);
			int minData = minStack.peek();
			if (data <= minData) {
				minStack.push(data);
			}
		}
	}

	public Integer remove() {
		int data = mainStack.pop();
		int minData = minStack.peek();

		if (minData == data) {
			minStack.pop();
		}

		return data;
	}

	public int getMin() {
		if (mainStack.isEmpty()) {
			return -1;
		}

		return minStack.peek();
	}

	public void display() {
		mainStack.display();
		minStack.display();
	}
}