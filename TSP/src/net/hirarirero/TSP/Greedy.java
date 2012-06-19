package net.hirarirero.TSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.hirarirero.TSP.graph.Util;
import net.hirarirero.TSP.graph.Vertex;

/**
 * �~����@�A���S���Y��.
 * @author h1231075
 *
 */
public class Greedy {
	private List<Vertex> cycleAsVertex;
	private List<Vertex> input;
	private boolean[] visited;

	/**
	 * �R���X�g���N�^.
	 * @param ls ���͂̒��_���X�g
	 */
	public Greedy(List<Vertex> ls) {
		input=new ArrayList<Vertex>(ls);
	}

	/**
	 * �A���S���Y���̎��s.
	 * cycleAsVertex�Ɍ��ʂ̒��_���W���X�g����������.
	 */
	public void exec() {
		//����ς݃t���O�z��
		visited=new boolean[input.size()];
		cycleAsVertex = new ArrayList<Vertex>();
		int i = 0;
		//���͂̒���
		int size = input.size();
		//�����l�͍ŏ��̓_
		Vertex v = input.get(0);
		//�ŏ��̓_����ł��߂��_���v�Z
		Vertex vn = findNearest(v);
		//�ŏ��̓_������ς݂ɂ���
		visited[v.n]= true;
		//���ʃ��X�g�ɒǉ�
		cycleAsVertex.add(v);
		//������̍ŋߒ��_��������Ȃ��Ȃ�܂Ń��[�v
		while (vn != null) {
			//����ς݃t���O�̍X�V
			visited[vn.n]=true;
			//���ʃ��X�g�ɒǉ�
			cycleAsVertex.add(vn);
			//v��vn��ޔ�����
			v = vn;
			//v�̍ŋߒ��_vn�����߂�
			vn = findNearest(v);
			i++;
			Main.LOGGER.info((double) 100 * i / size + "%");
		}
		//�Ō�ɏ����l�̒��_�ɖ߂�
		cycleAsVertex.add(input.get(0));
		Main.LOGGER.info("Done");
	}

	/**
	 * �ŋ߂�������̒��_��P���Ɍv�Z.
	 * @param v �ŋߒ��_�����߂������_
	 * @return	�ŋߒ��_
	 */
	public Vertex findNearest(Vertex v) {
		double min = Double.MAX_VALUE;
		double temp;
		Vertex vi;
		Vertex ret = null;
		for (int i = 0; i < input.size(); i++) {
			if (i != v.n) {
				vi = input.get(i);
				if (!visited[vi.n]) {
					temp = Util.length(vi, v);
					if (min > temp) {
						ret = vi;
						min = temp;
					}
				}
			}
		}
		return ret;
	}

	//���ʃ��X�g�̃Q�b�^.
	public List<Vertex> getCycle() {
		return cycleAsVertex;
	}

}
