package com.nel.chan.dsalgo.graph.impl.basic;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph {
	private List<Integer> vertices;
	private int[][] graph;

	public AdjacencyMatrixGraph(int noOfVertices) {
		this.vertices = new ArrayList<>(noOfVertices);
		this.graph = new int[noOfVertices][noOfVertices];
	}

	public void addVertex(int vertex) {
		if (vertices.size() >= graph.length) {
			throw new IllegalArgumentException("Graph is full");
		}

		if (isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		vertices.add(vertex);
	}

	public void removeVertex(int vertex) {
		int sourceIndex = getVertexIndex(vertex);
		if (sourceIndex == -1) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		for (int i = 0; i < vertices.size(); i++) {
			graph[i][sourceIndex] = 0;
			graph[sourceIndex][i] = 0;
		}
	}

	public void addEdge(int source, int destination) {
		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);

		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		} else if (source == destination) {
			throw new IllegalArgumentException("Invalid Edge");
		} else {
			graph[sourceIndex][destinationIndex] = 1;
			graph[destinationIndex][sourceIndex] = 1;
		}
	}

	public void removeEdge(int source, int destination) {
		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);

		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		} else if (source == destination) {
			throw new IllegalArgumentException("Invalid Edge");
		} else {
			graph[sourceIndex][destinationIndex] = 0;
			graph[destinationIndex][sourceIndex] = 0;
		}
	}

	public List<Integer> vertices() {
		return vertices;
	}

	public List<Integer> neighbors(int source) {
		int sourceIndex = getVertexIndex(source);
		if (sourceIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		List<Integer> neighbors = new ArrayList<>();
		for (int i = 0; i < vertices.size(); i++) {
			if (graph[sourceIndex][i] == 1) {
				neighbors.add(vertices.get(i));
			}
		}

		return neighbors;
	}

	public boolean hasVertex(int source) {
		return isVertexExist(source);
	}

	public boolean hasEdge(int source, int destination) {
		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);

		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		return graph[sourceIndex][destinationIndex] == 1;
	}

	public int size() {
		return vertices.size();
	}

	public void printGraph() {
		for (int i = 0; i < graph.length; i++) {
			System.out.print("Vertex " + vertices.get(i) + " is connected to: ");
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] == 1) {
					System.out.print(vertices.get(j) + " ");
				}
			}
			System.out.println();
		}
	}

	private boolean isVertexExist(int vertex) {
		return vertices.contains(vertex);
	}

	private int getVertexIndex(int vertex) {
		return vertices.indexOf(vertex);
	}
}