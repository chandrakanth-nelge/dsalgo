package com.nel.chan.dsalgo.graph.impl.undirected;

import java.util.ArrayList;
import java.util.List;

import com.nel.chan.dsalgo.graph.Edge;
import com.nel.chan.dsalgo.graph.UnDirectedGraph;
import com.nel.chan.dsalgo.graph.Vertex;

public class AdjacencyListVertexGraph<V> extends UnDirectedGraph<V> {
	private List<Vertex<V>> graph;

	public AdjacencyListVertexGraph(Integer noOfVertices) {
		this.graph = new ArrayList<>(noOfVertices);
	}

	@Override
	public void addVertex(V vertex) {
		Vertex<V> node = new Vertex<>(vertex, new ArrayList<>());
		if (isVertexExist(node)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		graph.add(node);
	}

	@Override
	public void removeVertex(V vertex) {
		Vertex<V> node = new Vertex<>(vertex);
		if (isVertexExist(node)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		int sourceIndex = getVertexIndex(node);
		Edge edge = new Edge(sourceIndex);
		for (Vertex<V> vertx : graph) {
			vertx.getEdges().remove(edge);
		}

		graph.remove(node);
	}

	@Override
	public void addEdgeInternal(V source, V destination) {
		Vertex<V> srcVertex = new Vertex<>(source);
		Vertex<V> desVertex = new Vertex<>(destination);
		if (!isValidEdges(srcVertex, desVertex)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(srcVertex);
		int destinationIndex = getVertexIndex(desVertex);

		graph.get(sourceIndex).getEdges().add(new Edge(destinationIndex));
		graph.get(destinationIndex).getEdges().add(new Edge(sourceIndex));
	}

	@Override
	public void addEdgeInternal(V source, V destination, int weight) {
		Vertex<V> srcVertex = new Vertex<>(source);
		Vertex<V> desVertex = new Vertex<>(destination);
		if (!isValidEdges(srcVertex, desVertex)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(srcVertex);
		int destinationIndex = getVertexIndex(desVertex);

		graph.get(sourceIndex).getEdges().add(new Edge(destinationIndex, weight));
		graph.get(destinationIndex).getEdges().add(new Edge(sourceIndex, weight));
	}

	@Override
	public void removeEdge(V source, V destination) {
		Vertex<V> srcVertex = new Vertex<>(source);
		Vertex<V> desVertex = new Vertex<>(destination);
		if (!isValidEdges(srcVertex, desVertex)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(srcVertex);
		int destinationIndex = getVertexIndex(desVertex);
		graph.get(sourceIndex).getEdges().remove(new Edge(destinationIndex));
		graph.get(destinationIndex).getEdges().remove(new Edge(sourceIndex));
	}

	@Override
	public List<V> vertices() {
		List<V> neighbors = new ArrayList<>();
		for (Vertex<V> vertex : graph) {
			neighbors.add(vertex.getNode());
		}

		return neighbors;
	}

	@Override
	public List<V> neighbors(V vertex) {
		Vertex<V> node = new Vertex<>(vertex);
		if (!isVertexExist(node)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		int srcIndex = getVertexIndex(node);
		List<V> neighbors = new ArrayList<>();
		List<Edge> edges = graph.get(srcIndex).getEdges();
		for (Edge edge : edges) {
			neighbors.add(graph.get(edge.getVertexNumber()).getNode());
		}

		return neighbors;
	}

	@Override
	public boolean hasVertex(V vertex) {
		return isVertexExist(new Vertex<>(vertex));
	}

	@Override
	public boolean hasEdge(V source, V destination) {
		Vertex<V> srcVertex = new Vertex<>(source);
		Vertex<V> desVertex = new Vertex<>(destination);
		if (!isValidEdges(srcVertex, desVertex)) {
			throw new IllegalArgumentException();
		}

		int sourceIndex = getVertexIndex(srcVertex);
		int destinationIndex = getVertexIndex(desVertex);
		List<Edge> list = graph.get(sourceIndex).getEdges();
		return list.contains(new Edge(destinationIndex));
	}

	@Override
	public int size() {
		return graph.size();
	}

	@Override
	public void printGraph() {
		for (Vertex<V> vertex : graph) {
			System.out.print(vertex.getNode());
			for (Edge edge : vertex.getEdges()) {
				System.out.print(" -> " + graph.get(edge.getVertexNumber()).getNode());
			}
			System.out.println();
		}
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

	private boolean isVertexExist(Vertex<V> vertex) {
		return graph.contains(vertex);
	}

	private int getVertexIndex(Vertex<V> vertex) {
		return graph.indexOf(vertex);
	}
}