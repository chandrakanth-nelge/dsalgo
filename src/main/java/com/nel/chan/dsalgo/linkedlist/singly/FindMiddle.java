package com.nel.chan.dsalgo.linkedlist.singly;

import java.util.Objects;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;
import com.nel.chan.dsalgo.linkedlist.singly.impl.Node;

public class FindMiddle<T> extends LinkedList<T> {

	public void middle() {
		if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
			return;
		}

		Node<T> fast = head;
		Node<T> slow = head;
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}

		System.out.println(slow.getData());
	}

	public void middleB() {
		if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
			return;
		}

		Node<T> temp = head;
		int mid = new SizeIterative<>(head).size() / 2;
		int count = 0;
		while (count < mid) {
			++count;
			temp = temp.getNext();
		}

		System.out.println(temp.getData());
	}
}