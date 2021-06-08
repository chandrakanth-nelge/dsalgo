package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class PrintReverseRecursive<T> {

	private LinkedList<T> linkedList;

	public PrintReverseRecursive(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public void print() {
		print(linkedList.head());
		System.out.println("null");
	}

	private void print(Node<T> head) {
		if (null == head) {
			return;
		}

		print(head.getNext());
		System.out.print(head.getData() + " -> ");
	}
}