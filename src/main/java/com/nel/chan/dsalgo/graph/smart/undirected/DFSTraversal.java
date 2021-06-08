package com.nel.chan.dsalgo.graph.smart.undirected;

import java.util.Stack;

import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class DFSTraversal {
	private AdjacencyListGraph graph;

	public DFSTraversal(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void dfs() {
		boolean[] visited = new boolean[graph.size()];
		for (int src = 0; src < graph.size(); src++) {
			if (!visited[src]) {
				dfs(src, visited);
			}
		}
		System.out.println();
	}

	private void dfs(int src, boolean[] visited) {
		visited[src] = true;
		System.out.print(src + " ");

		for (int dest : graph.neighbours(src)) {
			if (!visited[dest]) {
				visited[dest] = true;
				dfs(dest, visited);
			}
		}
	}
	
	/**
	 * NEED TO RE-LOOK THE LOGIC
	 * @param source
	 */
	public void dfsIterative(int source) {
		boolean[] visited = new boolean[graph.size()];
		visited[source] = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			System.out.print(src + " ");
			for (int dest : graph.neighbours(src)) {
				if (!visited[dest]) {
					stack.push(dest);
					visited[dest] = true;
				}
			}
		}
		System.out.println();
	}
}