package net.hirarirero.TSP.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import net.hirarirero.TSP.Main;

/**
 * 入力頂点ファイルの処理.
 * @author h1231075
 *
 */
public class VertexFileReader {

	private BufferedReader br;

	public VertexFileReader(String pathname) {
		this(new File(pathname));
	}

	public VertexFileReader(File file) {
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 頂点ファイルを一行ずつ読み込む.
	 * @return	読み込んだ頂点のリスト
	 */
	public List<Vertex> readFile() {
		String line;
		ArrayList<Vertex> ret = new ArrayList<Vertex>();
		StringTokenizer st;
		int x, y, i = 0;
		try {
			line = br.readLine();
			while (line != null) {
				//スペース区切りなので
				st = new StringTokenizer(line, Main.INPUT_DELIM);
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				ret.add(new Vertex(x, y, i));
				line = br.readLine();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Main.LOGGER.info("Loaded");
		return ret;
	}
}
