package com.nel.chan.dsalgo.graph.factory;

public enum GraphType {
	MATRIX("com.nel.chan.dsalgo.graph.impl.undirected.AdjacencyMatrixGraph"),
	LIST("com.nel.chan.dsalgo.graph.impl.undirected.AdjacencyListGraph"),
	MAP("com.nel.chan.dsalgo.graph.impl.undirected.AdjacencyMapGraph");

	private String value;

	private GraphType(String graphType) {
		this.value = graphType;
	}

	public String value() {
		return value;
	}
}