package net.hirarirero.TSP.graph;

import java.util.HashSet;
import java.util.Set;

public class Edge {

	Set<Integer> vertexs = new HashSet<Integer>();

	public Edge(int v0, int v1) {
		vertexs.add(v0);
		vertexs.add(v1);
	}

	public Edge() {

	}

	public void addVertex(int v) {
		vertexs.add(v);
	}

	public void removeVertex(int v) {
		vertexs.remove(v);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertexs == null) ? 0 : vertexs.hashCode());
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
		if (vertexs == null) {
			if (other.vertexs != null)
				return false;
		} else if (!vertexs.equals(other.vertexs))
			return false;
		return true;
	}

}
