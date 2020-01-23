package com.nel.chan.dsalgo.queue.impl;

import com.nel.chan.dsalgo.queue.Queue;

public class QueueLinkedListImpl<T> implements Queue<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;

	public QueueLinkedListImpl() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public void enqueue(T data) {
		Node<T> temp = new Node<>(data);
		if (rear == null) {
			front = temp;
			rear = temp;
		} else {
			rear.next = temp;
			rear = temp;
		}
		
		size = size + 1;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			System.out.println("Empty");
			return null;
		}

		size = size - 1;

		Node<T> temp = front;
		front = front.next;
		if (front == null) {
			rear = null;
		}

		return temp.data;
	}

	public T front() {
		if (isEmpty()) {
			System.out.println("Empty");
			return null;
		}
		
		return front.data;
	}

	@Override
	public T rear() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void print() {
		System.out.println("print()");
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

		@Override
		public String toString() {
			return "LinkedList [data=" + data + ", next=" + next + "]";
		}
	}
}