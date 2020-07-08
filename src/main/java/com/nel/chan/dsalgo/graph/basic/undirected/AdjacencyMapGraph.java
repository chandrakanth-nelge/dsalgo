package com.nel.chan.dsalgo.graph.basic.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMapGraph {
	private static final String VERTEX_DOESN_T_EXIST = "Vertex doesn't exist";

	private Map<Integer, List<Integer>> graph;

	public AdjacencyMapGraph() {
		graph = new HashMap<>();
	}

	public void addVertex(int vertex) {
		if (isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		graph.put(vertex, new ArrayList<>());
	}

	public void removeVertex(Integer vertex) {
		if (!isVertexExist(vertex)) {
			throw new IllegalArgumentException(VERTEX_DOESN_T_EXIST);
		}

		for (Map.Entry<Integer, List<Integer>> edges : graph.entrySet()) {
			edges.getValue().remove(vertex);
		}
		graph.remove(vertex);
	}

	public void addEdge(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException(VERTEX_DOESN_T_EXIST);
		}

		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}

	public void removeEdge(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException(VERTEX_DOESN_T_EXIST);
		}

		graph.get(source).remove(Integer.valueOf(destination));
		graph.get(destination).remove(Integer.valueOf(source));
	}

	public List<Integer> vertices() {
		List<Integer> vertices = new ArrayList<>();
		for (Integer vertex : graph.keySet()) {
			vertices.add(vertex);
		}

		return vertices;
	}

	public List<Integer> neighbours(int vertex) {
		if (!isVertexExist(vertex)) {
			throw new IllegalArgumentException(VERTEX_DOESN_T_EXIST);
		}

		return graph.get(vertex);
	}

	public boolean hasVertex(int vertex) {
		return isVertexExist(vertex);
	}

	public boolean hasEdge(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException(VERTEX_DOESN_T_EXIST);
		}

		return neighbours(source).contains(Integer.valueOf(destination));
	}

	public int size() {
		return graph.size();
	}

	public void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			System.out.print(entry.getKey() + " ---> ");
			for (Integer edge : entry.getValue()) {
				System.out.print(edge + " ");
			}
			System.out.println();
		}
	}

	public void bfs(int source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException(VERTEX_DOESN_T_EXIST);
		}

		boolean[] visited = new boolean[size()];
		visited[source] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		while (!queue.isEmpty()) {
			int src = queue.poll();
			System.out.print(src + " ");
			for (int dest : neighbours(src)) {
				if (!visited[dest]) {
					visited[dest] = true;
					queue.offer(dest);
				}
			}
		}
		System.out.println();
	}

	public void dfs(int source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException(VERTEX_DOESN_T_EXIST);
		}

		boolean[] visited = new boolean[size()];
		visited[source] = true;
		Stack<Integer> stack = new Stack<>();
		stack.add(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			System.out.print(src + " ");
			for (int dest : neighbours(src)) {
				if (!visited[dest]) {
					stack.push(dest);
					visited[dest] = true;
				}
			}
		}
		System.out.println();
	}

	public int findDegree(int source) {
		if (!isVertexExist(source)) {
			return -1;
		}

		return neighbours(source).size();
	}

	public boolean isPathExists(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException(VERTEX_DOESN_T_EXIST);
		}

		if (source == destination) {
			return true;
		}

		boolean isPathExists = false;
		boolean[] visited = new boolean[size()];
		visited[source] = true;
		Stack<Integer> stack = new Stack<>();
		stack.add(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			for (int dest : neighbours(src)) {
				if (!visited[dest]) {
					if (dest == destination) {
						isPathExists = true;
						break;
					}
					stack.add(dest);
					visited[dest] = true;
				}
			}
		}

		return isPathExists;
	}

	public void connectedComponents() {
		boolean[] visited = new boolean[size()];
		int noOfComponents = 0;
		for (int source = 0; source < size(); source++) {
			if (!visited[source]) {
				dfsUtil(source, visited);
				++noOfComponents;
			}
		}
		System.out.println("Connected Components = " + noOfComponents);
	}

	private void dfsUtil(int source, boolean[] visited) {
		visited[source] = true;

		Stack<Integer> stack = new Stack<>();
		stack.add(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			for (int dest : neighbours(src)) {
				if (!visited[dest]) {
					stack.push(dest);
					visited[dest] = true;
				}
			}
		}
	}

	private boolean isValidEdges(int source, int destination) {
		if (!isVertexExist(source)) {
			System.out.println(source + " = is InValid Vertx");
			return false;
		}

		if (!isVertexExist(destination)) {
			System.out.println(destination + " = is InValid Vertx");
			return false;
		}

		return true;
	}

	private boolean isVertexExist(int vertex) {
		return graph.containsKey(vertex);
	}
}