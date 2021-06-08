package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class SearchIterative<T> {

	private LinkedList<T> linkedList;

	public SearchIterative(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public void search(T data) {
		Node<T> temp = linkedList.head();
		while (null != temp) {
			if (data.equals(temp.getData())) {
				System.out.println(data + " found");
				return;
			}

			temp = temp.getNext();
		}
		System.out.println(data + " not found");
	}
}