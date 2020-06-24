package com.nel.chan.dsalgo.graph.impl.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyListGraph {
	private List<Integer> vertices;
	private List<List<Integer>> graph;

	public AdjacencyListGraph(int noOfVertices) {
		this.vertices = new ArrayList<>(noOfVertices);
		this.graph = new ArrayList<>(noOfVertices);
		for (int i = 0; i < noOfVertices; i++) {
			graph.add(new ArrayList<>());
		}
	}

	public void addVertex(int vertex) {
		if (isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		vertices.add(vertex);
	}

	public void removeVertex(Integer vertex) {
		int sourceIndex = getVertexIndex(vertex);
		if (sourceIndex == -1) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		for (List<Integer> edges : graph) {
			edges.remove(Integer.valueOf(sourceIndex));
		}

		graph.get(sourceIndex).clear();
	}

	public void addEdge(int source, int destination) {
		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		graph.get(sourceIndex).add(destinationIndex);
		graph.get(destinationIndex).add(sourceIndex);
	}

	public void removeEdge(int source, int destination) {
		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		graph.get(sourceIndex).remove(Integer.valueOf(destinationIndex));
		graph.get(destinationIndex).remove(Integer.valueOf(sourceIndex));
	}

	public List<Integer> vertices() {
		return vertices;
	}

	public List<Integer> neighbors(int vertex) {
		int sourceIndex = getVertexIndex(vertex);
		if (sourceIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		List<Integer> neighbors = new ArrayList<>();
		for (Integer edge : graph.get(sourceIndex)) {
			neighbors.add(vertices.get(edge));
		}

		return neighbors;
	}

	public boolean hasVertex(int vertex) {
		return isVertexExist(vertex);
	}

	public boolean hasEdge(int source, int destination) {
		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		return graph.get(sourceIndex).contains(Integer.valueOf(destinationIndex));
	}

	public int size() {
		return vertices.size();
	}

	public void printGraph() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex " + vertices.get(i) + " is connected to: ");
			for (Integer edge : graph.get(i)) {
				System.out.print(vertices.get(edge) + " ");
			}
			System.out.println();
		}
	}

	public void bfs(int source) {
		boolean[] visited = new boolean[vertices.size()];
		Queue<Integer> q = new LinkedList<>();
		visited[getVertexIndex(source)] = true;
		q.offer(source);
		while (!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u + " ");

			for (int v : graph.get(getVertexIndex(u))) {
				int destinationIndex = getVertexIndex(v);
				if (!visited[destinationIndex]) {
					visited[destinationIndex] = true;
					q.offer(v);
				}
			}
		}
	}

	public void dfs(int s) {
		boolean[] visited = new boolean[vertices.size()];
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while (!stack.isEmpty()) {
			int u = stack.pop();
			int sourceIndex = getVertexIndex(u);
			if (!visited[sourceIndex]) {
				visited[sourceIndex] = true;
				System.out.print(u + " ");

				for (int v : graph.get(sourceIndex)) {
					if (!visited[getVertexIndex(v)]) {
						stack.push(v);
					}
				}
			}
		}
	}

	private boolean isVertexExist(int vertex) {
		return vertices.contains(vertex);
	}

	private int getVertexIndex(int vertex) {
		return vertices.indexOf(vertex);
	}
}