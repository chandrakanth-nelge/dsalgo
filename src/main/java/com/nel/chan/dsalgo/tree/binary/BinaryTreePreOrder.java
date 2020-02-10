package com.nel.chan.dsalgo.tree.binary;

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

	private void preOrderIter(BinaryNode<T> node) {
		if (null == node) {
			return;
		}

		Stack<BinaryNode<T>> stack = new Stack<>();
		stack.push(node);
		while (!stack.empty()) {
			BinaryNode<T> n = stack.pop();
			System.out.print(n.data + " ");
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
	}
}