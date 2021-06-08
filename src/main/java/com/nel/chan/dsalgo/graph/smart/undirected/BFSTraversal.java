package com.nel.chan.dsalgo.graph.smart.undirected;

import java.util.LinkedList;
import java.util.Queue;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class BFSTraversal {
	private AdjacencyListGraph graph;

	public BFSTraversal(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void bfs() {
		boolean[] visited = new boolean[graph.size()];
		for (int src = 0; src < graph.size(); src++) {
			if(!visited[src]) {
				bfs(src, visited);
			}
		}
	}

	private void bfs(int src, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[src] = true;
		queue.offer(src);
		
		while(!queue.isEmpty()) {
			int source = queue.poll();
			System.out.print(source + " ");
			
			for(int dest : graph.neighbours(source)) {
				if(!visited[dest]) {
					visited[dest] = true;
					queue.offer(dest);
				}
			}
		}
	}
}