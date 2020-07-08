package com.nel.chan.dsalgo.graph.basic.generic.undirected;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListVertexGraph {
	private List<Vertex> graph;

	public AdjacencyListVertexGraph(int noOfVertices) {
		this.graph = new ArrayList<>(noOfVertices);
	}

	public void addVertex(int vertex) {
		Vertex node = new Vertex(vertex);
		if (isVertexExist(node)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		node.edges = new ArrayList<>();
		graph.add(node);
	}

	public void removeVertex(Integer vertex) {
		Vertex node = new Vertex(vertex);
		int sourceIndex = getVertexIndex(node);
		if (sourceIndex == -1) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		for (Vertex ver : graph) {
			ver.edges.remove(Integer.valueOf(sourceIndex));
		}
		graph.get(sourceIndex).edges.clear();
	}

	public void addEdge(int source, int destination) {
		Vertex srcVertex = new Vertex(source);
		Vertex desVertex = new Vertex(destination);
		int sourceIndex = getVertexIndex(srcVertex);
		int destinationIndex = getVertexIndex(desVertex);
		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		graph.get(sourceIndex).edges.add(destinationIndex);
		graph.get(destinationIndex).edges.add(sourceIndex);
	}

	public void removeEdge(int source, int destination) {
		Vertex srcVertex = new Vertex(source);
		Vertex desVertex = new Vertex(destination);
		int sourceIndex = getVertexIndex(srcVertex);
		int destinationIndex = getVertexIndex(desVertex);
		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		graph.get(sourceIndex).edges.remove(Integer.valueOf(destinationIndex));
		graph.get(destinationIndex).edges.remove(Integer.valueOf(sourceIndex));
	}

	public List<Integer> vertices() {
		List<Integer> vertices = new ArrayList<>();
		for (Vertex vertex : graph) {
			vertices.add(vertex.node);
		}

		return vertices;
	}

	public List<Integer> neighbors(int vertex) {
		Vertex node = new Vertex(vertex);
		int sourceIndex = getVertexIndex(node);
		if (sourceIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		List<Integer> neighbors = new ArrayList<>();
		for (Integer edge : graph.get(sourceIndex).edges) {
			neighbors.add(vertices().get(edge));
		}

		return neighbors;
	}

	public boolean hasVertex(int vertex) {
		return isVertexExist(new Vertex(vertex));
	}

	public boolean hasEdge(int source, int destination) {
		Vertex srcVertex = new Vertex(source);
		Vertex desVertex = new Vertex(destination);
		int sourceIndex = getVertexIndex(srcVertex);
		int destinationIndex = getVertexIndex(desVertex);
		if (sourceIndex == -1 || destinationIndex == -1) {
			throw new IllegalArgumentException("Invalid Edge");
		}

		return graph.get(sourceIndex).edges.contains(Integer.valueOf(destinationIndex));

	}

	public int size() {
		return graph.size();
	}

	public void printGraph() {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print(graph.get(i).node + " ---> ");
			for (Integer edge : graph.get(i).edges) {
				System.out.print(graph.get(edge).node + " ");
			}
			System.out.println();
		}
	}

	private boolean isVertexExist(Vertex vertex) {
		return graph.contains(vertex);
	}

	private int getVertexIndex(Vertex vertex) {
		return graph.indexOf(vertex);
	}

	private static class Vertex {
		private int node;
		private List<Integer> edges;

		public Vertex(int node) {
			this.node = node;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + node;
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
			if (node != other.node) {
				return false;
			}

			return true;
		}
	}
}