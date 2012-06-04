package net.hirarirero.TSP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Edge {
	public Set<Integer> pts = new HashSet<Integer>();
	public double distance = 0;
	public List<Vertex> vls;

	public void setVertexList(List<Vertex> ls) {
		vls = ls;
	}

	public String toString() {
		Object[] pt = pts.toArray();
		return vls.get((Integer) pt[0]).toString() + "\n"
				+ vls.get((Integer) pt[1]).toString();
	}
}
