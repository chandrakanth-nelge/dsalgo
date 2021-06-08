package com.nel.chan.dsalgo.graph.smart.undirected;

import java.util.LinkedList;
import java.util.Queue;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class BFSCycleDetection {

	private AdjacencyListGraph graph;

	public BFSCycleDetection(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void cycleDetection() {
		boolean isCycle = false;
		boolean[] visited = new boolean[graph.size()];
		for (int src = 0; src < graph.size(); src++) {
			if (!visited[src] && cycleDetection(src, visited)) {
				isCycle = true;
				break;
			}
		}

		if (isCycle) {
			System.out.println("Cycle found");
		} else {
			System.out.println("No Cycle found");
		}
	}

	public boolean cycleDetection(int src, boolean[] visited) {
		int[] parent = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			parent[i] = -1;
		}

		visited[src] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);

		boolean isCycle = false;
		while (!q.isEmpty()) {
			int source = q.poll();
			for (int dest : graph.neighbours(source)) {
				if (!visited[dest]) {
					visited[dest] = true;
					q.offer(dest);
					parent[dest] = source;
				} else {
					if (parent[source] != dest) {
						isCycle = true;
						break;
					}
				}
			}
			if (isCycle) {
				break;
			}
		}

		return isCycle;
	}
}