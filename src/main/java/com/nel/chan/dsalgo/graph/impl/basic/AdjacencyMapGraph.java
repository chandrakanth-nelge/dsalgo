package com.nel.chan.dsalgo.graph.impl.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdjacencyMapGraph {
	private Map<Integer, List<Integer>> graph;

	public AdjacencyMapGraph() {
		graph = new HashMap<>();
	}

	void addEdge(int source, int destination) {
		if (graph.containsKey(source)) {
			List<Integer> list = graph.get(source);
			list.add(destination);
		} else {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(destination);
			graph.put(source, list);
		}
	}

	void removeEdge(int source, int destination) {
		if (!graph.containsKey(source)) {
			System.out.println("Error..Enter a valid vertex");
		}

		Iterator<Integer> it = graph.get(source).iterator();
		while (it.hasNext()) {
			int ele = it.next();
			if (ele == destination) {
				it.remove();
			}
		}
	}

	boolean isNeighbour(int source, int destination) {
		if (!graph.containsKey(source)) {
			return false;
		}

		for (Integer neighbour : graph.get(source)) {
			if (neighbour == destination) {
				return true;
			}
		}

		return false;
	}

	void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			System.out.println("Key - " + entry.getKey() + " ---> " + entry.getValue());
		}
	}

	void dfs(int source) {
		boolean[] visited = new boolean[graph.size()];
		dfsUtil(source, visited);
	}

	void dfsUtil(int source, boolean[] visited) {
		visited[source] = true;
		System.out.print(source + " ");

		for (Integer neighbour : graph.get(source)) {
			if (!visited[neighbour]) {
				dfsUtil(neighbour, visited);
			}
		}
	}

	public static void main(String[] args) {
		AdjacencyMapGraph g = new AdjacencyMapGraph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.printGraph();

		String msg = (g.isNeighbour(0, 2)) ? "0--->2 there is edge" : "0--->2 there is no edge";
		System.out.println(msg);
		msg = (g.isNeighbour(0, 3)) ? "0--->3 there is edge" : "0--->3 there is no edge";
		System.out.println(msg);

		g.dfs(1);
	}
}