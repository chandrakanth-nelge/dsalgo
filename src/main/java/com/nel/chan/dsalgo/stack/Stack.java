package com.nel.chan.dsalgo.stack;

/**
 * @author Chandrakanth Nelge
 */
public interface Stack<T> {
	void push(T t);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
	void display();
	void printReverse();
}