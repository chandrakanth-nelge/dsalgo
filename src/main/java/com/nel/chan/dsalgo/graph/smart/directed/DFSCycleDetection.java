package com.nel.chan.dsalgo.graph.smart.directed;

import com.nel.chan.dsalgo.graph.smart.directed.impl.AdjacencyListGraph;

public class DFSCycleDetection {

	private AdjacencyListGraph graph;

	public DFSCycleDetection(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void cycleDetection() {
		boolean[] visited = new boolean[graph.size()];
		boolean[] recStack = new boolean[graph.size()];
		boolean isCycle = false;
		for (int src = 0; src < graph.size(); src++) {
			if (!visited[src] && cycleDetection(src, visited, recStack)) {
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

	private boolean cycleDetection(int src, boolean[] visited, boolean[] recStack) {
		visited[src] = true;
		recStack[src] = true;
		for (int dest : graph.neighbours(src)) {
			if (!visited[dest]) {
				if (cycleDetection(dest, visited, recStack)) {
					return true;
				}
			} else {
				if (recStack[dest]) {
					return true;
				}
			}
		}
		recStack[src] = false;
		return false;
	}
}