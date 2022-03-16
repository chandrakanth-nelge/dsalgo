package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class SizeRecursive<T> extends LinkedList<T> implements LinkedListSize {

	@Override
	public int size() {
		return size(head);
	}

	private int size(Node<T> node) {
		if (null == node)
			return 0;

		int size = size(node.getNext());
		
		return 1 + size;
	}
}