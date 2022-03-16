package com.nel.chan.dsalgo.linkedlist;

import com.nel.chan.dsalgo.linkedlist.singly.Reverse;
import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Integer> list = new Reverse<>();

		list.addAt(10, 0);
		list.addAt(20, 1);
		list.addAt(30, 2);
		list.addAt(50, 3);
		list.addAt(60, 4);
		list.addAt(40, 3);
		list.addAt(70, 6);

		list.print();

		((Reverse<Integer>) list).reverse();
		list.print();
	}
}