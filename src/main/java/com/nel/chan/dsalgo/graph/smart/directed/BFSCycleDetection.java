package com.nel.chan.dsalgo.graph.smart.directed;

import java.util.LinkedList;
import java.util.Queue;

import com.nel.chan.dsalgo.graph.smart.directed.impl.AdjacencyListGraph;

public class BFSCycleDetection {

	private AdjacencyListGraph graph;

	public BFSCycleDetection(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void cycleDetection() {
		int[] indegree = prepareIndegree();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		int count = 0;
		while (!q.isEmpty()) {
			int src = q.poll();
			for (int dest : graph.neighbours(src)) {
				indegree[dest] = indegree[dest] - 1;
				if (indegree[dest] == 0) {
					q.offer(dest);
				}
			}

			++count;
		}

		if (count != graph.size()) {
			System.out.println("Graph is cyclic");
		} else {
			System.out.println("Graph is not cyclic");
		}

	}

	private int[] prepareIndegree() {
		int[] indegree = new int[graph.size()];
		for (int src = 0; src < graph.size(); src++) {
			for (int dest : graph.neighbours(src)) {
				indegree[dest] = indegree[dest] + 1;
			}
		}
		return indegree;
	}
}