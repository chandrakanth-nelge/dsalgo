package com.nel.chan.dsalgo.stack;

/**
 * @author Chandrakanth Nelge
 */
public interface Stack<T> {
	public void push(T t);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public int size();
	public void display();
}