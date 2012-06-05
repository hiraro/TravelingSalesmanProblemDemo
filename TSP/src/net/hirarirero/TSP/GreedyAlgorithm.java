package net.hirarirero.TSP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GreedyAlgorithm {
	private EdgeList edgelist;
	private List<Vertex> inputPts;
	private Map<Vertex,Vertex> result;

	public GreedyAlgorithm(List<Vertex> ls, EdgeList els) {
		edgelist = els;
		inputPts = ls;
		result = new HashMap<Vertex,Vertex>();
	}

	private boolean degLessThan2(Edge e) {
		return (e.vs.get(0).edges.size() < 2) && (e.vs.get(1).edges.size() < 2);
	}

	private boolean checkFlag(Edge e) {
		return !e.vs.get(0).group.equals(e.vs.get(1).group);
	}

	public Map<Vertex,Vertex> exec() {
		int i = 0;
		Edge e;
		Vertex v0,v1;
		double d = 0;
		Set<Vertex> newset;
		do {
			e = edgelist.get(i);
			if (degLessThan2(e)
					&& ((checkFlag(e) || (i == edgelist.size() - 1)))) {
				v0=e.vs.get(0) ;
				v1=e.vs.get(1);
				newset=new HashSet<Vertex>();
				newset.addAll(v0.group.vset);
				newset.addAll(v1.group.vset);
				v0.group.vset=newset;
				v1.group.vset=newset;
				v0.edges.add(e);
				v1.edges.add(e);
				result.put(v0, v1);
				result.put(v1, v0);
				d += e.length;
			}
			i++;
		} while (i < edgelist.size());
		System.out.println("Distance : "+d+"\n");
		
		return  result;
	}
}
