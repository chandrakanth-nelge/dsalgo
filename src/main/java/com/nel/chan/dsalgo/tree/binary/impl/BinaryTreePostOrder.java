package com.nel.chan.dsalgo.tree.binary.impl;

import java.util.Objects;
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
		postOrderIteTwoStack(root);
		System.out.println();
	}

	private void postOrderRec(BinaryNode<T> node) {
		if(Objects.isNull(node))
			return;

		postOrderRec(node.left);
		postOrderRec(node.right);
		System.out.print(node.data + " ");
	}

	private void postOrderIter(BinaryNode<T> node) {
		if(Objects.isNull(node))
			return;

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
	
	private void postOrderIteTwoStack(BinaryNode<T> node) {
		if(Objects.isNull(node))
			return;

		Stack<BinaryNode<T>> st1 = new Stack<>();
		Stack<BinaryNode<T>> st2 = new Stack<>();
		BinaryNode<T> current = node;
		st1.push(current);
		while(!st1.isEmpty()) {
			BinaryNode<T> temp = st1.pop();
			st2.push(temp);
			if(temp.left != null)
				st1.push(temp.left);
			if(temp.right != null)
				st1.push(temp.right);
		}
		
		while(!st2.isEmpty()) {
			BinaryNode<T> top = st2.pop();
			System.out.print(top.data + " ");
		}
		System.out.println();
	}
}