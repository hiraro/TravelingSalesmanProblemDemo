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
		// ���̓f�[�^�̓ǂݍ���
		VertexFileReader ifr = new VertexFileReader("data.txt");
		List<Vertex> in = ifr.readFile();
		// �~����@�A���S���Y���̏�����
		Greedy greedy = new Greedy(in);
		long greedyStart = System.currentTimeMillis();
		// ���Ԍv���p���[�v
		for (int i = 0; i < LOOP_COUNT; i++) {
			greedy = new Greedy(in);
			// �~����@�A���S���Y���̎��s
			greedy.exec();
		}
		long greedyEnd = System.currentTimeMillis();
		// ���ʂ̒��_���W�f�[�^���X�g
		List<Vertex> res = greedy.getCycle();
		double disanceBeforeOpt2 = Util.distance(res);
		// 2-Opt�@�A���S���Y���̏�����
		Opt2 opt = new Opt2(in, res);
		long opt2Start = System.currentTimeMillis();
		// ���Ԍv���p���[�v
		for (int i = 0; i < LOOP_COUNT; i++) {
			opt = new Opt2(in, res);
			// 2-Opt�@�A���S���Y�����s
			opt.exec();
		}
		long opt2End = System.currentTimeMillis();
		// ���ʂ̒��_���W�f�[�^���X�g
		res = opt.getCycle();
		double disanceAfterOpt2 = Util.distance(res);
		// ���ʂ̒��_�ԍ��f�[�^���X�g
		List<Integer> resNo = Util.asVertexNum(res);
		// �t�@�C���o�͊֌W
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
		// ���s���ԂƑ������̏o��
		LOGGER.info("AvgElapsedTimeOfGreedyAlgorithm : "
						+ ((greedyEnd - greedyStart) / (double) LOOP_COUNT));
		LOGGER.info("AvgElapsedTimeOfOpt-2 : "
						+ ((opt2End - opt2Start) / (double) LOOP_COUNT));
		LOGGER.info("DistanceBeforeOpt-2 : " + disanceBeforeOpt2);
		LOGGER.info("DistanceAfterOpt-2 : " + disanceAfterOpt2);

	}
}
