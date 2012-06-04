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
	private List<Edge> edges = new ArrayList<Edge>();
	private List<Vertex> pointList;

	public EdgeList(List<Vertex> ls) {
		pointList = ls;
	}

	public int size(){
		return edges.size();
	}

	public Edge get(int i){
		return edges.get(i);
	}

	public void culcDistance() {
		int size = pointList.size();
		Edge e;
		Set<Integer> s;
		Point p0, p1;
		for (int i = 0; i < size-1; i++) {
			p0 = pointList.get(i);
			for (int j = i+1; j < size; j++) {
				e = new Edge();
				s = new HashSet<Integer>();
				s.add(i);
				s.add(j);
				e.pts = s;
				p1 = pointList.get(j);
				e.distance = Point.distance(p0.x, p0.y, p1.x, p1.y);
				if (i != j) {
					edges.add(e);
				}
			}
		}
		Collections.sort(edges, new MyComparator());
	}

	protected void printAll() {
		for (int i=0;i<edges.size();i++) {
			System.out.println(edges.get(i));
		}
	}

	public class MyComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			// TODO 自動生成されたメソッド・スタブ
			return (int) (o1.distance - o2.distance);
		}

	}

}
