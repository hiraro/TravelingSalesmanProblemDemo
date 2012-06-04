package net.hirarirero.TSP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GreedyAlgorithm {
	private EdgeList edgelist;
	private List<Vertex> inputPts;
	private List<Edge> result;

	public GreedyAlgorithm(List<Vertex> ls, EdgeList els) {
		edgelist = els;
		inputPts = ls;
		result = new ArrayList<Edge>();
	}

	private boolean degLessThan2(Edge e) {
		return (e.vs.get(0).edges.size() < 2) && (e.vs.get(1).edges.size() < 2);
	}

	private boolean checkFlag(Edge e) {
		return e.vs.get(0).setID != e.vs.get(1).setID;
	}

	public EdgeList exec() {
		int i = 0;
		Edge e;
		double d = 0;
		do {
			e = edgelist.get(i);
			if (degLessThan2(e)
					&& ((checkFlag(e) || (i == edgelist.size() - 1)))) {
				e.vs.get(0).setID = e.vs.get(1).setID;
				e.vs.get(0).edges.add(e);
				e.vs.get(1).edges.add(e);
				result.add(e);
				d += e.length;
				//System.out.println(e);
			}
			i++;
		} while (i < edgelist.size());
		System.out.println(d);
		return new EdgeList(result);
	}
}
