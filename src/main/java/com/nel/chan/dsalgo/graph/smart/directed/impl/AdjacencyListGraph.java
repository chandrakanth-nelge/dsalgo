package com.nel.chan.dsalgo.graph.smart.directed.impl;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph {
	private List<List<Integer>> graph;

	public AdjacencyListGraph(int noOfVertices) {
		this.graph = new ArrayList<>(noOfVertices);
		for (int i = 0; i < noOfVertices; i++) {
			graph.add(new ArrayList<>());
		}
	}

	public void addEdge(int source, int destination) {
		graph.get(source).add(destination);
	}

	public void removeEdge(int source, int destination) {
		graph.get(source).remove(Integer.valueOf(destination));
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

	public int degree(int source) {
		if (!isVertexExist(source)) {
			return -1;
		}

		return neighbours(source).size();
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

	private boolean isVertexExist(int vertex) {
		return !graph.get(vertex).isEmpty();
	}
}