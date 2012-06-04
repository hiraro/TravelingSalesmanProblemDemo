package net.hirarirero.TSP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputFileReader {

	public static final String DELIM = " ";
	private LineNumberReader lnr;

	public InputFileReader(String pathname) {
		this(new File(pathname));
	}

	public InputFileReader(File file) {
		try {
			lnr = new LineNumberReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public List<Vertex> readFile() {
		String line;
		ArrayList<Vertex> ret = new ArrayList<Vertex>();
		StringTokenizer st;
		int x, y;
		try {
			do {
				line = lnr.readLine();
				if (line != null) {
					st = new StringTokenizer(line, DELIM);
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					ret.add(new Vertex(x, y, lnr.getLineNumber()));
				}
			} while (line != null);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return ret;
	}
}
