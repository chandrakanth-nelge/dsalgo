package com.nel.chan.dsalgo.graph.smart.directed;

import java.util.Stack;

import com.nel.chan.dsalgo.graph.smart.directed.impl.AdjacencyListGraph;

public class DFSTopologicalSorting {

	private AdjacencyListGraph graph;

	public DFSTopologicalSorting(AdjacencyListGraph graph) {
		this.graph = graph;
	}

	public void topologicalSorting() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[graph.size()];
		for (int src = 0; src < graph.size(); src++) {
			if (!visited[src]) {
				topologicalSorting(src, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

	private void topologicalSorting(int src, boolean[] visited, Stack<Integer> stack) {
		visited[src] = true;
		for (int dest : graph.neighbours(src)) {
			if (!visited[dest]) {
				topologicalSorting(dest, visited, stack);
			}
		}

		stack.push(src);
	}
}