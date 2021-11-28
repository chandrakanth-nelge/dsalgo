package com.nel.chan.dsalgo.linkedlist;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		/*list.addFirst(1);

		for (int i = 2; i <= 10; i++) {
			list.addLast(i);
		}
		
		list.print();

		list.findMiddle();

		list.delete(6);
		list.printRecurssively();
		
		list.printReverse();
		list.printReverseIterative();

		list.findMiddle();*/
		
		list.addAt(10, 0);
		
		list.addAt(20, 1);
		
		list.addAt(30,2);
		
		list.addAt(50, 3);
		
		list.addAt(60, 4);
		
		list.addAt(40, 3);
		
		list.addAt(70, 6);
		
		list.print();
		
		//list.printReverse();
		
		//System.out.println(list.getSize());
		
		list.deleteLast();
		
		System.out.println("=========After deleting==========");
		
		list.print();
		
		//list.printReverse();
		//System.out.println(list.getSize());
		//System.out.println(list.getSizeRecurssively());
		
		
	}
}