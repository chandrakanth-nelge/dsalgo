package com.nel.chan.dsalgo.graph.impl.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListGraph {
	private int vertex;
	private List<LinkedList<Integer>> graph;

	public AdjacencyListGraph(int vertex) {
		this.vertex = vertex;
		this.graph = new ArrayList<>(this.vertex);
		for (int i = 0; i < this.vertex; i++) {
			graph.add(new LinkedList<>());
		}
	}

	public void addEdge(int source, int destination) {
		graph.get(source).addFirst(destination);
		graph.get(destination).addFirst(source);
	}

	public void printGraph() {
		int i = 0;
		for (LinkedList<Integer> edge : graph) {
			System.out.print("Vertex " + i + " is connected to: ");
			for (Integer j : edge) {
				System.out.print(j + " ");
			}

			++i;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AdjacencyListGraph graph = new AdjacencyListGraph(5);
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