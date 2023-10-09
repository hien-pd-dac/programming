package hienpd.practice.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Graph<T> {
	class Vertex {
		private T value;
		private List<Vertex> adjVertices;

		Vertex(T value) {
			this.value = value;
			this.adjVertices = new ArrayList<Vertex>();
		}

		T getValue() {
			return this.value;
		}

		List<Vertex> getAdjVertices() {
			return this.adjVertices;
		}

		boolean addAdjVertex(Vertex v) {
			return this.adjVertices.add(v);
		}
	}

	private Map<T, Vertex> graph;

	public Graph() {
		graph = new HashMap<T, Vertex>();
	}

	public void addEdge(T from, T to) {
		var fromV = graph.get(from);
		if (fromV == null) {
			fromV = new Vertex(from);
			graph.put(from, fromV);
		}
		var toV = graph.get(to);
		if (toV == null) {
			toV = new Vertex(to);
			graph.put(to, toV);
		}
		fromV.addAdjVertex(toV);
	}

	public boolean dfs(T from, T target) {
		var fromV = graph.get(from);
		if (fromV == null) {
			return false;
		}
		if (graph.get(target) == null) {
			return false;
		}

		var visited = new HashSet<T>();
		Deque<Vertex> stack = new LinkedList<Vertex>();
		stack.addFirst(fromV);
		while (!stack.isEmpty()) {
			var vertex = stack.removeFirst();
			if (vertex.getValue() == target) {
				return true;
			}
			visited.add(vertex.getValue());
			for (var adjV : vertex.getAdjVertices()) {
				if (!visited.contains(adjV.getValue())) {
					stack.addFirst(adjV);
				}

			}
		}
		return false;
	}

	public boolean bfs(T from, T target) {
		var fromV = graph.get(from);
		if (fromV == null) {
			return false;
		}
		if (graph.get(target) == null) {
			return false;
		}

		var visited = new HashSet<T>();
		Deque<Vertex> stack = new LinkedList<Vertex>();
		stack.addLast(fromV);
		while (!stack.isEmpty()) {
			var vertex = stack.removeFirst();
			if (vertex.getValue() == target) {
				return true;
			}
			visited.add(vertex.getValue());
			for (var adjV : vertex.getAdjVertices()) {
				if (!visited.contains(adjV.getValue())) {
					stack.addLast(adjV);
				}

			}
		}
		return false;
	}
}
