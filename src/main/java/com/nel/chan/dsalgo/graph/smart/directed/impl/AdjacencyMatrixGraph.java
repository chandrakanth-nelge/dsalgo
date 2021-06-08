package com.nel.chan.dsalgo.graph.smart.directed.impl;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph {
	private int[][] graph;

	public AdjacencyMatrixGraph(Integer noOfVertices) {
		this.graph = new int[noOfVertices][noOfVertices];
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