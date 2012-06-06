package net.hirarirero.TSP.graph;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import net.hirarirero.TSP.Main;

public class Vertex extends Point {

	public List<Edge> edges = new ArrayList<Edge>();

	public Vertex(int x, int y) {
		super(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
//		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
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
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		return true;
	}

	public String toString() {
		return x + Main.OUTPUT_DELIM + y + Main.OUTPUT_DELIM;
	}
}
