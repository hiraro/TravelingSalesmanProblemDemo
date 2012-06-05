package net.hirarirero.TSP;

import java.util.List;
import java.util.Map;

public class Main {
public static final String OUTPUT_DELIM=" ";
public static final String 	INPUT_DELIM = " ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputFileReader ifr = new InputFileReader("data.txt");
		List<Vertex> ls = ifr.readFile();
//		for(Vertex v:ls){
//			System.out.println(v);
//		}
		EdgeList els = new EdgeList();
		els.makeLengthList(ls);
		GreedyAlgorithm ga=new GreedyAlgorithm(ls, els);
		Map<Vertex,Vertex> eres =ga.exec();
		Vertex v=ls.get(0);
		Vertex vx=v;
		do{
			vx=eres.get(vx);
			System.out.println(vx);
		}while(vx!=v);
	}
}
