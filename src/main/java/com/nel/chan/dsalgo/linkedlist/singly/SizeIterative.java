package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

/**
 * 
 * @author Chandrakanth Nelge
 *
 * DONE
 */
public class SizeIterative<T> {

	private LinkedList<T> linkedList;

	public SizeIterative(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public int size() {
		int count = 0;
		Node<T> temp = linkedList.head();
		while (null != temp) {
			++count;
			temp = temp.getNext();
		}

		return count;
	}
}