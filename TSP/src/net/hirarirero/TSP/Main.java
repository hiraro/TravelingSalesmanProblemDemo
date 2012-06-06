package net.hirarirero.TSP;

import java.util.List;
import net.hirarirero.TSP.graph.DistanceMap;
import net.hirarirero.TSP.graph.VertexFileReader;
import net.hirarirero.TSP.graph.Vertex;

public class Main {
	public static final String OUTPUT_DELIM = " ";
	public static final String INPUT_DELIM = " ";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VertexFileReader ifr = new VertexFileReader("data.txt");
		List<Vertex> in = ifr.readFile();
		DistanceMap dmap = new DistanceMap(in);
		Greedy greedy = new Greedy(in, dmap);
		greedy.exec();
		List<Vertex> res = greedy.getCycle();
		for (Vertex v : res) {
			System.out.println(v);
		}
		System.out.println(greedy.getDistance());
	}
}
