package com.nel.chan.dsalgo.graph;

public class Edge {
	private int vertexNumber;
	private double weight;
	private boolean isVisited;

	public Edge() {
		super();
	}
	
	public Edge(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

	public Edge(int vertexNumber, double weight) {
		this.vertexNumber = vertexNumber;
		this.weight = weight;
	}

	public void setVertexNumber(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}
	public int getVertexNumber() {
		return vertexNumber;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public boolean isVisited() {
		return isVisited;
	}

	@Override
	public String toString() {
		return "Edge [vertexNumber=" + vertexNumber + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vertexNumber;
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
		Edge other = (Edge) obj;
		if (vertexNumber != other.vertexNumber)
			return false;
		return true;
	}
}