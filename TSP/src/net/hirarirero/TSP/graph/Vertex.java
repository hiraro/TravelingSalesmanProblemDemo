package net.hirarirero.TSP.graph;

import java.awt.Point;
import net.hirarirero.TSP.Main;

public class Vertex extends Point implements Cloneable {
	private static final long serialVersionUID = 1L;
	public int n;

	public Vertex(int x, int y, int n) {
		super(x, y);
		this.n = n;
	}

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

	public String toString() {
		return x + Main.OUTPUT_DELIM + y + Main.OUTPUT_DELIM;
	}
}
