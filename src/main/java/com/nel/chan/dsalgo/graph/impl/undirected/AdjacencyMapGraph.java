package com.nel.chan.dsalgo.graph.impl.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nel.chan.dsalgo.graph.UnDirectedGraph;

public class AdjacencyMapGraph<V> extends UnDirectedGraph<V> {
	private final Map<Vertex<V>, List<Vertex<V>>> graph;

	public AdjacencyMapGraph() {
		graph = new HashMap<>();
	}

	@Override
	public void addVertex(V vertex) {
		Vertex<V> vertx = new Vertex<>(vertex);
		if (isVertexExist(vertx)) {
			throw new IllegalArgumentException("Vertex already exists.");
		}

		graph.put(vertx, new ArrayList<>());
	}

	@Override
	public void removeVertex(V vertex) {
		Vertex<V> vertx = new Vertex<>(vertex);
		if (isVertexExist(vertx)) {
			throw new IllegalArgumentException("Vertex doesn't exist.");
		}

		graph.remove(vertx);

		for (Vertex<V> node : graph.keySet()) {
			this.graph.get(node).remove(vertx);
		}
	}

	@Override
	public void addEdgeInternal(V source, V destination) {
		Vertex<V> vertex1 = new Vertex<>(source);
		Vertex<V> vertex2 = new Vertex<>(destination);
		if (!isValidEdges(vertex1, vertex2)) {
			throw new IllegalArgumentException();
		}

		graph.get(vertex1).add(vertex2);
		graph.get(vertex2).add(vertex1);
	}
	
	@Override
	public void addEdgeInternal(V source, V destination, int weight) {
		Vertex<V> vertex1 = new Vertex<>(source);
		Vertex<V> vertex2 = new Vertex<>(destination);
		if (!isValidEdges(vertex1, vertex2)) {
			throw new IllegalArgumentException();
		}

		graph.get(vertex1).add(vertex2);
		graph.get(vertex2).add(vertex1);
	}

	@Override
	public void removeEdge(V source, V destination) {
		Vertex<V> vertex1 = new Vertex<>(source);
		Vertex<V> vertex2 = new Vertex<>(destination);
		if (!isValidEdges(vertex1, vertex2)) {
			throw new IllegalArgumentException();
		}

		List<Vertex<V>> edge1 = graph.get(vertex1);
		if (edge1 != null) {
			edge1.remove(vertex2);
		}

		List<Vertex<V>> edge2 = graph.get(vertex2);
		if (edge2 != null) {
			edge2.remove(vertex2);
		}
	}

	@Override
	public boolean hasVertex(V vertex) {
		return isVertexExist(new Vertex<>(vertex));
	}

	@Override
	public boolean hasEdge(V source, V destination) {
		Vertex<V> vertex1 = new Vertex<>(source);
		Vertex<V> vertex2 = new Vertex<>(destination);

		return graph.get(vertex1).contains(vertex2);
	}

	@Override
	public List<V> vertices() {
		List<V> vertices = new ArrayList<>();
		for (Vertex<V> node : graph.keySet()) {
			vertices.add(node.getVertex());
		}
		return vertices;
	}

	@Override
	public List<V> neighbors(V vertex) {
		Vertex<V> vertx = new Vertex<>(vertex);
		List<V> vertices = new ArrayList<>();
		for (Vertex<V> node : graph.get(vertx)) {
			vertices.add(node.getVertex());
		}

		return vertices;
	}

	@Override
	public int size() {
		return graph.size();
	}

	@Override
	public void printGraph() {
		System.out.println("printGraph()");
	}

	private boolean isValidEdges(Vertex<V> source, Vertex<V> destination) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (Vertex<V> vertex : graph.keySet()) {
			builder.append(vertex.toString() + ": ");
			for (Vertex<V> node : graph.get(vertex)) {
				builder.append(node.toString() + " ");
			}
			builder.append("\n");
		}

		return builder.toString();
	}

	private boolean isVertexExist(Vertex<V> vertex) {
		return graph.containsKey(vertex);
	}

	private static class Vertex<V> {
		private V vertex;

		public Vertex(V vertex) {
			this.vertex = vertex;
		}

		public V getVertex() {
			return vertex;
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

			@SuppressWarnings("unchecked")
			Vertex<V> other = (Vertex<V>) obj;
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
			return vertex.toString();
		}
	}
}