package com.nel.chan.dsalgo.graph.impl.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMapGraph {
	private Map<Integer, List<Integer>> graph;

	public AdjacencyMapGraph() {
		graph = new HashMap<>();
	}

	public void addVertex(int vertex) {
		if (isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex already exist");
		}

		graph.put(vertex, new ArrayList<>());
	}

	public void removeVertex(Integer vertex) {
		if (!isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		for (Map.Entry<Integer, List<Integer>> edges : graph.entrySet()) {
			edges.getValue().remove(vertex);
		}
		graph.remove(vertex);
	}

	void addEdge(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}

	void removeEdge(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		graph.get(source).remove(Integer.valueOf(destination));
		graph.get(destination).remove(Integer.valueOf(source));
	}

	public List<Integer> vertices() {
		List<Integer> vertices = new ArrayList<>();
		for (Integer vertex : graph.keySet()) {
			vertices.add(vertex);
		}

		return vertices;
	}

	public List<Integer> neighbours(int vertex) {
		if (!isVertexExist(vertex)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		return graph.get(vertex);
	}

	public boolean hasVertex(int vertex) {
		return isVertexExist(vertex);
	}

	public boolean hasEdge(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		return graph.get(source).contains(Integer.valueOf(destination));
	}
	
	public int size() {
		return graph.size();
	}

	void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			System.out.print(entry.getKey() + " ---> ");
			for (Integer edge : entry.getValue()) {
				System.out.print(edge + " ");
			}
			System.out.println();
		}
	}

	public void bfs(int source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}
		
		boolean[] visited = new boolean[size()];
		visited[source] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(source);
		while (!q.isEmpty()) {
			int src = q.poll();
			System.out.print(src + " ");

			for (int dest : graph.get(src)) {
				if (!visited[dest]) {
					visited[dest] = true;
					q.offer(dest);
				}
			}
		}
		System.out.println();
	}
	
	public void dfs(int source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}
		
		boolean[] visited = new boolean[size()];
		visited[source] = true;
        
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            int src = stack.pop();
			System.out.print(src + " ");

			for (int dest : graph.get(src)) {
				if (!visited[dest]) {
					stack.push(dest);
					visited[dest] = true;
				}
			}
        }
        System.out.println();
    }
	
	public int findMother() {
        if (graph.isEmpty()) {
            return -1;
        }
        
        boolean[] visited = new boolean[size()];
        int motherVertex = 0;
        for (int source : graph.keySet()) {
            if (!visited[source]) {
            	dfsUtil(source, visited);
                motherVertex = source;
            }
        }
        
        for(int v : graph.keySet()) {
        	if(!visited[v]) {
        		return -1;
        	}
        }
        
        return motherVertex;
    }
	
	public void isMotherVertex(int source) {
		if (!isVertexExist(source)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}
		
        boolean[] visited = new boolean[size()];
        dfsUtil(source, visited);
        
        boolean isMotherVertex = true;
        for(int v : graph.keySet()) {
        	if(!visited[v]) {
        		isMotherVertex = false;
            	break;
        	}
        }
        
        if(isMotherVertex) {
        	System.out.println(source + " Is a Mother vertex");
        } else {
        	System.out.println(source + " Not a Mother vertex");
        }
    }
	
	public void dfsUtil(int source, boolean[] visited) {
		visited[source] = true;
        
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            int src = stack.pop();
			//System.out.print(src + " ");
			for (int dest : graph.get(src)) {
				if (!visited[dest]) {
					stack.push(dest);
					visited[dest] = true;
				}
			}
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
		return graph.containsKey(vertex);
	}
	
	
	public static void main(String[] args) {
		AdjacencyMapGraph graph = new AdjacencyMapGraph();
		
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		
		System.out.println("=================");
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);

		graph.printGraph();
		System.out.println("=================");

		System.out.println(graph.vertices());
		System.out.println("=================");

		System.out.println(graph.neighbours(2));
		System.out.println("=================");

		graph.bfs(0);
		System.out.println("=================");
		
		graph.dfs(0);
		System.out.println("=================");
		
		graph.isMotherVertex(3);
		System.out.println("=================");
	
		System.out.println("Mother vertex = " + graph.findMother());
		System.out.println("=================");
	}
}