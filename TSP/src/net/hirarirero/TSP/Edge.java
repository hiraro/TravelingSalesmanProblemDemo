package net.hirarirero.TSP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Edge {
	public List<Vertex> vs = new ArrayList<Vertex>();
	public double length = 0;

	public String toString() {
		return vs.get(0)+"\n"+vs.get(1)+"\n";
	}
}