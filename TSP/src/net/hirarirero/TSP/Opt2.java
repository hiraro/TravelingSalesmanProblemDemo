package net.hirarirero.TSP;

import java.util.Collections;
import java.util.List;

import net.hirarirero.TSP.graph.Vertex;
import net.hirarirero.TSP.graph.Util;

public class Opt2 {
	private List<Vertex> input;
	private List<Vertex> cycle;
	private Util util;

	public Opt2(List<Vertex> ls, List<Vertex> cycle, Util util) {
		this.input = ls;
		this.cycle = cycle;
		this.util = util;
	}

	public void exec() {
		boolean flag = true;
		int i1, j1, count = 0;
		double[] l = new double[4];
		List<Vertex> temp ;
		while (flag) {
			count = 0;
			for (int i = 0; i < input.size() - 2; i++) {
				i1 = i + 1;
				for (int j = i + 2; j < input.size(); j++) {
					if (j == input.size() - 1) {
						j1 = 0;
					} else {
						j1 = j + 1;
					}
					if (i != 0 || j1 != 0) {
						l[0] = util.length(cycle.get(i), cycle.get(i1));
						l[1] = util.length(cycle.get(j), cycle.get(j1));
						l[2] = util.length(cycle.get(i), cycle.get(j));
						l[3] = util.length(cycle.get(i1), cycle.get(j1));
						if (l[0] + l[1] > l[2] + l[3]) {
							temp=cycle.subList(i1, j+1);
							Collections.reverse(temp);
							for(int k=i1;k<j+1;k++){
								cycle.set(k, temp.get(k-i1));
							}
							count++;
						}
					}
				}
			}
			Main.LOGGER.info(String.valueOf(count));
			if (count == 0) {
				flag = false;
			}
		}
	}

	public List<Vertex> getCycle() {
		return cycle;
	}
}