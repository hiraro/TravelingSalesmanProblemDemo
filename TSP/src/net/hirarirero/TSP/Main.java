package net.hirarirero.TSP;

import java.awt.Point;
import java.util.HashSet;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		InputFileReader ifr = new InputFileReader("data.txt");
		List<Vertex> ls = ifr.readFile();
//		for (Point p : ls) {
//			System.out.println(p);
//		}
		EdgeList m = new EdgeList(ls);
		m.culcDistance();
		//m.printAll();
		GreedyAlgorithm ga=new GreedyAlgorithm(ls, m);
		ga.exec();
	}

}
