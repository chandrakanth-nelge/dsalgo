package com.nel.chan.dsalgo.linkedlist.singly;

/**
 * @author Chandrakanth Nelge
 */
public class SinglyLinkedList<T> {
	private static final String SINGLY_LINKED_LIST_IS_EMPTY = "Singly linked list is empty";
	private static final String INVALIDMES = "Invalid Position";

	private int size = 0;
	private Node<T> head;

	public SinglyLinkedList() {
		head = null;
	}

	public void addFirst(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = head;
		head = newNode;
		++size;
	}

	public void addLast(T data) {
		if (null == head) {
			addFirst(data);
			return;
		}

		Node<T> temp = head;
		while (null != temp.next) {
			temp = temp.next;
		}

		temp.next = new Node<>(data);
		++size;
	}

	public void addAt(T data, int position) {
		if (position == 1) {
			addFirst(data);
			return;
		}

		if (position < 1 || position > size) {
			System.out.println(INVALIDMES);
			return;
		}

		Node<T> temp = head;
		Node<T> prev = head;
		int count = 1;
		while (count != position) {
			prev = temp;
			temp = temp.next;
			++count;
		}

		Node<T> newNode = new Node<>(data);
		newNode.next = temp;
		prev.next = newNode;
		++size;
	}

	public void addAfter(T data, T newData) {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return;
		}

		boolean isDataFound = false;
		Node<T> temp = head;
		while (null != temp) {
			if (data.equals(temp.data)) {
				addAfter(temp, newData);
				isDataFound = true;
				break;
			}
			temp = temp.next;
		}

		if (!isDataFound) {
			System.out.println(data + " is not found in Linked list");
		}
	}

	public void deleteFirst() {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return;
		}

		head = head.next;
		--size;
	}

	public void deleteLast() {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return;
		}

		if (null == head.next) {
			head = null;
			return;
		}

		Node<T> temp = head;
		Node<T> prev = head;
		while (null != temp.next) {
			prev = temp;
			temp = temp.next;
		}
		--size;
		prev.next = null;
	}

	public void deleteAt(int position) {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return;
		}

		if (position == 1) {
			deleteFirst();
			return;
		}

		if (position < 1 || position > getSize()) {
			System.out.println(INVALIDMES);
			return;
		}

		Node<T> prev = head;
		Node<T> temp = head;
		int count = 1;
		while (position != count) {
			prev = temp;
			temp = temp.next;
			++count;
		}

		prev.next = temp.next;
	}

	public void delete(T data) {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return;
		}

		if (data.equals(head.data)) {
			deleteFirst();
			return;
		}

		Node<T> temp = head;
		Node<T> prev = head;
		while (null != temp) {
			if (data.equals(temp.data)) {
				break;
			}
			prev = temp;
			temp = temp.next;
		}

		if (null == temp) {
			System.out.println(data + " not found in linked list");
			return;
		}

		prev.next = temp.next;
		--size;
	}

	public T getAt(int position) {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return null;
		}

		if (position < 1 || position > getSize()) {
			System.out.println(INVALIDMES);
			return null;
		}

		int count = 1;
		Node<T> temp = head;
		while (count != position) {
			temp = temp.next;
			++count;
		}

		return temp.data;
	}

	public void display() {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return;
		}

		Node<T> temp = head;
		while (null != temp) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void printReverse() {
		reverse(head);
	}

	private void reverse(Node<T> head) {
		if (null == head) {
			return;
		}

		reverse(head.next);
		System.out.print(head.data + " -> ");
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int getSize() {
		int newSize = 0;
		Node<T> temp = head;
		while (null != temp) {
			++newSize;
			temp = temp.next;
		}

		return newSize;
		// return size;
	}

	private void addAfter(Node<T> prev, T newData) {
		if (null == prev) {
			System.out.println("The given previous node cannot be null");
			return;
		}

		Node<T> newNode = new Node<>(newData);
		newNode.next = prev.next;
		prev.next = newNode;
		++size;
	}

	/////////////////////////////////////////////////////////////////////////// QUESTIONS////////////////////////////////////////////////////////////////////////////
	public void findMiddle() {
		if (head == null) {
			return;
		}

		Node<T> fast = head;
		Node<T> slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		System.out.println(slow.data);
	}

	public void deleteMiddle() {
		if (head == null) {
			return;
		}

		if (head.next == null) {
			return;
		}

		Node<T> prev = head;
		Node<T> fast = head;
		Node<T> slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}

		prev.next = slow.next;
	}
	/////////////////////////////////////////////////////////////////////////// QUESTIONS////////////////////////////////////////////////////////////////////////////

	static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "LinkedList [data=" + data + ", next=" + next + "]";
		}
	}
}