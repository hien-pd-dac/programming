package hienpd.practice.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Algorithm {
	public static void main(String[] args) {
		var g = new Graph<Integer>();
		g.addEdge(1, 2);
		g.addEdge(4, 5);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 6);
		// g.dfs(1);
		g.bfs(1);

		var gStr = new Graph<String>();
		gStr.addEdge("1", "2");
		gStr.addEdge("4", "5");
		gStr.addEdge("1", "3");
		gStr.addEdge("3", "4");
		gStr.addEdge("3", "6");
		// g.dfs(1);
		gStr.bfs("1");

	}

	static class Graph<T> {
		Map<T, List<T>> graph;

		Graph() {
			graph = new HashMap<T, List<T>>();
		}

		void addEdge(T node1, T node2) {
			if (graph.get(node1) == null) {
				graph.put(node1, new ArrayList<T>());
			}
			if (graph.get(node2) == null) {
				graph.put(node2, new ArrayList<T>());
			}
			graph.get(node1).add(node2);
		}

		void dfs(T startNode) {
			var visited = new HashMap<T, Boolean>();
			for (var e : graph.entrySet()) {
				visited.put(e.getKey(), false);
			}
			Deque<T> stack = new LinkedList<T>();
			stack.addFirst(startNode);
			while (!stack.isEmpty()) {
				var node = stack.removeFirst();
				System.out.println(node);
				visited.put(node, true);
				for (var e : graph.get(node)) {
					if (!visited.get(e)) {
						stack.addFirst(e);
					}

				}
			}
		}

		void bfs(T startNode) {
			var visited = new HashMap<T, Boolean>();
			for (var e : graph.entrySet()) {
				visited.put(e.getKey(), false);
			}
			Deque<T> queue = new LinkedList<T>();
			queue.addLast(startNode);
			while (!queue.isEmpty()) {
				var node = queue.removeFirst();
				System.out.println(node);
				visited.put(node, true);
				for (var e : graph.get(node)) {
					if (!visited.get(e)) {
						queue.addLast(e);
					}

				}
			}
		}
	} // End of Graph class

}
