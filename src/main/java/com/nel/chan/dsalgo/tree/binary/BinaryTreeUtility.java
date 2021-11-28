package com.nel.chan.dsalgo.tree.binary;

public class BinaryTreeUtility<T extends Comparable<T>> extends BinaryTreeImpl<T> {

	public int sum() {
		return sum(root);
	}

	private int sum(BinaryNode<T> node) {
		if (null == node) {
			return 0;
		}

		return (Integer) node.data + sum(node.left) + sum(node.right);
	}

	public int max() {
		return max(root);
	}

	private int max(BinaryNode<T> node) {
		if (null == node) {
			return Integer.MIN_VALUE;
		}

		return Math.max((Integer) node.data, Math.max(max(node.left), max(node.right)));
	}
	
	public int height() {
		return height(root);
	}

	private int height(BinaryNode<T> node) {
		if (null == node) {
			return -1;
		}

		return 1 + Math.max(height(node.left), height(node.right));
	}
}