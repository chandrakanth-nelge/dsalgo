package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class PrintRecursive<T> {

	private LinkedList<T> linkedList;

	public PrintRecursive(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public void print() {
		printRecurssively(linkedList.head());
		System.out.println("null");
	}

	private void printRecurssively(Node<T> head) {
		if (null == head) {
			System.out.println("null");
			return;
		}

		System.out.print(head.getData() + " -> ");
		printRecurssively(head.getNext());
	}
}