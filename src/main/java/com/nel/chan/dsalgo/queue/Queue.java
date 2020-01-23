package com.nel.chan.dsalgo.queue;

public interface Queue<T> {
	void enqueue(T t);
	T dequeue();
	T front();
	T rear();
	boolean isEmpty();
	public int size();
	public void print();
}