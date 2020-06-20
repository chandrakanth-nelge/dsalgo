package com.nel.chan.dsalgo.graph;

public abstract class DirectedGraph<V> implements Graph<V> {

	@Override
	public void addEdge(V src, V dest) {
		addEdgeInternal(src, dest);
	}

	@Override
	public void addEdge(V src, V dest, int weight) {
		addEdgeInternal(src, dest, weight);
	}

	public abstract void addEdgeInternal(V src, V dest);
	public abstract void addEdgeInternal(V src, V dest, int weight);
}