package com.nel.chan.dsalgo.graph.smart.undirected;

import java.util.LinkedList;
import java.util.Queue;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class BFSPathExist {

	private AdjacencyListGraph graph;

	public BFSPathExist(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public boolean isPathExist(int src, int destO) {
		if (src == destO)
			return true;

		boolean[] visited = new boolean[graph.size()];
		Queue<Integer> queue = new LinkedList<>();
		visited[src] = true;
		queue.offer(src);

		while (!queue.isEmpty()) {
			int source = queue.poll();
			for (int dest : graph.neighbours(source)) {
				if (!visited[dest]) {
					if (dest == destO) {
						return true;
					}
					visited[dest] = true;
					queue.offer(dest);
				}
			}
		}

		return visited[destO];
	}
}