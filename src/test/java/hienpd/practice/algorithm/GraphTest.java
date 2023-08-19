package hienpd.practice.algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GraphTest {
	@Test
	public void test_Case() {
		var graph = new Graph<String>();
		graph.addEdge("1", "2");
		graph.addEdge("4", "5");
		graph.addEdge("1", "3");
		graph.addEdge("3", "4");
		graph.addEdge("3", "6");

		assertEquals("GIVEN a directed graph, WHEN no path is found between 2 nodes by using DFS, THEN return false",
				false,
				graph.dfs("2", "6"));
		assertEquals("GIVEN a directed graph, WHEN a path is found between 2 nodes by using DFS, THEN return true.",
				true,
				graph.dfs("1", "6"));

		assertEquals("GIVEN a directed graph, WHEN no path is found between 2 nodes by using BFS, THEN return false",
				false,
				graph.bfs("2", "6"));
		assertEquals("GIVEN a directed graph, WHEN a path is found between 2 nodes by using BFS, THEN return true.",
				true,
				graph.bfs("1", "6"));
	}
}
