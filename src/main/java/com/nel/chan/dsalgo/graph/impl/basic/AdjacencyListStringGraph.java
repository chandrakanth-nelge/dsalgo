package com.nel.chan.dsalgo.graph.impl.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListStringGraph {
	private Map<Vertex, List<Vertex>> graph;

	public AdjacencyListStringGraph() {
		this.graph = new HashMap<>();
	}

	void addVertex(String vertex) {
		graph.putIfAbsent(new Vertex(vertex), new ArrayList<>());
	}

	void removeVertex(String vertex) {
		Vertex v = new Vertex(vertex);
		graph.values().stream().forEach(e -> e.remove(v));
		graph.remove(new Vertex(vertex));
	}

	void addEdge(String source, String destination) {
		Vertex vertex1 = new Vertex(source);
		Vertex vertex2 = new Vertex(destination);
		graph.get(vertex1).add(vertex2);
		graph.get(vertex2).add(vertex1);
	}

	void removeEdge(String source, String destination) {
		Vertex vertex1 = new Vertex(source);
		Vertex vertex2 = new Vertex(destination);
		List<Vertex> eV1 = graph.get(vertex1);
		List<Vertex> eV2 = graph.get(vertex2);
		if (eV1 != null)
			eV1.remove(vertex2);
		if (eV2 != null)
			eV2.remove(vertex1);
	}

	private static AdjacencyListStringGraph createGraph() {
		AdjacencyListStringGraph graph = new AdjacencyListStringGraph();
		graph.addVertex("Bob");
		graph.addVertex("Alice");
		graph.addVertex("Mark");
		graph.addVertex("Rob");
		graph.addVertex("Maria");
		graph.printVertex();
		graph.addEdge("Bob", "Alice");
		graph.addEdge("Bob", "Rob");
		graph.addEdge("Alice", "Mark");
		graph.addEdge("Rob", "Mark");
		graph.addEdge("Alice", "Maria");
		graph.addEdge("Rob", "Maria");
		return graph;
	}

	void printVertex() {
		for (Map.Entry<Vertex, List<Vertex>> entry : graph.entrySet()) {
			System.out.println(entry.getKey().vertex);
		}

	}

	List<Vertex> getAdjVertices(String label) {
		return graph.get(new Vertex(label));
	}

	public static void main(String[] args) {
		AdjacencyListStringGraph graph = createGraph();
		for (Map.Entry<Vertex, List<Vertex>> entry : graph.graph.entrySet()) {
			System.out.println("Vertex :: " + entry.getKey().vertex);
			entry.getValue().forEach(v -> System.out.print("-->" + v.vertex));
			System.out.println();
		}
	}

	private static class Vertex {
		private String vertex;

		public Vertex(String vertex) {
			this.vertex = vertex;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((vertex == null) ? 0 : vertex.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			Vertex other = (Vertex) obj;
			if (vertex == null) {
				if (other.vertex != null)
					return false;
			} else if (!vertex.equals(other.vertex)) {
				return false;
			}

			return true;
		}

		@Override
		public String toString() {
			return vertex;
		}
	}
}