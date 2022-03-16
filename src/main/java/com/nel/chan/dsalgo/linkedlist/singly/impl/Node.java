package com.nel.chan.dsalgo.linkedlist.singly.impl;

public class Node<T> {

	private T data;
	private Node<T> next;

	public Node(T data) {
		this.data = data;
		this.next = null;
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
		return "LinkedList [data=" + this.data + ", next=" + this.next + "]";
	}
}