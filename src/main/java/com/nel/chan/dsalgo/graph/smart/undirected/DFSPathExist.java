package com.nel.chan.dsalgo.graph.smart.undirected;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class DFSPathExist {

	private AdjacencyListGraph graph;

	public DFSPathExist(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public boolean isPathExist(int src, int destO) {
		boolean[] visited = new boolean[graph.size()];
		return isPathExist(src, destO, visited);
	}

	private boolean isPathExist(int src, int destO, boolean[] visited) {
		if (src == destO)
			return true;

		visited[src] = true;
		for (int dest : graph.neighbours(src)) {
			if (!visited[dest] && isPathExist(dest, destO, visited)) {
				return true;
			}
		}
		return false;
	}
}