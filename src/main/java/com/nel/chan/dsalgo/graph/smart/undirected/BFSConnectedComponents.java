package com.nel.chan.dsalgo.graph.smart.undirected;

import java.util.LinkedList;
import java.util.Queue;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class BFSConnectedComponents {

	private AdjacencyListGraph graph;

	public BFSConnectedComponents(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void connectedComponents() {
		boolean[] visited = new boolean[graph.size()];
		int count = 0;
		for (int src = 0; src < graph.size(); src++) {
			if (!visited[src]) {
				connectedComponents(src, visited);
				++count;
			}
		}

		System.out.println("connectedComponents = " + count);
	}

	private void connectedComponents(int src, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[src] = true;
		queue.offer(src);

		while (!queue.isEmpty()) {
			int source = queue.poll();
			for (int dest : graph.neighbours(source)) {
				if (!visited[dest]) {
					visited[dest] = true;
					queue.offer(dest);
				}
			}
		}
	}
}