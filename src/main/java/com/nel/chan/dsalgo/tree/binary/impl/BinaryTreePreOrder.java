package com.nel.chan.dsalgo.tree.binary.impl;

import java.util.Objects;
import java.util.Stack;

public class BinaryTreePreOrder<T extends Comparable<T>> extends BinaryTreeImpl<T> {

	@Override
	public void preOrder() {
		preOrderRec(root);
		System.out.println();
	}

	@Override
	public void preOrderIter() {
		preOrderIter(root);
		System.out.println();
	}

	private void preOrderRec(BinaryNode<T> node) {
		if (null == node) {
			return;
		}

		System.out.print(node.data + " ");
		preOrderRec(node.left);
		preOrderRec(node.right);
	}
	
	public void preOrderIter(BinaryNode<T> node) {
		if(Objects.isNull(node))
			return;
		
		Stack<BinaryNode<T>> stack = new Stack<>();
		BinaryNode<T> currentNode = node;
		while (!stack.empty() || currentNode != null) {
			if (currentNode != null) {
				stack.push(currentNode);
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.left;
			} else {
				BinaryNode<T> top = stack.pop();
				currentNode = top.right;
			}
		}
	}
}