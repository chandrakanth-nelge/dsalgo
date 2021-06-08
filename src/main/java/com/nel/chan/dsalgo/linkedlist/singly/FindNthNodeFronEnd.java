package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class FindNthNodeFronEnd<T> {

	private LinkedList<T> linkedList;

	public FindNthNodeFronEnd(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public void findNthNodeFronEndOfLinkedlist(int location) {
		System.out.println("findNthNodeFronEndOfLinkedlist : " + location);

		int size = new SizeIterative<T>(linkedList).size();
		int loc = size - location + 1;
		int count = 1;
		Node<T> temp = linkedList.head();
		while (count != loc) {
			temp = temp.getNext();
			++count;
		}

		System.out.println("Element : " + temp.getData());
	}
}