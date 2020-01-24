package com.nel.chan.dsalgo.stack;

import com.nel.chan.dsalgo.stack.impl.StackArrayImpl;

/**
 * @author Chandrakanth Nelge
 */
public class AvgStack {
	private Stack<Integer> mainStack = new StackArrayImpl<>();
	private Integer stackSum = 0;

	public void add(Integer data) {
		mainStack.push(data);
		stackSum = stackSum + data;
	}

	public Integer remove() {
		int data = mainStack.pop();
		stackSum = stackSum - data; 
		return data;
	}

	public int getAvg() {
		if (mainStack.isEmpty()) {
			return 0;
		}

		return (stackSum / mainStack.size());
	}

	public void display() {
		mainStack.display();
	}
}