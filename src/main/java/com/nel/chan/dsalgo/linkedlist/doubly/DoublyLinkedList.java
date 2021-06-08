package com.nel.chan.dsalgo.linkedlist.doubly;

/**
 * 
 * @author Chandrakanth Nelge
 * @date   25-Aug-2017 12:09:07 pm
 */
public class DoublyLinkedList<T> {
	
	private static final String DOUBLY_LINKED_LIST_IS_EMPTY = "Doubly linked list is empty";
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	/**
	 * Add element at first to double linked list
	 */
	public void addFirst(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = head;
		if(isEmpty()) {
			tail = newNode;
		}else {
			head.prev = newNode;
		}
		
		head = newNode;
		++size;
	}
	
	/**
	 * Add element at last to linked list
	 */
	public void addLast(T data) {
		Node<T> newNode = new Node<>(data);
		if(isEmpty()) {
			head = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		++size;
	}
	
	/**
	 * Add element at given position to linked list
	 */
	public void addAt(T data, int position) {
		if(position > 1 && position <= getSize()) {
			System.out.println("invalid position");
			return;
		}
		
		if(position == 1) {
			addFirst(data);
			return;
		}
		
		if(position == (getSize() + 1)) {
			addLast(data);
			return;
		}
		
		Node<T> temp = head;
		int count = 1;
		while(count != position) {
			temp = temp.next;
			++count;
		}
		
		Node<T> newNode = new Node<>(data);
		newNode.next = temp;
		newNode.prev = temp.prev;
		temp.prev.next = newNode;
		temp.prev = newNode;
		++size;
	}
	
	/**
	 * Add element at given position to linked list
	 */
	public void addAfter(T data, T newData) {
		if(isEmpty()) {
			System.out.println(DOUBLY_LINKED_LIST_IS_EMPTY);
			return;
		}
		
		boolean isDataFound = false;
		Node<T> temp = head;
		while(null != temp) {
			if(data.equals(temp.data)) {
				addAfter(temp, newData);
				isDataFound = true;
				break;
			}
			temp = temp.next;
		}
		
		if(!isDataFound) {
			System.out.println(data + " is not found in Linked list");
		}
	}
	
	/**
	 * Add element after given node to linked list
	 */
	private void addAfter(Node<T> prev, T newData) {
		if(null == prev) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		
		Node<T> newNode = new Node<>(newData);
		Node<T> next = prev.next;
		newNode.prev = prev;
		newNode.next = next;
		prev.next = newNode;
		if(null != next) {
			next.prev = newNode;
		}else{
			tail = newNode;
		}
		++size;
	}
	
	/**
	 * Delete first element from double linked list
	 */
	public void deleteFirst() {
		if(isEmpty()) {
			System.out.println(DOUBLY_LINKED_LIST_IS_EMPTY);
			return;
		}
		
		if(head == tail) {
			tail = null;
			head = null;
		}else {
			Node<T> temp = head;
			head = temp.next;
			head.prev = null;
			temp = null;
		}
		--size;
	}
	
	/**
	 * Delete last element from linked list
	 */
	public void deleteLast() {
		if(null == head) {
			System.out.println(DOUBLY_LINKED_LIST_IS_EMPTY);
			return;
		}
		
		//IF LINKED LIST CONTAINS ONLY ONE ELEMENT
		if(null == head.next) {
			head = null;
			tail = null;
			return;
		}
		
		Node<T> temp = tail;
		tail = temp.prev;
		tail.next = null;
		temp = null;
		--size;
	}
	
	/**
	 * Delete element at given position from linked list
	 */
	public void deleteAt(int position) {
		if(null == head) {
			System.out.println(DOUBLY_LINKED_LIST_IS_EMPTY);
			return;
		}
		
		if(position < 1 || position > getSize()) {
			System.out.println("invalid position");
			return;
		}
		
		if(position == 1) {
			deleteFirst();
			return;
		}
		
		if(position == getSize()) {
			deleteLast();
			return;
		}
		
		Node<T> temp = head;
		int count = 1;
		while(position != count) {
			temp = temp.next;
			++count;
		}
		
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp = null;
		--size;
	}
	
	/**
	 * Delete a given element from a linked list
	 */
	public void delete(T data) {
		if(null == head) {
			System.out.println(DOUBLY_LINKED_LIST_IS_EMPTY);
			return;
		}
		
		//IF ELEMENT IS FIRST ELEMENT FROM LINKED LIST
		if(data.equals(head.data)) {
			deleteFirst();
			return;
		}
		
		Node<T> temp = head;
		while(null != temp) {
			if(data.equals(temp.data)) {
				break;
			}
			temp = temp.next;
		}
		
		if(null == temp) {
			System.out.println(data + " not found in linked list");
			return;
		}
		
		if(temp == tail){
			tail = temp.prev;
			tail.next = null;
		}else{
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
		
		temp = null;
		--size;
	}
	
	/**
	 * Check is linked list empty
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * Fetch linked list size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Display linked list
	 */
	public void display() {
		if(isEmpty()) {
			System.out.println(DOUBLY_LINKED_LIST_IS_EMPTY);
			return;
		}
		
		Node<T> temp = head;
		while(null != temp) {
			System.out.print("Data = "+ temp.data);
			
			if(null != temp.prev){
				System.out.print(" Prev = "+ temp.prev.data);
			}
			if(null != temp.next){
				System.out.print(" Next = "+ temp.next.data);
			}
			System.out.println();
			
			temp = temp.next;
		}
	}
	
	/**
	 * Display linked list
	 */
	public void displayReverse() {
		if(isEmpty()) {
			System.out.println(DOUBLY_LINKED_LIST_IS_EMPTY);
			return;
		}
		
		Node<T> temp = tail;
		while(null != temp) {
			System.out.print("Data = "+ temp.data);
			
			if(null != temp.prev){
				System.out.print(" Next = "+ temp.prev.data);
			}
			if(null != temp.next){
				System.out.print(" Prev = "+ temp.next.data);
			}
			System.out.println();
			
			temp = temp.prev;
		}
	}
	
	static class Node<T> {
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

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + ", prev=" + prev + "]";
		}
	}
}