package net.hirarirero.TSP.graph;

import java.awt.Point;
import net.hirarirero.TSP.Main;

/**
 * ���_��\���N���X.
 * @author h1231075
 *
 */
public class Vertex extends Point {
	private static final long serialVersionUID = 1L;
	public int n;

	/**
	 * �R���X�g���N�^.
	 * @param x	x���W
	 * @param y	y���W
	 * @param n	���_�ԍ�
	 */
	public Vertex(int x, int y, int n) {
		super(x, y);
		this.n = n;
	}


	//List�p��Override
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + n;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (n != other.n)
			return false;
		return true;
	}

	//�o�͎��̕\�L
	public String toString() {
		return x + Main.OUTPUT_DELIM + y + Main.OUTPUT_DELIM;
	}
}
