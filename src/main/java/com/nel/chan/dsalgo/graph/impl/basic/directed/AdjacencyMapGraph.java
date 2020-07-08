package com.nel.chan.dsalgo.graph.impl.basic.directed;

import java.util.ArrayList;
import java.util.Arrays;
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

	public void addEdge(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		graph.get(source).add(destination);
		//graph.get(destination).add(source);
	}

	public void removeEdge(int source, int destination) {
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

		return neighbours(source).contains(Integer.valueOf(destination));
	}
	
	public int size() {
		return graph.size();
	}

	public void printGraph() {
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

			for (int dest : neighbours(src)) {
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

			for (int dest : neighbours(src)) {
				if (!visited[dest]) {
					stack.push(dest);
					visited[dest] = true;
				}
			}
        }
        System.out.println();
    }
	
	public int findDegree(int source) {
		if (!isVertexExist(source)) {
			return -1;
		}
		
		return neighbours(source).size();
	}
	
	public boolean isPathExists(int source, int destination) {
		if (!isValidEdges(source, destination)) {
			throw new IllegalArgumentException("Vertex doesn't exist");
		}

		if (source == destination) {
			return true;
		}
		
		boolean isPathExists = false;
		
		boolean[] visited = new boolean[size()];
		visited[source] = true;
		Stack<Integer> stack = new Stack<>();
		stack.add(source);
		while (!stack.isEmpty()) {
			int src = stack.pop();
			for (int dest : neighbours(src)) {
				if (!visited[dest]) {
					if (dest == destination) {
						isPathExists = true;
						break;
					}
					stack.add(dest);
					visited[dest] = true;
				}
			}
		}

		return isPathExists;
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
	
	public int findMother() {
        if (size() == 0) {
            return -1;
        }
        
        boolean[] visited = new boolean[size()];
        int motherVertex = 0;
        for (int source : vertices()) {
            if (!visited[source]) {
            	dfsUtil(source, visited);
                motherVertex = source;
            }
        }
        
        visited = new boolean[size()];
        dfsUtil(motherVertex, visited);
        
        for(int vertex : vertices()) {
        	if(!visited[vertex]) {
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
        for(int vertex : vertices()) {
        	if(!visited[vertex]) {
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
			for (int dest : neighbours(src)) {
				if (!visited[dest]) {
					stack.push(dest);
					visited[dest] = true;
				}
			}
        }
    }
	
	//https://www.geeksforgeeks.org/transitive-closure-of-a-graph/
    public int[][] transitiveClosure() {
        int[][] transitiveClosureMatrix = new int[size()][size()];
        for (int source : vertices()) {
            dfsUtil(source, source, transitiveClosureMatrix);
        }
        return transitiveClosureMatrix;
    }
    
	private void dfsUtil(int source, int dest, int[][] transitiveClosureMatrix) {
        transitiveClosureMatrix[source][dest] = 1;
        for (int vertex : neighbours(dest)) {
            if (transitiveClosureMatrix[source][vertex] == 0) {
                dfsUtil(source, vertex, transitiveClosureMatrix);
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
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 0);
		graph.addEdge(2, 1);
		graph.addEdge(3, 4);
		
		/*graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 0);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(3, 6);
		graph.addEdge(4, 6);
		graph.addEdge(5, 2);
		graph.addEdge(6, 2);
		graph.addEdge(6, 5);*/

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
		
		graph.isMotherVertex(0);
		System.out.println("=================");
	
		System.out.println("Mother vertex = " + graph.findMother());
		System.out.println("=================");
		
		System.out.println("Degree of 3 = " + graph.findDegree(3));
		System.out.println("=================");
		
		int[][] transitiveClosureMatrix = graph.transitiveClosure();
		for (int[] arr : transitiveClosureMatrix) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("=================");
	}
}