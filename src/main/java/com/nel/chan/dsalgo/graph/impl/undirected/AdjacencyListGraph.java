package com.nel.chan.dsalgo.graph.impl.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.nel.chan.dsalgo.graph.UnDirectedGraph;

public class AdjacencyListGraph<V> extends UnDirectedGraph<V> {
	private List<V> vertices;
	private List<LinkedList<V>> graph;

	public AdjacencyListGraph(int noOfVertices) {
		this.vertices = new ArrayList<>();
		this.graph = new ArrayList<>(noOfVertices);
		for (int i = 0; i < noOfVertices; i++) {
			graph.add(new LinkedList<>());
		}
	}

	@Override
	public void addVertex(V vertex) {
		if (isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		vertices.add(vertex);

		graph.add(vertices.size() - 1, new LinkedList<>());
	}

	@Override
	public void removeVertex(V vertex) {
		if (!isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		for (LinkedList<V> edges : graph) {
			edges.remove(vertex);
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
		graph.get(sourceIndex).addFirst(destination);
		graph.get(destinationIndex).addFirst(source);
	}
	
	@Override
	public void addEdgeInternal(V source, V destination, int weight) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		graph.get(sourceIndex).addFirst(destination);
		graph.get(destinationIndex).addFirst(source);
	}

	@Override
	public void removeEdge(V source, V destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		graph.get(sourceIndex).remove(destination);
		graph.get(destinationIndex).remove(source);
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

		int sourceIndex = getVertexIndex(vertex);
		return graph.get(sourceIndex);
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

		return !graph.get(sourceIndex).isEmpty();
	}

	@Override
	public int size() {
		return vertices.size();
	}

	@Override
	public void printGraph() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex " + vertices.get(i) + " is connected to: ");

			for (V v : graph.get(i)) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
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
}