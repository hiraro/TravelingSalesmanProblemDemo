package net.hirarirero.TSP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Edge {
	public List<Vertex> vs = new ArrayList<Vertex>();
	public double length = 0;

	public String toString() {
		return vs.get(0)+Main.OUTPUT_DELIM+vs.get(1)+Main.OUTPUT_DELIM+length;
	}
}