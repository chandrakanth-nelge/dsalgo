package com.nel.chan.dsalgo.graph.impl.undirected;

import java.util.ArrayList;
import java.util.List;

import com.nel.chan.dsalgo.graph.UnDirectedGraph;

public class AdjacencyMatrixGraph<V> extends UnDirectedGraph<V> {
	private List<V> vertices;
	private int[][] graph;

	public AdjacencyMatrixGraph(Integer noOfVertices) {
		this.vertices = new ArrayList<>();
		this.graph = new int[noOfVertices][noOfVertices];
	}

	@Override
	public void addVertex(V vertex) {
		if (isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		vertices.add(vertex);
	}

	@Override
	public void removeVertex(V vertex) {
		if (!isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		int sourceIndex = getVertexIndex(vertex);
		for (int i = 0; i < vertices.size(); i++) {
			graph[sourceIndex][i] = 0;
		}

		for (int i = 0; i < vertices.size(); i++) {
			graph[i][sourceIndex] = 0;
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
		graph[sourceIndex][destinationIndex] = 1;
		graph[destinationIndex][sourceIndex] = 1;
	}
	
	@Override
	public void addEdgeInternal(V source, V destination, int weight) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		graph[sourceIndex][destinationIndex] = weight;
		graph[destinationIndex][sourceIndex] = weight;
	}

	@Override
	public void removeEdge(V source, V destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(source);
		int destinationIndex = getVertexIndex(destination);
		graph[sourceIndex][destinationIndex] = 0;
		graph[destinationIndex][sourceIndex] = 0;
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

		return graph[sourceIndex][destinationIndex] == 1;
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
		int sourceVertexIndex = getVertexIndex(vertex);
		for (int i = 0; i < graph.length; i++) {
			if (graph[sourceVertexIndex][i] == 1) {
				neighbors.add(vertices.get(i));
			}
		}

		return neighbors;
	}

	@Override
	public int size() {
		return vertices.size();
	}

	@Override
	public void printGraph() {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(vertices.get(i) + " -> ");
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] == 1) {
					System.out.print(vertices.get(j) + " , ");
				}
			}
			System.out.println("");
		}
	}

	@Override
	public String toString() {
		return "Chandu";
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