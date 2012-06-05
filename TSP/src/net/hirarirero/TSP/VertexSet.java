package net.hirarirero.TSP;

import java.util.HashSet;
import java.util.Set;

public class VertexSet {
	public Set<Vertex> vset = new HashSet<Vertex>();

	public void addAll(Set<Vertex> s) {
		vset.addAll(s);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vset == null) ? 0 : vset.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VertexSet other = (VertexSet) obj;
		if (vset == null) {
			if (other.vset != null)
				return false;
		} else if (!vset.equals(other.vset))
			return false;
		return true;
	}


}
