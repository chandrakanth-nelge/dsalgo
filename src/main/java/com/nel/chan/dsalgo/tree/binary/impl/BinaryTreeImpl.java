package com.nel.chan.dsalgo.tree.binary.impl;

import java.util.Objects;

import com.nel.chan.dsalgo.tree.binary.BinaryTree;

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {
	protected BinaryNode<T> root;

	public BinaryTreeImpl() {
		root = null;
	}

	public BinaryTreeImpl(T data) {
		root = new BinaryNode<>(data);
	}

	@Override
	public void insert(T data) {
		if(Objects.isNull(data)) {
			return;
		}
		root = insert(root, data);
	}

	@Override
	public void insertIter(T data) {
		insertIter(root, data);
	}

	@Override
	public boolean search(T val) {
		return search(root, val);
	}

	private BinaryNode<T> insert(BinaryNode<T> node, T data) {
		if(Objects.isNull(node)) {
			return new BinaryNode<>(data);
		}

		if (data.compareTo(node.data) < 0) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}

		return node;
	}

	private void insertIter(BinaryNode<T> node, T data) {
		BinaryNode<T> newNode = new BinaryNode<>(data);
		if (node == null) {
			root = newNode;
		} else {
			BinaryNode<T> current = node;
			BinaryNode<T> parent;
			while (true) {
				parent = current;
				if (data.compareTo(current.data) < 0) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	private boolean search(BinaryNode<T> node, T val) {
		if (node.data == val) {
			return true;
		}

		if (node.left != null && search(node.left, val)) {
			return true;
		}

		return node.right != null && search(node.right, val);
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(BinaryNode<T> node) {
		if (node == null) {
			return 0;
		}

		return 1 + size(node.left) + size(node.right);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("");
		inOrderTraversal(root, builder);
		return builder.toString();
	}

	private void inOrderTraversal(BinaryNode<T> btn, StringBuilder builder) {
		if (btn == null) {
			return;
		}

		inOrderTraversal(btn.left, builder);
		builder.append(btn.data).append(" ");
		inOrderTraversal(btn.right, builder);
	}

	static class BinaryNode<T> /* implements Comparable<T> */ {
		T data;
		BinaryNode<T> left;
		BinaryNode<T> right;

		public BinaryNode() {

		}

		public BinaryNode(T data) {
			this.data = data;
		}

		/*
		 * @Override public int hashCode() { final int prime = 31; int result = 1;
		 * result = prime * result + ((data == null) ? 0 : data.hashCode()); return
		 * result; }
		 * 
		 * @SuppressWarnings("rawtypes")
		 * 
		 * @Override public boolean equals(Object obj) { if (this == obj) { return true;
		 * }
		 * 
		 * if (obj == null) { return false; }
		 * 
		 * if (getClass() != obj.getClass()) { return false; }
		 * 
		 * BinaryNode other = (BinaryNode) obj; if (data == null) { if (other.data !=
		 * null) { return false; } } else if (!data.equals(other.data)) { return false;
		 * }
		 * 
		 * return true; }
		 * 
		 * @Override public int compareTo(T node) { return 0; }
		 */

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
	}

	@Override
	public void preOrder() {
		// DO NOTHING
	}

	@Override
	public void preOrderIter() {
		// DO NOTHING
	}

	@Override
	public void inOrder() {
		// DO NOTHING
	}

	@Override
	public void inOrderIter() {
		// DO NOTHING
	}

	public void postOrder() {
		// DO NOTHING
	}

	@Override
	public void postOrderIter() {
		// DO NOTHING
	}
}