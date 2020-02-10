package com.nel.chan.dsalgo.tree.binary;

public interface BinaryTree<T> {
	void insert(T data);

	boolean search(T data);

	int size();

	boolean isEmpty();

	void insertIter(T data);
	
	void inOrder();

	void preOrder();

	void postOrder();

	void preOrderIter();

	void postOrderIter();

	void inOrderIter();
}