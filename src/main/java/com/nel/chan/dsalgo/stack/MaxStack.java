package com.nel.chan.dsalgo.stack;

import com.nel.chan.dsalgo.stack.impl.StackArrayImpl;

/**
 * @author Chandrakanth Nelge
 */
public class MaxStack {
	private Stack<Integer> mainStack = new StackArrayImpl<>();
	private Stack<Integer> maxStack = new StackArrayImpl<>();

	public void add(Integer data) {
		if (mainStack.isEmpty()) {
			mainStack.push(data);
			maxStack.push(data);
		} else {
			mainStack.push(data);
			int minData = maxStack.peek();
			if (data >= minData) {
				maxStack.push(data);
			}
		}
	}

	public Integer remove() {
		int data = mainStack.pop();
		int minData = maxStack.peek();

		if (minData == data) {
			maxStack.pop();
		}

		return data;
	}

	public int getMax() {
		if (mainStack.isEmpty()) {
			return -1;
		}

		return maxStack.peek();
	}

	public void display() {
		mainStack.display();
		maxStack.display();
	}
}