package com.nel.chan.dsalgo.graph;

import java.util.List;

public interface Graph<V> {
	void addVertex(V vertex);
	void removeVertex(V vertex);
	void addEdge(V source, V destination);
	void addEdge(V source, V destination, int weight);
	void removeEdge(V source, V destination);
	
	List<V> vertices();
	List<V> neighbors(V vertex);
	
	boolean hasVertex(V vertex);
	boolean hasEdge(V source, V destination);
	
	void printGraph();
	int size();
}