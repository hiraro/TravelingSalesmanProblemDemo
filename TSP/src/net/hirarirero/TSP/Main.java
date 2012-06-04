package net.hirarirero.TSP;

import java.util.List;

public class Main {
public static final String OUTPUT_DELIM=" ";
public static final String 	INPUT_DELIM = " ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputFileReader ifr = new InputFileReader("data.txt");
		List<Vertex> ls = ifr.readFile();
		EdgeList els = new EdgeList();
		els.makeLengthList(ls);
		GreedyAlgorithm ga=new GreedyAlgorithm(ls, els);
		EdgeList eres =ga.exec();
		eres.printCycle();
	}
}
