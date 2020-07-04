package com.nel.chan.dsalgo.graph.impl.undirected;

import java.util.ArrayList;
import java.util.List;

import com.nel.chan.dsalgo.graph.Edge;
import com.nel.chan.dsalgo.graph.UnDirectedGraph;

public class AdjacencyListEdgeGraph<V> extends UnDirectedGraph<V> {
	private List<V> vertices;
	private List<List<Edge>> graph;

	public AdjacencyListEdgeGraph(Integer noOfVertices) {
		this.vertices = new ArrayList<>(noOfVertices);
		this.graph = new ArrayList<>(noOfVertices);
	}

	@Override
	public void addVertex(V vertex) {
		if (isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		vertices.add(vertex);
		graph.add(vertices.size() - 1, new ArrayList<Edge>());
	}

	@Override
	public void removeVertex(V vertex) {
		if (!isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		int sourceIndex = getVertexIndex(vertex);
		for (List<Edge> edges : graph) {
			edges.remove(new Edge(sourceIndex));
		}

		vertices.remove(vertex);
	}

	@Override
	public void addEdgeInternal(V source, V destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);

		graph.get(sourceIndex).add(new Edge(destinationIndex));
		graph.get(destinationIndex).add(new Edge(sourceIndex));
	}

	@Override
	public void addEdgeInternal(V source, V destination, int weight) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		graph.get(sourceIndex).add(new Edge(destinationIndex, weight));
		graph.get(destinationIndex).add(new Edge(sourceIndex, weight));
	}

	@Override
	public void removeEdge(V source, V destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		graph.get(sourceIndex).remove(new Edge(destinationIndex));
		graph.get(destinationIndex).remove(new Edge(sourceIndex));
	}

	@Override
	public List<V> vertices() {
		return vertices;
	}

	@Override
	public List<V> neighbors(V vertex) {
		if (!isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		List<V> neighbors = new ArrayList<>();
		int sourceIndex = getVertexIndex(vertex);
		List<Edge> edges = graph.get(sourceIndex);
		for (Edge edge : edges) {
			neighbors.add(vertices.get(edge.getVertexNumber()));
		}

		return neighbors;
	}

	@Override
	public boolean hasVertex(V vertex) {
		return isVertexExist(vertex);
	}

	@Override
	public boolean hasEdge(V source, V destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		List<Edge> edges = graph.get(sourceIndex);

		return edges.contains(new Edge(destinationIndex));
	}
	
	@Override
	public int size() {
		return vertices.size();
	}
	
	@Override
	public void printGraph() {
		// TIMEPASS
	}

	private boolean isValidEdges(V source, V destination) {
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

	private boolean isVertexExist(V vertex) {
		return vertices.contains(vertex);
	}

	private int getVertexIndex(V vertex) {
		return vertices.indexOf(vertex);
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		System.out.println(list);
	}
}