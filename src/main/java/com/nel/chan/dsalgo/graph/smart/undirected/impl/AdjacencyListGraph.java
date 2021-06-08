package com.nel.chan.dsalgo.graph.smart.undirected.impl;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph {
	private List<List<Integer>> graph;

	public AdjacencyListGraph(int noOfVertices) {
		this.graph = new ArrayList<>(noOfVertices);
		for (int i = 0; i < noOfVertices; i++) {
			this.graph.add(new ArrayList<>());
		}
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

	public void degree(int source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		System.out.println(neighbours(source).size());
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

	private boolean isVertexExist(int vertex) {
		return vertex < graph.size();
	}
}