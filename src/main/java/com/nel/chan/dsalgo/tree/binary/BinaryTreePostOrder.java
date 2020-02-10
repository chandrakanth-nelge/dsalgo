package com.nel.chan.dsalgo.tree.binary;

import java.util.Stack;

//https://hellokoding.com/tree-traversal-with-depth-first-search/
public class BinaryTreePostOrder<T extends Comparable<T>> extends BinaryTreeImpl<T> {

	@Override
	public void postOrder() {
		postOrderRec(root);
		System.out.println();
	}

	@Override
	public void postOrderIter() {
		postOrderIter(root);
		System.out.println();
	}

	private void postOrderRec(BinaryNode<T> node) {
		if (null == node) {
			return;
		}

		postOrderRec(node.left);
		postOrderRec(node.right);
		System.out.print(node.data + " ");
	}

	private void postOrderIter(BinaryNode<T> node) {
		if (null == node) {
			return;
		}

		Stack<BinaryNode<T>> s = new Stack<>();
		BinaryNode<T> current = node;
		while (true) {
			if (current != null) {
				if (current.right != null) {
					s.push(current.right);
				}
				s.push(current);
				current = current.left;
				continue;
			}

			if (s.isEmpty()) {
				return;
			}

			current = s.pop();
			if (current.right != null && !s.isEmpty() && current.right == s.peek()) {
				s.pop();
				s.push(current);
				current = current.right;
			} else {
				System.out.print(current.data + " ");
				current = null;
			}
		}
	}
}