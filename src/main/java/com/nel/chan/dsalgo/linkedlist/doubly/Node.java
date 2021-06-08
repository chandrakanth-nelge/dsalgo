package com.nel.chan.dsalgo.linkedlist.doubly;

public class Node<T> {
	private T data;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public Node(T data, Node<T> next, Node<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
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
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	public Node<T> getPrev() {
		return prev;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + ", prev=" + prev + "]";
	}
}