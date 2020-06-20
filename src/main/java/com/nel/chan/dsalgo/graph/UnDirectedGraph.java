package com.nel.chan.dsalgo.graph;

public abstract class UnDirectedGraph<V> implements Graph<V> {

	@Override
	public void addEdge(V src, V dest) {
		addEdgeInternal(src, dest);
		addEdgeInternal(dest, src);
	}

	@Override
	public void addEdge(V src, V dest, int weight) {
		addEdgeInternal(src, dest, weight);
		addEdgeInternal(dest, src, weight);
	}

	public abstract void addEdgeInternal(V src, V dest);
	public abstract void addEdgeInternal(V src, V dest, int weight);
}