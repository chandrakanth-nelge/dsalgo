package com.nel.chan.dsalgo.graph.smart.undirected;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class DFSConnectedComponents {
	
	private AdjacencyListGraph graph;

	public DFSConnectedComponents(AdjacencyListGraph graph) {
		this.graph = graph;
	}
	
	public void connectedComponents() {
		boolean[] visited = new boolean[graph.size()];
		int count = 0;
		for (int src = 0; src < graph.size(); src++) {
			if(!visited[src]) {
				connectedComponents(src, visited);
				++count;
			}
		}
		
		System.out.println("connectedComponents = " + count);
	}
	
	private void connectedComponents(int src, boolean[] visited) {
		visited[src] = true;
		for (int dest : graph.neighbours(src)) {
			if (!visited[dest]) {
				visited[dest] = true;
				connectedComponents(dest, visited);
			}
		}
	}
}