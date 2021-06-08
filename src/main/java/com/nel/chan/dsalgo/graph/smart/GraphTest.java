package com.nel.chan.dsalgo.graph.smart;

import com.nel.chan.dsalgo.graph.smart.undirected.BFSConnectedComponents;
import com.nel.chan.dsalgo.graph.smart.undirected.BFSTraversal;
import com.nel.chan.dsalgo.graph.smart.undirected.DFSConnectedComponents;
import com.nel.chan.dsalgo.graph.smart.undirected.DFSTraversal;
import com.nel.chan.dsalgo.graph.smart.undirected.Tree;
import com.nel.chan.dsalgo.graph.smart.undirected.impl.AdjacencyListGraph;

public class GraphTest {

	public static void main(String[] args) {
		testList();
	}

	private static void testList() {
		AdjacencyListGraph graph = new AdjacencyListGraph(5);

		/*graph.addEdge(1, 0); 
		graph.addEdge(0, 2); 
		graph.addEdge(0, 3); 
		graph.addEdge(3, 4);*/
		
		graph.addEdge(1, 0); 
		graph.addEdge(0, 2); 
		graph.addEdge(2, 1); 
		graph.addEdge(0, 3); 
		graph.addEdge(3, 4);

		System.out.println("========Printing Graph=========");
		graph.printGraph();
		System.out.println("========Printing Graph=========");

		System.out.println("==========BFS Traversal========");
		BFSTraversal bfs = new BFSTraversal(graph);
		bfs.bfs();
		System.out.println("==========BFS Traversal========");

		System.out.println("==========DFS Traversal========");
		DFSTraversal dfs = new DFSTraversal(graph);
		dfs.dfs();
		System.out.println("==========DFS Traversal========");
		
		System.out.println("==========BFS Connected Components========");
		BFSConnectedComponents bfsCon = new BFSConnectedComponents(graph);
		bfsCon.connectedComponents();
		System.out.println("==========BFS Connected Components========");
		
		System.out.println("==========DFS Connected Components========");
		DFSConnectedComponents dfsCon = new DFSConnectedComponents(graph);
		dfsCon.connectedComponents();
		System.out.println("==========DFS Connected Components========");
		
		System.out.println("==========TREE Detection========");
		Tree tree = new Tree(graph);
		if (tree.isTree()) {
            System.out.println("Graph is Tree");
		}
        else {
            System.out.println("Graph is not Tree");
        }
		System.out.println("==========TREE Detection========");
	}
}