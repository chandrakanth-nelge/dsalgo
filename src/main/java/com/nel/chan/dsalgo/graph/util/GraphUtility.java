package com.nel.chan.dsalgo.graph.util;

import com.nel.chan.dsalgo.graph.Graph;
import com.nel.chan.dsalgo.graph.factory.GraphFactory;
import com.nel.chan.dsalgo.graph.model.User;

public class GraphUtility {
	private static final String BITTU = "Bittu";
	private static final String CHANDU = "Chandu";
	private static final String DEEPAK = "Deepak";
	private static final String KHAJU = "Khaju";
	private static final String LAKHAN = "Lakhan";
	private static final String RAJU = "Raju";

	public static void main(String[] args) throws Exception {
		Graph<String> graph = GraphFactory.getInstance("LIST", 7);
		testMatrix(graph);
	}

	public static void testMatrix(Graph<String> graph) {
		System.out.println("==================vertices==================");
		graph.addVertex(CHANDU);
		graph.addVertex(KHAJU);
		graph.addVertex(LAKHAN);
		graph.addVertex(BITTU);
		graph.addVertex(DEEPAK);
		graph.addVertex(RAJU);
		System.out.println(graph.vertices());
		System.out.println("==================vertices==================");

		System.out.println();
		System.out.println("==================Connections===============");
		graph.addEdge(CHANDU, LAKHAN);
		graph.addEdge(CHANDU, KHAJU);
		graph.addEdge(KHAJU, RAJU);
		graph.addEdge(LAKHAN, BITTU);
		graph.addEdge(BITTU, DEEPAK);

		graph.printGraph();
		System.out.println("==================Connections===============");

		System.out.println();
	}

	public static void testList(Graph<User> graph) {
		User user1 = new User(CHANDU, "chandrakanth@techmojo.in", "123");
		User user2 = new User(LAKHAN, "lakhan@techmojo.in", "456");
		User user3 = new User(KHAJU, "khaju@techmojo.in", "789");
		User user4 = new User(BITTU, "bittu@techmojo.in", "135");
		User user5 = new User(RAJU, "raju@techmojo.in", "479");
		User user6 = new User(DEEPAK, "deepak@techmojo.in", "767");
		User user7 = new User("Vinayak", "vinayak@techmojo.in", "989");

		graph.addVertex(user1);
		graph.addVertex(user2);
		graph.addVertex(user3);
		graph.addVertex(user4);
		graph.addVertex(user5);
		graph.addVertex(user6);
		graph.addVertex(user7);
		System.out.println(graph.vertices());
		System.out.println();

		graph.addEdge(user1, user2);
		graph.addEdge(user1, user5);
		graph.addEdge(user1, user3);
		graph.addEdge(user3, user2);
		graph.addEdge(user3, user5);
		graph.addEdge(user2, user4);
		graph.addEdge(user2, user7);
		graph.addEdge(user4, user6);
		graph.addEdge(user7, user4);
		graph.addEdge(user6, user1);

		graph.printGraph();
		System.out.println();

		final String HAS_VERTEX = "hasVertex ==>";
		System.out.println(HAS_VERTEX + " Chandu = " + graph.hasVertex(user1));
		System.out.println(HAS_VERTEX + " 400 = " + graph.hasVertex(new User("hfdshfj", "dfgdhs", null)));
		System.out.println();

		final String HAS_EDGE = "hasEdge ==>";
		System.out.println(HAS_EDGE + "Chandu, Lakhan ==>" + graph.hasEdge(user1, user2));
		System.out.println(HAS_EDGE + "Chandu, Deepak ==>" + graph.hasEdge(user1, user6));
		System.out.println(HAS_EDGE + "Deepak, Chandu ==>" + graph.hasEdge(user6, user1));
		System.out.println();

		final String NEIGHBORS = "hasEdge ==>";
		System.out.println(NEIGHBORS + "Chandu ==> " + graph.neighbors(user1));
		System.out.println(NEIGHBORS + "Lakhan ==> " + graph.neighbors(user2));
		System.out.println(NEIGHBORS + "Raju ==> " + graph.neighbors(user5));
	}
}