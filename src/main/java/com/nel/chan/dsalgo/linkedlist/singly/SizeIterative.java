package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class SizeIterative<T> extends LinkedList<T> implements LinkedListSize {

	public SizeIterative(Node<T> node) {
		super(node);
	}

	@Override
	public int size() {
		int count = 0;
		Node<T> temp = head;
		while (null != temp) {
			++count;
			temp = temp.getNext();
		}

		return count;
	}
}