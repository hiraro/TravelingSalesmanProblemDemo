package net.hirarirero.TSP.graph;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * ���̑��֐�.
 * @author h1231075
 *
 */
public class Util {

	/**
	 * ��_�ԋ��������߂�.
	 * @param v0
	 * @param v1
	 * @return ��_�ԋ���
	 */
	public static double length(Vertex v0, Vertex v1) {
		return Point.distance(v0.x, v0.y, v1.x, v1.y);
	}

	/**
	 * �^����ꂽ�H�̑��������v�Z����.
	 * @param ls �H�̒��_���W���X�g
	 * @return ������
	 */
	public static double distance(List<Vertex> ls) {
		double ret = 0;
		Vertex prev = ls.get(0);
		for (Vertex v : ls) {
			ret += length(prev, v);
			prev = v;
		}
		return ret;
	}

	/**
	 * �H�̒��_���W���X�g���璸�_�ԍ����X�g���擾����.
	 * @param ls �H�̒��_���W���X�g
	 * @return	���_�ԍ����X�g
	 */
	public static List<Integer> asVertexNum(List<Vertex> ls) {
		List<Integer> ret = new ArrayList<Integer>();
		Iterator<Vertex> it = ls.iterator();
		Vertex v;
		while (it.hasNext()) {
			v = it.next();
			if (it.hasNext()) {
				ret.add(v.n);
			}
		}
		return ret;
	}

}
