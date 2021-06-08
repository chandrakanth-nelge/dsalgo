package com.nel.chan.dsalgo.linkedlist.singly.impl;

/**
 * @author Chandrakanth Nelge
 */
public class LinkedList<T> {
	private static final String SINGLY_LINKED_LIST_IS_EMPTY = "Singly linked list is empty";
	private static final String INVALIDMES = "Invalid Position";

	private int size = 0;
	private Node<T> head;

	public LinkedList() {
		head = null;
	}

	public Node<T> head() {
		return head;
	}

	//DONE
	public void addFirst(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNext(head);
		head = newNode;
		++size;
	}

	//DONE
	public void addLast(T data) {
		if (null == head) {
			addFirst(data);
			return;
		}

		Node<T> temp = head;
		while (null != temp.getNext()) {
			temp = temp.getNext();
		}

		temp.setNext(new Node<>(data));
		++size;
	}

	//DONE
	public void addAt(T data, int pos) {
		if (pos < 0 || pos > size) {
			System.out.println(INVALIDMES);
			return;
		}

		if (pos == 0) {
			addFirst(data);
			return;
		}
		
		if(pos == size) {	
			addLast(data);
			return;
		}

		Node<T> temp = head;
		int count = 0;
		while (count < (pos-1)) {
			temp = temp.getNext();
			count++;
		}

		Node<T> newNode = new Node<>(data);
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
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
			if (data.equals(temp.getData())) {
				addAfter(temp, newData);
				isDataFound = true;
				break;
			}
			temp = temp.getNext();
		}

		if (!isDataFound) {
			System.out.println(data + " is not found in Linked list");
		}
	}

	//DONE
	public Node<T> deleteFirst() {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return null;
		}

		Node<T> temp = head;
		head = head.getNext();
		temp.setNext(null);
		--size;
		
		return temp;
	}

	//DONE
	public Node<T> deleteLast() {
		if (null == head || null == head.getNext()) {
			return deleteFirst();
		}

		Node<T> temp = head;
		Node<T> prev = head;
		while (null != temp.getNext()) {
			prev = temp;
			temp = temp.getNext();
		}
		--size;
		prev.setNext(null);
		
		return temp;
	}

	//DONE
	public void deleteAt(int pos) {
		if (pos < 0 || pos >= size) {
			System.out.println(INVALIDMES);
			return;
		}

		if (pos == 0) {
			deleteFirst();
			return;
		}

		if (pos == (size - 1)) {
			deleteLast();
			return;
		}

		Node<T> prev = head;
		int count = 0;
		while (count < (pos - 1)) {
			prev = prev.getNext();
			++count;
		}

		Node<T> temp = prev.getNext();
		prev.setNext(temp.getNext());

		temp.setNext(null);
	}

	public void delete(T data) {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return;
		}

		if (data.equals(head.getData())) {
			deleteFirst();
			return;
		}

		Node<T> temp = head;
		Node<T> prev = head;
		while (null != temp) {
			if (data.equals(temp.getData())) {
				break;
			}
			prev = temp;
			temp = temp.getNext();
		}

		if (null == temp) {
			System.out.println(data + " not found in linked list");
			return;
		}

		prev.setNext(temp.getNext());
		--size;
	}

	public T getAt(int position) {
		if (null == head) {
			System.out.println(SINGLY_LINKED_LIST_IS_EMPTY);
			return null;
		}

		if (position < 0 || position >= size) {
			System.out.println(INVALIDMES);
			return null;
		}

		int count = 1;
		Node<T> temp = head;
		while (count != position) {
			temp = temp.getNext();
			++count;
		}

		return temp.getData();
	}

	//DONE
	public void print() {
		Node<T> temp = head;
		while (null != temp) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
		System.out.println("null");
	}

	//DONE
	public boolean isEmpty() {
		return head == null;
	}

	private void addAfter(Node<T> curr, T newData) {
		Node<T> newNode = new Node<>(newData);
		newNode.setNext(curr.getNext());
		curr.setNext(newNode);
		++size;
	}
}