package net.hirarirero.TSP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vertex extends Point {

	public List<Edge> edges=new ArrayList<Edge>();
	public VertexSet group;
	public Vertex(int x,int y,int id){
		super(x,y);
		group=new VertexSet();
		group.vset.add(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
//		result = prime * result + ((group == null) ? 0 : group.hashCode());
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
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		return true;
	}
	public String toString(){
		return x+Main.OUTPUT_DELIM+y+Main.OUTPUT_DELIM;
	}
}
