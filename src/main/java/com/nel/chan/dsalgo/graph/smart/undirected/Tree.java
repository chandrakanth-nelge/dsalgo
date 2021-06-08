package com.nel.chan.dsalgo.graph.smart.undirected;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class Tree {

	private AdjacencyListGraph graph;

	public Tree(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public boolean isTree() {
		boolean[] visited = new boolean[graph.size()];
		if (cycleDetection(0, visited, -1)) {
			return false;
		}

		for (int src = 0; src < graph.size(); src++) {
			if (!visited[src]) {
				return false;
			}
		}

		return true;
	}

	private boolean cycleDetection(int src, boolean[] visited, int parent) {
		visited[src] = true;
		for (int dest : graph.neighbours(src)) {
			if (!visited[dest]) {
				if (cycleDetection(dest, visited, src)) {
					return true;
				}
			} else {
				if (parent != dest) {
					return true;
				}
			}
		}
		return false;
	}
}