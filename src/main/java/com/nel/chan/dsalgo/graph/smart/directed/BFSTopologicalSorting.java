package com.nel.chan.dsalgo.graph.smart.directed;

import java.util.LinkedList;
import java.util.Queue;

import com.nel.chan.dsalgo.graph.smart.directed.impl.AdjacencyListGraph;

public class BFSTopologicalSorting {

	private AdjacencyListGraph graph;

	public BFSTopologicalSorting(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void topologicalSorting() {
		int[] indegree = new int[graph.size()];
		prepareIndegree(indegree);

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int src = q.poll();
			System.out.print(src + " ");
			for (int dest : graph.neighbours(src)) {
				indegree[dest] = indegree[dest] - 1;
				if (indegree[dest] == 0) {
					q.offer(dest);
				}
			}
		}
	}

	private void prepareIndegree(int[] indegree) {
		for (int src = 0; src < graph.size(); src++) {
			for (int dest : graph.neighbours(src)) {
				indegree[dest] = indegree[dest] + 1;
			}
		}
	}
}