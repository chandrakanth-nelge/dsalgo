package com.nel.chan.dsalgo.graph.impl.basic;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph {
	private int vertices;
	private int[][] graph;

	public AdjacencyMatrixGraph(int vertex) {
		this.vertices = vertex;
		this.graph = new int[vertex][vertex];
	}

	public void addVertex(int vertex) {
		System.out.println("NA = " + vertex);
	}

	public void removeVertex(int vertex) {
		System.out.println("NA = " + vertex);
	}

	public void addEdge(int source, int destination) {
		if ((source >= vertices) || (destination >= vertices)) {
			throw new IllegalArgumentException("Vertex does not exists!");
		} else if (source == destination) {
			throw new IllegalArgumentException("same vertex");
		} else {
			graph[destination][source] = 1;
			graph[source][destination] = 1;
		}
	}

	public void removeEdge(int source, int destination) {
		if ((source >= vertices) || (destination >= vertices)) {
			throw new IllegalArgumentException("Graph does not have the edge");
		} else if (source == destination) {
			throw new IllegalArgumentException("same vertex");
		} else {
			graph[source][destination] = 0;
			graph[destination][source] = 0;
		}
	}

	public List<Integer> vertices() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			list.add(i);
		}

		return list;
	}

	public List<Integer> neighbors(int source) {
		if (source >= vertices) {
			throw new IllegalArgumentException("Vertex does not exists!");
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= vertices; i++) {
			if (graph[source][i] == 1) {
				list.add(i);
			}
		}

		return list;
	}

	public boolean hasVertex(int source) {
		return source <= vertices;
	}

	public boolean hasEdge(int source, int destination) {
		return graph[source][destination] == 1;
	}

	public int size() {
		return vertices;
	}

	public int inDegree(int vertex) {
		if (vertex >= vertices) {
			throw new IllegalArgumentException();
		}

		int count = 0;
		for (int i = 0; i < vertices; i++) {
			if (graph[i][vertex] != 0) {
				count++;
			}
		}

		return count;
	}

	public int outDegree(int vertex) {
		if (vertex >= vertices) {
			throw new IllegalArgumentException();
		}

		int count = 0;
		for (int i = 0; i < vertices; i++) {
			if (graph[vertex][i] != 0) {
				count++;
			}
		}

		return count;
	}

	public void printGraph() {
		System.out.println("Graph: (Adjacency Matrix)");
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < vertices; i++) {
			System.out.print("Vertex " + i + " is connected to:");
			for (int j = 0; j < vertices; j++) {
				if (graph[i][j] == 1) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printGraph();
	}
}