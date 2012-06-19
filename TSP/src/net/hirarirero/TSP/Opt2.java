package net.hirarirero.TSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.hirarirero.TSP.graph.Vertex;
import net.hirarirero.TSP.graph.Util;

/**
 * 2-Opt�@�A���S���Y��.
 * @author h1231075
 *
 */
public class Opt2 {
	private List<Vertex> input;
	private List<Vertex> cycle;

	/**
	 * �R���X�g���N�^.
	 * @param ls	���͒��_���X�g
	 * @param cycle	�ߎ���
	 */
	public Opt2(List<Vertex> ls, List<Vertex> cycle) {
		this.input = new ArrayList<Vertex>(ls);
		this.cycle =new ArrayList<Vertex>(cycle);
	}

	/**
	 * �A���S���Y���̎��s.
	 */
	public void exec() {
		boolean flag = true;
		int i1;
		int j1;
		int count = 0;
		double[] l = new double[4];
		List<Vertex> temp ;
		//�ӂ̕t���ւ����s���Ȃ��Ȃ�܂Ń��[�v
		while (flag) {
			count = 0;
			for (int i = 0; i < input.size() - 2; i++) {
				i1 = i + 1;
				for (int j = i + 2; j < input.size(); j++) {
					if (j == input.size() - 1) {
						j1 = 0;
					} else {
						j1 = j + 1;
					}
					if (i != 0 || j1 != 0) {
						//�C��2�ӂɂ��Č������ƕ��s���̕ӂ̒������擾
						l[0] = Util.length(cycle.get(i), cycle.get(i1));
						l[1] = Util.length(cycle.get(j), cycle.get(j1));
						l[2] = Util.length(cycle.get(i), cycle.get(j));
						l[3] = Util.length(cycle.get(i1), cycle.get(j1));
						//�������̂ق�������������
						if (l[0] + l[1] > l[2] + l[3]) {
							temp=cycle.subList(i1, j+1);
							//�z����t���ɂ���
							Collections.reverse(temp);
							for(int k=i1;k<j+1;k++){
								cycle.set(k, temp.get(k-i1));
							}
							//�t���ւ��񐔂��L�^
							count++;
						}
					}
				}
			}
			Main.LOGGER.info(String.valueOf(count));
			//�ӂ̕t���ւ����s���Ȃ��Ȃ������߂�
			if (count == 0) {
				flag = false;
			}
		}
	}

	//���ʃ��X�g�̃Q�b�^
	public List<Vertex> getCycle() {
		return cycle;
	}
}
