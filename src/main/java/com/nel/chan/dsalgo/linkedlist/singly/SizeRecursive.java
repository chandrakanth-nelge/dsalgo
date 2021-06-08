package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class SizeRecursive<T> {

	private LinkedList<T> linkedList;

	public SizeRecursive(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public int size() {
		return size(linkedList.head(), 0);
	}

	private int size(Node<T> node, int size) {
		if (null == node) {
			return size;
		}

		return size(node.getNext(), ++size);
	}
}