package com.nel.chan.dsalgo.linkedlist.singly;

import java.util.Stack;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class PrintReverseIterative<T> extends LinkedList<T> {

	public void print() {
		Stack<T> stack = new Stack<>();

		Node<T> temp = head;
		while (null != temp) {
			stack.push(temp.getData());
			temp = temp.getNext();
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " -> ");
		}
		System.out.println("null");
	}
}