package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class Reverse<T> extends LinkedList<T> {

	public void reverse() {
		Node<T> curr = null;
		Node<T> prev = null;
		while (head != null) {
			curr = head;
			head = head.getNext();
			curr.setNext(prev);
			prev = curr;
		}

		head = curr;
	}
}