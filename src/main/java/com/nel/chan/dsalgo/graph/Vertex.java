package com.nel.chan.dsalgo.graph;

import java.util.List;

public class Vertex<V> {
	private V node;
	private List<Edge> edges;

	public Vertex() {
		super();
	}

	public Vertex(V node) {
		this.node = node;
	}

	public Vertex(List<Edge> edges) {
		this.edges = edges;
	}

	public Vertex(V node, List<Edge> edges) {
		this.node = node;
		this.edges = edges;
	}

	public void setNode(V node) {
		this.node = node;
	}
	public V getNode() {
		return node;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	public List<Edge> getEdges() {
		return edges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		@SuppressWarnings("unchecked")
		Vertex<V> other = (Vertex<V>) obj;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node)) {
			return false;
		}
		return true;
	}
}