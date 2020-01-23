package com.nel.chan.dsalgo.queue.impl;

import com.nel.chan.dsalgo.queue.Queue;

public class QueueArrayImpl<T> implements Queue<T> {
	private T[] arr;
	private int front;
	private int rear;
	private int capacity;
	private int size;

	@SuppressWarnings("unchecked")
	public QueueArrayImpl(int capacity) {
		this.capacity = capacity;
		arr = (T[]) new Object[this.capacity];
		front = 0;
		rear = -1;
		size = 0;
	}

	@Override
	public void enqueue(T data) {
		if (null == data) {
			System.out.println("data is mandatory");
			return;
		}
		
		if (isFull()) {
			System.out.println("OverFlow!! Program Terminated");
			return;
		}

		rear = (rear + 1) % capacity;
		arr[rear] = data;
		size = size + 1;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			System.out.println("UnderFlow!! Program Terminated");
			return null;
		}
		
		T data = arr[front];
		front = (front + 1) % capacity;
		size = size - 1;
		
		return data;
	}
	
	@Override
	public T front() {
		if (isEmpty()) {
			System.out.println("UnderFlow!! Program Terminated");
			return null;
		}
		
		return arr[front];
	}
	
	@Override
	public T rear() {
        if (isEmpty()) {
        	System.out.println("UnderFlow!! Program Terminated");
            return null;
        }
           
        return arr[rear]; 
    } 

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void print() {
		for (int i = front; i <= rear; i++) {
			System.out.print(arr[i] + " -> ");
		}
		
		System.out.println();
	}

	private Boolean isFull() {
		return (size == capacity);
	}
}