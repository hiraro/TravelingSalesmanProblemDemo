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

public class Util {
	private List<Vertex> input;

	public Util(List<Vertex> in) {
		input = in;
	}

	public double length(Vertex v0, Vertex v1) {
		return Point.distance(v0.x, v0.y, v1.x, v1.y);
	}

	public Vertex findNearest(Vertex v) {
		double min = Double.MAX_VALUE;
		double temp;
		Vertex vi, ret = null;
		for (int i = 0; i < input.size(); i++) {
			if (i != v.n) {
				vi = input.get(i);
				if (!vi.visited) {
					temp = length(vi, v);
					if (min > temp) {
						ret = vi;
						min = temp;
					}
				}
			}
		}
		return ret;
	}

	//public Static double distance()

}
