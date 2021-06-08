package com.nel.chan.dsalgo.graph.smart.undirected;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class DFSCycleDetection {

	private AdjacencyListGraph graph;

	public DFSCycleDetection(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void cycleDetection() {
		boolean[] visited = new boolean[graph.size()];
		boolean isCycle = false;
		for (int src = 0; src < graph.size(); src++) {
			if (!visited[src] && cycleDetection(src, visited, -1)) {
				isCycle = true;
				break;
			}
		}

		if (isCycle) {
			System.out.println("Graph is cyclic");
		} else {
			System.out.println("Graph is not cyclic");
		}
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