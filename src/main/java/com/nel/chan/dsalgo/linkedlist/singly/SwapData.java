package com.nel.chan.dsalgo.linkedlist.singly;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class SwapData<T> {

	private LinkedList<T> linkedList;

	public SwapData(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public void swap(T data1, T data2) {
		if (data1 == data2) {
			return;
		}

		boolean firstDataFound = false;
		boolean secondDataFound = false;
		Node<T> node1 = null;
		Node<T> prevNode1 = null;
		Node<T> node2 = null;
		Node<T> prevNode2 = null;
		Node<T> temp = linkedList.head();

		while (null != temp) {
			if (temp.getData().equals(data1)) {
				prevNode1 = temp;
				node1 = temp.getNext();
				firstDataFound = true;
			}

			if (temp.getData().equals(data2)) {
				prevNode2 = temp;
				node2 = temp.getNext();
				secondDataFound = true;
			}

			temp = temp.getNext();

		}

		if (!firstDataFound || !secondDataFound) {
			return;
		}

		System.out.println(node1);
		System.out.println(prevNode1);
		System.out.println(node2);
		System.out.println(prevNode2);
	}
}