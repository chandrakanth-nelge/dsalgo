package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class DeleteMiddle<T> {

	private LinkedList<T> linkedList;

	public DeleteMiddle(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public void deleteMiddle() {
		if (linkedList.head() == null) {
			return;
		}

		if (linkedList.head().getNext() == null) {
			return;
		}

		Node<T> prev = linkedList.head();
		Node<T> fast = linkedList.head();
		Node<T> slow = linkedList.head();
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			prev = slow;
			slow = slow.getNext();
		}

		prev.setNext(slow.getNext());
	}
}