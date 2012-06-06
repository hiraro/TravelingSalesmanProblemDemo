package net.hirarirero.TSP;

import java.util.List;
import java.util.Map;

import net.hirarirero.TSP.graph.EdgeList;
import net.hirarirero.TSP.graph.VertexFileReader;
import net.hirarirero.TSP.graph.Vertex;

public class Main {
public static final String OUTPUT_DELIM=" ";
public static final String 	INPUT_DELIM = " ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VertexFileReader ifr = new VertexFileReader("data.txt");
		List<Vertex> ls = ifr.readFile();
		EdgeList els = new EdgeList();
		els.makeLengthList(ls);
		GreedyAlgorithm ga=new GreedyAlgorithm(ls, els);
		EdgeList eres =ga.exec();
		eres.printCycle();
//		Vertex v=ls.get(0);
//		Vertex vx=v;
//		do{
//			vx=eres.get(vx);
//			System.out.println(vx);
//		}while(vx!=v);
	}
}
