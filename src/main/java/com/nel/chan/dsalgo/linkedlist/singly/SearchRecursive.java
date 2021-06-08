package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class SearchRecursive<T> {

	private LinkedList<T> linkedList;

	public SearchRecursive(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public void search(T data) {
		search(data, linkedList.head());
	}

	private boolean search(T data, Node<T> curr) {
		if (curr == null) {
			System.out.println(data + " not found");
			return false;
		}

		if (data.equals(curr.getData())) {
			System.out.println(data + " found");
			return true;
		}

		return search(data, curr.getNext());
	}
}