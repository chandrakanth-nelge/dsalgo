package com.nel.chan.dsalgo.linkedlist;

import com.nel.chan.dsalgo.linkedlist.singly.SinglyLinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.addFirst(1);

		for (int i = 2; i <= 10; i++) {
			list.addLast(i);
		}
		list.display();

		list.findMiddle();

		list.delete(6);
		list.display();

		list.findMiddle();
	}
}