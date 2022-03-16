package com.nel.chan.dsalgo.linkedlist.singly;

import java.util.Objects;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class SearchRecursive<T> extends LinkedList<T> {

	public boolean search(T data) {
		return search(data, head);
	}

	private boolean search(T data, Node<T> node) {
		if (Objects.isNull(node)) {
			System.out.println(data + " not found");
			return false;
		}

		if (data.equals(node.getData())) {
			System.out.println(data + " found");
			return true;
		}

		return search(data, node.getNext());
	}
}