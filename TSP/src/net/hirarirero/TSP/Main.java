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
	public static final Logger LOGGER
								= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final int LOOP_COUNT = 1;

	public static void main(String[] args) {
		LOGGER.setLevel(Level.INFO);
		// 入力データの読み込み
		VertexFileReader ifr = new VertexFileReader("data.txt");
		List<Vertex> in = ifr.readFile();
		// 欲張り法アルゴリズムの初期化
		Greedy greedy = new Greedy(in);
		long greedyStart = System.currentTimeMillis();
		// 時間計測用ループ
		for (int i = 0; i < LOOP_COUNT; i++) {
			greedy = new Greedy(in);
			// 欲張り法アルゴリズムの実行
			greedy.exec();
		}
		long greedyEnd = System.currentTimeMillis();
		// 結果の頂点座標データリスト
		List<Vertex> res = greedy.getCycle();
		double disanceBeforeOpt2 = Util.distance(res);
		// 2-Opt法アルゴリズムの初期化
		Opt2 opt = new Opt2(in, res);
		long opt2Start = System.currentTimeMillis();
		// 時間計測用ループ
		for (int i = 0; i < LOOP_COUNT; i++) {
			opt = new Opt2(in, res);
			// 2-Opt法アルゴリズム実行
			opt.exec();
		}
		long opt2End = System.currentTimeMillis();
		// 結果の頂点座標データリスト
		res = opt.getCycle();
		double disanceAfterOpt2 = Util.distance(res);
		// 結果の頂点番号データリスト
		List<Integer> resNo = Util.asVertexNum(res);
		// ファイル出力関係
		try {
			FileWriter fw = new FileWriter(new File("res"));
			BufferedWriter bw = new BufferedWriter(fw);
			FileWriter pfw = new FileWriter(new File("4plot"));
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
			e.printStackTrace();
		}
		// 実行時間と総距離の出力
		LOGGER.info("AvgElapsedTimeOfGreedyAlgorithm : "
						+ ((greedyEnd - greedyStart) / (double) LOOP_COUNT));
		LOGGER.info("AvgElapsedTimeOfOpt-2 : "
						+ ((opt2End - opt2Start) / (double) LOOP_COUNT));
		LOGGER.info("DistanceBeforeOpt-2 : " + disanceBeforeOpt2);
		LOGGER.info("DistanceAfterOpt-2 : " + disanceAfterOpt2);

	}
}
