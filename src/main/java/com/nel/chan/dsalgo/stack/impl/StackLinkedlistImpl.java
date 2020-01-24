package com.nel.chan.dsalgo.stack.impl;

import com.nel.chan.dsalgo.stack.Stack;

/**
 * @author Chandrakanth Nelge
 */
public class StackLinkedlistImpl<T> implements Stack<T> {
	private static final String STACK_IS_EMPTY = "Stack is empty";
	private Node<T> head;
	int size;

	public StackLinkedlistImpl() {
		head = null;
		size = 0;
	}

	public void push(T t) {
		if (null == t) {
			throw new NullPointerException("data is mandatory");
		}
		
		++size;
		
		Node<T> newNode = new Node<>(t);
		if (null == head) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}

	public T peek() {
		if (null == head) {
			System.out.println(STACK_IS_EMPTY);
			return null;
		}

		return head.getData();
	}

	public T pop() {
		if (null == head) {
			System.out.println(STACK_IS_EMPTY);
			return null;
		}

		T data = head.getData();
		head = head.getNext();

		size = size - 1;

		return data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void display() {
		if (null == head) {
			System.out.println(STACK_IS_EMPTY);
			return;
		}

		Node<T> temp = head;
		while (null != temp) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	@Override
	public void printReverse() {
		reverse(head);
		System.out.println();
	}
	
	private void reverse(Node<T> head) {
		if (null == head) {
			return;
		}

		reverse(head.next);
		System.out.print(head.data + " -> ");
	}

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

		public void setData(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getNext() {
			return next;
		}

		@Override
		public String toString() {
			return "LinkedList [data=" + data + ", next=" + next + "]";
		}
	}
}