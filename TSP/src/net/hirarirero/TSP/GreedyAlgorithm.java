package net.hirarirero.TSP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GreedyAlgorithm {
	private static final int INITIAL_PT = 0;
	private EdgeList edgelist;
	private List<Vertex> inputPts;
	private List<Point> result;

	public GreedyAlgorithm(List<Vertex> ls, EdgeList els) {
		edgelist = els;
		inputPts = ls;
		result = new ArrayList<Point>();
	}

	private boolean degLessThan2(Object[] vs) {
		return (inputPts.get((Integer) vs[0]).edges < 2) && (inputPts.get((Integer) vs[1]).edges < 2);
	}

	private boolean checkFlag(Object[] vs) {
		return inputPts.get((Integer) vs[0]).setID != inputPts.get((Integer) vs[1]).setID;
	}

	public void exec() {
		int i = 0;
		Edge e = edgelist.get(i);
		Object[] pts = e.pts.toArray();
		double d=0;
		while (i < edgelist.size()) {
			if (degLessThan2(pts) && (checkFlag(pts) || i == edgelist.size() - 1)) {
				inputPts.get((Integer) pts[0]).setID = inputPts.get((Integer) pts[1]).setID;
				inputPts.get((Integer) pts[0]).edges += 1;
				inputPts.get((Integer) pts[1]).edges += 1;
				Point p = inputPts.get((Integer) pts[0]);
				result.add(p);
				System.out.println(p);
				d+=e.distance;
			}
			e = edgelist.get(i);
			pts = e.pts.toArray();
			i++;
		}
		System.out.println(d);
	}
}
