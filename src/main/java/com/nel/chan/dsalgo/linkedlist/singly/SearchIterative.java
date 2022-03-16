package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class SearchIterative<T> extends LinkedList<T> {

	public boolean search(T data) {
		Node<T> temp = head;
		while (null != temp) {
			if (data.equals(temp.getData())) {
				System.out.println(data + " found");
				return true;
			}

			temp = temp.getNext();
		}

		System.out.println(data + " not found");
		return false;
	}
}