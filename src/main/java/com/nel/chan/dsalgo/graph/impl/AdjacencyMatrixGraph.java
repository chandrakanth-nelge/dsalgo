package com.nel.chan.dsalgo.graph.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrixGraph {
	private int[][] graph;

	public AdjacencyMatrixGraph(Integer noOfVertices) {
		this.graph = new int[noOfVertices][noOfVertices];
	}
	
	public void addVertex(int vertex) {
		System.out.println("NA = " + vertex);
	}

	public void removeVertex(int vertex) {
		System.out.println("NA = " + vertex);
	}

	public void addEdge(Integer source, Integer destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		graph[source][destination] = 1;
		graph[destination][source] = 1;
	}

	public void removeEdge(Integer source, Integer destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		graph[source][destination] = 0;
		graph[destination][source] = 0;
	}
	
	public List<Integer> vertices() {
		List<Integer> vertexes = new ArrayList<>();
		for (int i = 0; i < size(); i++) {
			vertexes.add(i);
		}

		return vertexes;
	}

	public List<Integer> neighbors(Integer source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		List<Integer> neighbors = new ArrayList<>();
		for (int dest = 0; dest < size(); dest++) {
			if (graph[source][dest] == 1) {
				neighbors.add(dest);
			}
		}

		return neighbors;
	}

	public boolean hasVertex(Integer vertex) {
		return isVertexExist(vertex);
	}

	public boolean hasEdge(Integer source, Integer destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException();
		}

		return graph[source][destination] == 1;
	}

	public int size() {
		return graph.length;
	}

	public void printGraph() {
		for (int source = 0; source < size(); source++) {
			System.out.print("[" + source + "]" + " -> ");
			List<Integer> edges = new ArrayList<>();
			for (int dest = 0; dest < size(); dest++) {
				if (graph[source][dest] == 1) {
					edges.add(dest);
				}
			}
			System.out.print(edges);
			System.out.println("");
		}
	}

	private boolean isValidEdges(int source, int destination) {
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

	private boolean isVertexExist(int vertex) {
		return vertex < size();
	}
	
	public void bfs(int source) {
		boolean[] visited = new boolean[size()];
		visited[source] = true;

		Queue<Integer> q = new LinkedList<>();
		q.offer(source);

		while (!q.isEmpty()) {
			int src = q.poll();
			System.out.print(src + " ");
			for (int dest = 0; dest < size(); dest++) {
				if (graph[src][dest] == 1 && !visited[dest]) {
					q.offer(dest);
					visited[dest] = true;
				}
			}
		}
		
		System.out.println();
	}
	
	public void dfs(int source) {
		boolean[] visited = new boolean[size()];
		visited[source] = true;

		Stack<Integer> stack = new Stack<>();
		stack.push(source);

		while (!stack.isEmpty()) {
			int src = stack.pop();
			System.out.print(src + " ");
			for (int dest = 0; dest < size(); dest++) {
				if (graph[src][dest] == 1) {
					if (!visited[dest]) {
						stack.push(dest);
						visited[dest] = true;
					}
				}
			}
		}
		
		System.out.println();
	}
	
	public void dfsUtil(int source, boolean[] visited) {
		Stack<Integer> stack = new Stack<>();
		stack.push(source);

		while (!stack.isEmpty()) {
			int src = stack.pop();
			if (!visited[src]) {
				visited[src] = true;
				System.out.print(src + " ");

				for (int dest = 0; dest < size(); dest++) {
					if (graph[src][dest] == 1) {
						if (!visited[dest]) {
							stack.push(dest);
						}
					}
				}
			}
		}

		System.out.println();
	}
	
	public void connectedComponents() {
        boolean[] visited = new boolean[size()];
        int noOfComponents = 0;
        for (int source = 0; source < size(); source++) {
            if (!visited[source]) {
            	dfsUtil(source, visited);
            	++noOfComponents;
            }
        }
        
        System.out.println("Connected Components = " + noOfComponents);
    }
	
	public void motherVertex(int source) {
        boolean[] visited = new boolean[size()];
        dfsUtil(source, visited);
        
        boolean isMotherVertex = true;
        for (int i = 0; i < size(); i++) {
            if (!visited[i]) {
            	isMotherVertex = false;
            	break;
            }
        }
        
        if(isMotherVertex) {
        	System.out.println("Is a Mother vertex");
        } else {
        	System.out.println("Not a Mother vertex");
        }
    }

	public boolean isCyclic() {
		boolean[] visited = new boolean[size()];
		for (int u = 0; u < size(); u++) {
			if (!visited[u]) {
				if (dfsCyclic(u, visited, -1)) {
					return true;
				}
			}
		}

		return false;
	}
	
	private boolean dfsCyclic(int vertex, boolean[] visited, int parent) {
		visited[vertex] = true;
		for (int i : neighbors(vertex)) {
			if (!visited[i]) {
				if (dfsCyclic(i, visited, vertex))
					return true;
			} else if (i != parent) {
				return true;
			}
		}
		
		return false;
	}
}