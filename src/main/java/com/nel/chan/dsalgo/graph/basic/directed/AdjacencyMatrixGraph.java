package com.nel.chan.dsalgo.graph.basic.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrixGraph {
	private int[][] graph;

	public AdjacencyMatrixGraph(Integer noOfVertices) {
		this.graph = new int[noOfVertices][noOfVertices];
	}

	public void addVertex(int vertex) {
		System.out.println("NA = " + vertex);
	}

	public void removeVertex(int vertex) {
		System.out.println("NA = " + vertex);
	}

	public void addEdge(Integer source, Integer destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		graph[source][destination] = 1;
	}

	public void removeEdge(Integer source, Integer destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		graph[source][destination] = 0;
	}

	public List<Integer> vertices() {
		List<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < size(); i++) {
			vertices.add(i);
		}

		return vertices;
	}

	public List<Integer> neighbours(Integer source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		List<Integer> neighbours = new ArrayList<>();
		for (int dest = 0; dest < size(); dest++) {
			if (graph[source][dest] == 1) {
				neighbours.add(dest);
			}
		}

		return neighbours;
	}

	public boolean hasVertex(Integer vertex) {
		return isVertexExist(vertex);
	}

	public boolean hasEdge(Integer source, Integer destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		return graph[source][destination] == 1;
	}

	public int size() {
		return graph.length;
	}

	public void printGraph() {
		for (int source = 0; source < size(); source++) {
			System.out.print("[" + source + "]" + " -> ");
			List<Integer> edges = new ArrayList<>();
			for (int dest = 0; dest < size(); dest++) {
				if (graph[source][dest] == 1) {
					edges.add(dest);
				}
			}
			System.out.print(edges);
			System.out.println("");
		}
	}

	public void bfs(int source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}
		
		boolean[] visited = new boolean[size()];
		visited[source] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(source);
		while (!q.isEmpty()) {
			int src = q.poll();
			System.out.print(src + " ");
			for (int dest = 0; dest < size(); dest++) {
				if (graph[src][dest] == 1 && !visited[dest]) {
					q.offer(dest);
					visited[dest] = true;
				}
			}
		}
		System.out.println();
	}

	public void dfs(int source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}
		
		boolean[] visited = new boolean[size()];
		visited[source] = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			System.out.print(src + " ");
			for (int dest = 0; dest < size(); dest++) {
				if (graph[src][dest] == 1 && !visited[dest]) {
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
			throw new IllegalArgumentException("Vertex doesn't exist");
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
	
	public void motherVertex(int source) {
		boolean[] visited = new boolean[size()];
		dfsUtil(source, visited);

		boolean isMotherVertex = true;
		for (int i = 0; i < size(); i++) {
			if (!visited[i]) {
				isMotherVertex = false;
				break;
			}
		}

		if (isMotherVertex) {
			System.out.println("Is a Mother vertex");
		} else {
			System.out.println("Not a Mother vertex");
		}
	}
	
	public int findMother() {
		if (size() == 0) {
			return -1;
		}

		boolean[] visited = new boolean[size()];
		int motherVertex = 0;
		for (int source : vertices()) {
			if (!visited[source]) {
				dfsUtil(source, visited);
				motherVertex = source;
			}
		}

		visited = new boolean[size()];
		dfsUtil(motherVertex, visited);

		for (int vertex : vertices()) {
			if (!visited[vertex]) {
				return -1;
			}
		}

		return motherVertex;
	}
	
	// https://www.geeksforgeeks.org/transitive-closure-of-a-graph/
	public int[][] transitiveClosure() {
		int[][] transitiveClosureMatrix = new int[size()][size()];
		for (int source : vertices()) {
			dfsUtil(source, source, transitiveClosureMatrix);
		}
		return transitiveClosureMatrix;
	}

	private void dfsUtil(int source, int dest, int[][] transitiveClosureMatrix) {
		transitiveClosureMatrix[source][dest] = 1;
		for (int vertex : neighbours(dest)) {
			if (transitiveClosureMatrix[source][vertex] == 0) {
				dfsUtil(source, vertex, transitiveClosureMatrix);
			}
		}
	}
	
	public void stronglyConnectedComponents() {
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
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			if (!visited[src]) {
				visited[src] = true;
				System.out.print(src + " ");
				for (int dest = 0; dest < size(); dest++) {
					if (graph[src][dest] == 1 && !visited[dest]) {
						stack.push(dest);
					}
				}
			}
		}
		System.out.println();
	}

	public boolean isCyclic() {
		boolean[] visited = new boolean[size()];
		for (int u = 0; u < size(); u++) {
			if (!visited[u]) {
				if (dfsCyclic(u, visited, -1)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfsCyclic(int vertex, boolean[] visited, int parent) {
		visited[vertex] = true;
		for (int i : neighbours(vertex)) {
			if (!visited[i]) {
				if (dfsCyclic(i, visited, vertex))
					return true;
			} else if (i != parent) {
				return true;
			}
		}

		return false;
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
		return vertex < size();
	}
}