package net.hirarirero.TSP;

import java.awt.Point;
import java.util.HashSet;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
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
