package net.hirarirero.TSP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class EdgeList {
	private List<Edge> edges;

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public EdgeList() {
		edges = new ArrayList<Edge>();
	}

	public EdgeList(List<Edge> ls) {
		setEdges(ls);
	}

	public int size() {
		return edges.size();
	}

	public Edge get(int i) {
		return edges.get(i);
	}

	public void makeLengthList(List<Vertex> pointList) {
		edges = new ArrayList<Edge>();
		int size = pointList.size();
		Edge e;
		Vertex p0, p1;
		for (int i = 0; i < size - 1; i++) {
			p0 = pointList.get(i);
			for (int j = i + 1; j < size; j++) {
				if (i != j) {
					e = new Edge();
					p1 = pointList.get(j);
					e.vs.add(p0);
					e.vs.add(p1);
					e.length = Point.distance(p0.x, p0.y, p1.x, p1.y);
					edges.add(e);
				}
			}
		}
		Collections.sort(edges, new MyComparator());
	}

	public void printCycle() {
		int init = 0;
		Edge e=edges.get(init);
		Vertex v=e.vs.get(init);
		List<Vertex> ls = new ArrayList<Vertex>();
		traverseEdges(v,e,ls);
	}

	public void print() {
		for (Edge e : edges) {
			System.out.println(e);
		}
	}

	private void traverseEdges(Vertex v,Edge e,List<Vertex> ls) {
		Vertex v0=e.vs.get(0);
		Vertex v1=e.vs.get(1);
		ls.add(v0);
		ls.add(v1);
		System.out.println(v);
		for (Edge ei : v.edges) {
			if (ei != e &&!ls.contains(ei)) {
				Vertex vn = v!=ei.vs.get(1)?ei.vs.get(1):ei.vs.get(0);
				traverseEdges(vn,ei, ls);
			}
		}
	}

	public class MyComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			// TODO 自動生成されたメソッド・スタブ
			return (int) (o1.length - o2.length);
		}

	}

}
