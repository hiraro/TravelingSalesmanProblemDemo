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
		Edge e=edges.get(0);
		traverseEdges(e,new ArrayList<Vertex>());
	}

	public void print() {
		for (Edge e : edges) {
			System.out.println(e);
		}
	}

	private void traverseEdges(Edge e,List<Vertex> ls) {
		Vertex v0=e.vs.get(0);
		Vertex v1=e.vs.get(1);
		v0.edges.remove(e);
		v1.edges.remove(e);
		if(ls.size()==0){
			ls.add(v0);
			System.out.println(v0);
			traverseEdges(v0.edges.get(0), ls);
		}else if(v0.edges.size()==1){
			ls.add(v0);
			System.out.println(v0);
			traverseEdges(v0.edges.get(0), ls);
		}else if(v1.edges.size()==1){
			ls.add(v1);
			System.out.println(v1);
			traverseEdges(v1.edges.get(0), ls);
		}else{
			Vertex v=!ls.contains(v0)?v0:v1;
			System.out.println(v);
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
