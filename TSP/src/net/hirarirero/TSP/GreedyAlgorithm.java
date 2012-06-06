package net.hirarirero.TSP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.hirarirero.TSP.graph.Edge;
import net.hirarirero.TSP.graph.EdgeList;
import net.hirarirero.TSP.graph.Vertex;
import net.hirarirero.TSP.unionFind.UnionFind;

public class GreedyAlgorithm {
	private EdgeList edgelist;
	private List<Vertex> inputVertex;
	private List<Edge> result;
	private UnionFind uf;

	public GreedyAlgorithm(List<Vertex> ls, EdgeList els) {
		edgelist = els;
		inputVertex = ls;
		result = new ArrayList<Edge>();
		uf = new UnionFind(ls.size());
	}

	private boolean degLessThan2(Vertex v0, Vertex v1) {
		return (v0.edges.size() < 2) && (v1.edges.size() < 2);
	}

	private boolean checkSet(Vertex v0, Vertex v1) {
		return uf.find(inputVertex.indexOf(v0)) != uf.find(inputVertex.indexOf(v1));
	}

	public EdgeList exec() {
		int i = 0;
		Edge e;
		Vertex[] vs=new Vertex[2];
		double d = 0;
		boolean deg, set;
		e = edgelist.get(i);
		vs[0] = e.vs.get(0);
		vs[1] = e.vs.get(1);
		deg = degLessThan2(vs[0], vs[1]);
		set = (checkSet(vs[0], vs[1]));
		while (i < edgelist.size()) {
			if ((deg && set) ) {
				uf.union(inputVertex.indexOf(vs[0]), inputVertex.indexOf(vs[1]));
				vs[0].edges.add(e);
				vs[1].edges.add(e);
				result.add(e);
				d += e.length;
			}
			e = edgelist.get(i);
			vs[0] = e.vs.get(0);
			vs[1] = e.vs.get(1);
			deg = degLessThan2(vs[0], vs[1]);
			set = (checkSet(vs[0], vs[1]));
			i++;
		}
		i=0;
		for(Vertex v:inputVertex){
			if(v.edges.size()==1){
				vs[i]=v;
				i++;
			}
			
		}
		e=new Edge(vs[0], vs[1]);
		vs[0].edges.add(e);
		vs[1].edges.add(e);
		result.add(e);
		d+=e.length;
		System.out.println("Distance : " + d + "\n");
		return new EdgeList(result);
	}
}
