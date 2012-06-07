package net.hirarirero.TSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.hirarirero.TSP.graph.Util;
import net.hirarirero.TSP.graph.Vertex;

public class Greedy {
	private List<Vertex> cycleAsVertex;
	private List<Vertex> input;
	private boolean[] visited;

	public Greedy(List<Vertex> ls) {
		input=new ArrayList<Vertex>(ls);
	}

	public void exec() {
		visited=new boolean[input.size()];
		cycleAsVertex = new ArrayList<Vertex>();
		int i = 0;
		int size = input.size();
		Vertex v = input.get(0);
		Vertex vn = findNearest(v);
		visited[v.n]= true;
		cycleAsVertex.add(v);
		while (vn != null) {
			visited[vn.n]=true;
			cycleAsVertex.add(vn);
			v = vn;
			vn = findNearest(v);
			i++;
			Main.LOGGER.info((double) 100 * i / size + "%");
		}
		cycleAsVertex.add(input.get(0));
		Main.LOGGER.info("Done");
	}

	public Vertex findNearest(Vertex v) {
		double min = Double.MAX_VALUE;
		double temp;
		Vertex vi;
		Vertex ret = null;
		for (int i = 0; i < input.size(); i++) {
			if (i != v.n) {
				vi = input.get(i);
				if (!visited[vi.n]) {
					temp = Util.length(vi, v);
					if (min > temp) {
						ret = vi;
						min = temp;
					}
				}
			}
		}
		return ret;
	}


	public List<Vertex> getCycle() {
		return cycleAsVertex;
	}

}
