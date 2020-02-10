package com.nel.chan.dsalgo.tree.binary;

public class BinaryNode<T> implements Comparable<T> {
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode() {
		super();
	}

	public BinaryNode(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}
	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
	public BinaryNode<T> getRight() {
		return right;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		BinaryNode other = (BinaryNode) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(T node) {
		return 0;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}