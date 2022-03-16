package com.nel.chan.dsalgo.linkedlist.singly;

import java.util.Objects;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class FindNthNodeFronEnd<T> extends LinkedList<T> {

	public void findNthNodeFronEndOfLinkedlist(int location) {
		if (Objects.isNull(head)) {
			return;
		}

		System.out.println("findNthNodeFronEndOfLinkedlist : " + location);

		int size = new SizeIterative<T>().size();
		int loc = size - location + 1;
		int count = 1;
		Node<T> temp = head;
		while (count != loc) {
			temp = temp.getNext();
			++count;
		}

		System.out.println("Element : " + temp.getData());
	}
}