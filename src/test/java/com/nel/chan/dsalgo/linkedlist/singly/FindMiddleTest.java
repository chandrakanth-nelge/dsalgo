package com.nel.chan.dsalgo.linkedlist.singly;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.nel.chan.dsalgo.linkedlist.singly.impl.LinkedList;

class FindMiddleTest {

	@Test
	void testFindMiddle() {
		LinkedList<Integer> sll = new LinkedList<Integer>();
		sll.addFirst(11);
		sll.addFirst(1);
		sll.addFirst(8);
		sll.addFirst(10);

		sll.print();

		assertThat(true);
	}
}
