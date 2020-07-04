package com.nel.chan.dsalgo.graph.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyListGraph {
	private List<List<Integer>> graph;

	public AdjacencyListGraph(int noOfVertices) {
		this.graph = new ArrayList<>(noOfVertices);
		for (int i = 0; i < noOfVertices; i++) {
			graph.add(new ArrayList<>());
		}
	}

	public void addVertex(int vertex) {
		System.out.println("NA = " + vertex);
	}

	public void removeVertex(Integer vertex) {
		System.out.println("NA = " + vertex);
	}

	public void addEdge(int source, int destination) {
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}

	public void removeEdge(int source, int destination) {
		graph.get(source).remove(Integer.valueOf(destination));
		graph.get(destination).remove(Integer.valueOf(source));
	}

	public List<Integer> vertices() {
		List<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < size(); i++) {
			vertices.add(i);
		}

		return vertices;
	}

	public List<Integer> neighbours(int source) {
		List<Integer> neighbours = new ArrayList<>();
		for (Integer edge : graph.get(source)) {
			neighbours.add(edge);
		}

		return neighbours;
	}

	public boolean hasVertex(int vertex) {
		return isVertexExist(vertex);
	}

	public boolean hasEdge(int source, int destination) {
		return graph.get(source).contains(Integer.valueOf(destination));
	}

	public int size() {
		return graph.size();
	}

	public void printGraph() {
		for (int source = 0; source < size(); source++) {
			System.out.print("[" + source + "]" + " ---> ");
			System.out.print(graph.get(source));
			System.out.println();
		}
	}

	public void bfs(int source) {
		boolean[] visited = new boolean[size()];
		Queue<Integer> q = new LinkedList<>();
		visited[source] = true;
		q.offer(source);
		while (!q.isEmpty()) {
			int src = q.poll();
			System.out.print(src + " ");
			
			for (int dest : graph.get(src)) {
				if (!visited[dest]) {
					visited[dest] = true;
					q.offer(dest);
				}
			}
		}
		System.out.println();
	}

	public void dfs(int source) {
		boolean[] visited = new boolean[size()];
		visited[source] = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			System.out.print(src + " ");

			for (int dest : graph.get(src)) {
				if (!visited[dest]) {
					stack.push(dest);
					visited[dest] = true;
				}
			}
		}
		System.out.println();
	}

	public void dfsUtil(int source, boolean[] visited) {
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			if (!visited[src]) {
				visited[src] = true;
				System.out.print(src + " ");

				for (int dest : graph.get(src)) {
					if (!visited[dest]) {
						stack.push(dest);
					}
				}
			}
		}
		System.out.println();
	}

	private boolean isVertexExist(int vertex) {
		return !graph.get(vertex).isEmpty();
	}
}