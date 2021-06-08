package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class FindMiddle<T> {

	private LinkedList<T> linkedList;

	public FindMiddle(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public void middle() {
		if (linkedList.head() == null) {
			return;
		}

		Node<T> fast = linkedList.head();
		Node<T> slow = linkedList.head();
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}

		System.out.println(slow.getData());
	}
}