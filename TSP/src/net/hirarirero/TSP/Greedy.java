package net.hirarirero.TSP;

import java.util.ArrayList;
import java.util.List;
import net.hirarirero.TSP.graph.VertexUtil;
import net.hirarirero.TSP.graph.Vertex;

public class Greedy {
	private List<Vertex> cycleAsPoint;
	private List<Integer> cycleAsNo;
	private List<Vertex> input;
	private VertexUtil lengthMap;
	private double distance;

	public Greedy(List<Vertex> ls, VertexUtil map) {
		input = ls;
		lengthMap = map;
	}

	public void exec() {
		cycleAsPoint = new ArrayList<Vertex>();
		cycleAsNo = new ArrayList<Integer>();
		distance = 0;
		int i = 0, size = input.size();
		Vertex v = input.get(0);
		Vertex vn = lengthMap.findNearest(v);
		v.visited = true;
		cycleAsPoint.add(v);
		cycleAsNo.add(v.n);
		while (vn != null) {
			visit(v, vn);
			v = vn;
			vn = lengthMap.findNearest(v);
			i++;
			Main.LOGGER.info((double) 100 * i / size + "%");
		}
		cycleAsPoint.add(input.get(0));
		distance += lengthMap.distance(v, cycleAsPoint.get(0));
	}

	private void visit(Vertex v0, Vertex v) {
		v.visited = true;
		cycleAsPoint.add(v);
		cycleAsNo.add(v.n);
		distance += lengthMap.distance(v0, v);
	}

	public List<Vertex> getCycle() {
		return cycleAsPoint;
	}

	public List<Integer> getCycleAsNo() {
		return cycleAsNo;
	}

	public double getDistance() {
		return distance;
	}
}
