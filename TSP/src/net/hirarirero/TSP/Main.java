package net.hirarirero.TSP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.hirarirero.TSP.graph.Util;
import net.hirarirero.TSP.graph.VertexFileReader;
import net.hirarirero.TSP.graph.Vertex;

public class Main {
	public static final String OUTPUT_DELIM = " ";
	public static final String INPUT_DELIM = " ";
	public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.setLevel(Level.INFO);
		VertexFileReader ifr = new VertexFileReader("data.txt");
		List<Vertex> in = ifr.readFile();
		Util util = new Util(in);
		Greedy greedy = new Greedy(in, util);
		greedy.exec();
		List<Integer> resNo = greedy.getCycleAsNo();
		List<Vertex> res = greedy.getCycle();
		Opt2 op=new Opt2(in, res, util);
		op.exec();
		res=op.getCycle();
		try {
			FileWriter fw = new FileWriter(new File("res"));
			BufferedWriter bw = new BufferedWriter(fw);
			FileWriter pfw = new FileWriter(new File("plot"));
			BufferedWriter pbw = new BufferedWriter(pfw);
			for (int i = 0; i < resNo.size(); i++) {
				bw.write(String.valueOf(resNo.get(i) + 1));
				bw.write(OUTPUT_DELIM);
				if ((i + 1) % 8 == 0) {
					bw.write("\n");
				}
			}
			for (int i = 0; i < res.size(); i++) {
				pbw.write(res.get(i).toString());
				pbw.write("\n");
			}
			bw.flush();
			bw.close();
			pbw.flush();
			pbw.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		LOGGER.info("Distance : " + greedy.getDistance());
	}
}
