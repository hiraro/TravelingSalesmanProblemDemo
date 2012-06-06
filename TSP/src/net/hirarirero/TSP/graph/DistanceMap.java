package net.hirarirero.TSP.graph;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DistanceMap {
	private Map<Edge, Double> map;
	private List<Vertex> input;

	public DistanceMap(List<Vertex> in) {
		map = new HashMap<Edge, Double>();
		input = in;
		int size = input.size();
		Vertex v0, v1;
		Edge e;
		double length;
		for (int i = 0; i < size - 1; i++) {
			v0 = input.get(i);
			for (int j = i + 1; j < size; j++) {
				if (i != j) {
					v1 = input.get(j);
					e = new Edge(v0.n, v1.n);
					length = Point.distance(v0.x, v0.y, v1.x, v1.y);
					map.put(e, length);
				}
			}
		}
	}

	public double distance(Vertex v0, Vertex v1) {
		Edge e = new Edge(v0.n, v1.n);
		return map.get(e);
	}

	public Vertex findNearest(Vertex v) {
		double min = Double.MAX_VALUE;
		double temp;
		Vertex vi, ret = null;
		Edge e = new Edge();
		e.addVertex(v.n);
		for (int i = 0; i < input.size(); i++) {
			vi = input.get(i);
			if (!vi.visited) {
				e.addVertex(vi.n);
				temp = distance(vi, v);
				if (min > temp) {
					ret = vi;
					min = temp;
				}
				e.removeVertex(vi.n);
			}
		}
		return ret;
	}

}
