package com.nel.chan.dsalgo.tree.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeInOrder<T extends Comparable<T>> extends BinaryTreeImpl<T> {

	@Override
	public void insert(T data) {
		if (isEmpty()) {
			root = new BinaryNode<>(data);
			return;
		}
		
		insertInOrder(root, data);
	}

	@Override
	public void inOrder() {
		inOrderRec(root);
		System.out.println();
	}

	@Override
	public void inOrderIter() {
		inOrderIter(root);
		System.out.println();
	}

	private void insertInOrder(BinaryNode<T> node, T data) {
		Queue<BinaryNode<T>> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
            node = q.peek();
            q.remove();
       
            if (node.left == null) {
                node.left = new BinaryNode<>(data);
                break;
            } else {
                q.add(node.left);
            }
       
            if (node.right == null) {
                node.right = new BinaryNode<>(data); 
                break;
            } else {
                q.add(node.right);
            }
        } 
	}

	public void inOrderRec(BinaryNode<T> node) {
		if (null == node) {
			return;
		}

		inOrderRec(node.left);
		System.out.print(node.data + " ");
		inOrderRec(node.right);
	}

	public void inOrderIter(BinaryNode<T> node) {
		if (null == node) {
			return;
		}

		Stack<BinaryNode<T>> s = new Stack<>();
		BinaryNode<T> currentNode = node;
		while (!s.empty() || currentNode != null) {
			if (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			} else {
				BinaryNode<T> n = s.pop();
				System.out.print(n.data + " ");
				currentNode = n.right;
			}
		}
	}
}